package com.jccs.estoque.core.dto;

import java.io.Serializable;

public class PrecoDto implements Serializable
{
	public String codigoProduto;
	public double preco;

	public String getCodigoProduto()
	{
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto)
	{
		this.codigoProduto = codigoProduto;
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
