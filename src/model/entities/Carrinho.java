package model.entities;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {
	
	private Map<Produto, Integer> cart;
	
	public Carrinho() {
		this.cart = new HashMap<>();
	}

	public Map<Produto, Integer> getProdutos() {
		return cart;
	}
	
}
