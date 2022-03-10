package com.jccs.estoque.core.dto;

import java.io.Serializable;

public class EstoqueDto implements Serializable
{
	public String codigoproduto;
	public int quantidade;

	public String getCodigoproduto()
	{
		return codigoproduto;
	}

	public void setCodigoproduto(String codigoproduto)
	{
		this.codigoproduto = codigoproduto;
	}

	public int getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(int quantidade)
	{
		this.quantidade = quantidade;
	}
}
