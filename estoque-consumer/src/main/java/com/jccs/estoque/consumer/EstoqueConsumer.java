package com.jccs.estoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jccs.estoque.core.constantes.RabbitmqConstantes;
import com.jccs.estoque.core.dto.EstoqueDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

	@RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
	private void consumidor(String msg) throws JsonProcessingException, InterruptedException {
		EstoqueDto estoqueDto = new ObjectMapper().readValue(msg, EstoqueDto.class);

		System.out.println(estoqueDto.codigoProduto);
		System.out.println(estoqueDto.quantidade);
		System.out.println("------------------------------------");

		//Thread.sleep(1200);
	}
}
