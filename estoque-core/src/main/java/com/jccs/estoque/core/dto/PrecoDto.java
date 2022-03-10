package com.jccs.estoque.core.dto;

import java.io.Serializable;

public class PrecoDto implements Serializable
{
	public String codigoproduto;
	public double preco;

	public String getCodigoproduto()
	{
		return codigoproduto;
	}

	public void setCodigoproduto(String codigoproduto)
	{
		this.codigoproduto = codigoproduto;
	}

	public double getPreco()
	{
		return preco;
	}

	public void setPreco(double preco)
	{
		this.preco = preco;
	}
}
