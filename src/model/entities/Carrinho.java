package model.entities;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {
	
	private Map<Integer, Produto> produtos;
	
	public Carrinho() {
		this.produtos = new HashMap<>();
	}

	public Map<Integer, Produto> getProdutos() {
		return produtos;
	}
	
}
