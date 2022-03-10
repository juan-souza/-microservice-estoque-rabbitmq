package com.jccs.estoque.core.estoque.api.conections;

import com.jccs.estoque.core.constantes.RabbitmqConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConection
{
	private AmqpAdmin amqpAdmin;

	public RabbitMQConection(AmqpAdmin amqpAdmin)
	{
		this.amqpAdmin = amqpAdmin;
	}

	private Queue fila(String nomeFila)
	{
		return new Queue(nomeFila, true, false, false);
	}

	//Recebe as mensagam e direcionar especificamente para a fila (troca direta)
	private DirectExchange exchange()
	{
		return new DirectExchange(RabbitmqConstantes.NOME_EXCHANGE);
	}

	//Relacionamento com a Fila
	private Binding relacionamento(Queue fila, DirectExchange troca)
	{
		return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(),
			fila.getName(), null);
	}

	//está função é executada assim que nossa classe é instanciada pelo Spring, devido a anotação @Component
	@PostConstruct
	private void adiciona()
	{
		Queue filaEstoque = this.fila(RabbitmqConstantes.FILA_ESTOQUE);
		Queue filaPreco = this.fila(RabbitmqConstantes.FILA_PRECO);

		DirectExchange troca = this.exchange();

		Binding ligacaoEstoque = this.relacionamento(filaEstoque, troca);
		Binding ligacaoPreco = this.relacionamento(filaPreco, troca);

		//Criando as filas no RabbitMQ
		this.amqpAdmin.declareQueue(filaEstoque);
		this.amqpAdmin.declareQueue(filaPreco);

		this.amqpAdmin.declareExchange(troca);
		this.amqpAdmin.declareBinding(ligacaoEstoque);
		this.amqpAdmin.declareBinding(ligacaoPreco);
	}
}
