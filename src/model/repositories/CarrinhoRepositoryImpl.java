package model.repositories;

import java.util.HashMap;
import java.util.Map;

import model.entities.Produto;

public class CarrinhoRepositoryImpl implements CarrinhoRepository{
	
	private Map<Produto, Integer> cart;
	private ProdutoRepository produtoRepository;
	
	public CarrinhoRepositoryImpl(ProdutoRepository produtoRepository) {
		this.cart = new HashMap<>();
		this.produtoRepository = produtoRepository;
	}
		
	@Override
	public void addProduct(Produto produto, Integer quantity) {
		if(cart.containsKey(produto)) {
			cart.put(produto, cart.get(produto) + quantity);
		} else {
			cart.put(produto, quantity);
		}
	}
	
	@Override
	public void removeProduct(int id) {
		for(Map.Entry<Produto, Integer> entry : cart.entrySet()) {
			if(entry.getKey().getId().equals(id)) {
				cart.remove(entry.getKey());
			}
		}
	}


	@Override
	public void finalizePurchase() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Map<Produto, Integer> viewCart() {
		return cart;
	}
	
}
