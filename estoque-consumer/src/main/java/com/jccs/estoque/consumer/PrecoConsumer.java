package com.jccs.estoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jccs.estoque.core.constantes.RabbitmqConstantes;
import com.jccs.estoque.core.dto.PrecoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PrecoConsumer
{

	@RabbitListener(queues = RabbitmqConstantes.FILA_PRECO)
	private void consumidor(String msg) throws JsonProcessingException, InterruptedException {
		PrecoDto precoDto = new ObjectMapper().readValue(msg, PrecoDto.class);

		System.out.println(precoDto.codigoProduto);
		System.out.println(precoDto.preco);
		System.out.println("------------------------------------");

		//Thread.sleep(1200);
	}
}
