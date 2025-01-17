package model.repositories;

import java.util.HashMap;
import java.util.Map;

import model.entities.Produto;

public class CarrinhoRepositoryImpl implements CarrinhoRepository{
	
	private Map<Produto, Integer> cart = new HashMap<>();
	private ProdutoRepository produtoRepository;
	
	public CarrinhoRepositoryImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public void buyProduct(int id) {
		Produto produto = produtoRepository.findById(id);
		
		if(produto != null) {
			if(cart.containsKey(produto)) {
				int quantity = cart.get(produto);
				cart.put(produto, quantity + 1);
			} else {
				cart.put(produto, 1);
			}
		} else {
			throw new IllegalArgumentException("Product with ID " + id + " not found!");
		}
	}
	
	@Override
	public void removeProduct(int id) {
		Produto produto = produtoRepository.findById(id);
		if(produto != null && cart.containsKey(produto)) {
			cart.remove(produto);
		} else {
			throw new IllegalArgumentException("Product with ID " + id + " not found!");
		}
	}

	@Override
	public void finalizePurchase() {
		if(cart.isEmpty()) {
			throw new IllegalArgumentException("Cart is empty. Cannot finalize purchase.");
		}
		
		cart.clear();
	}
	
	@Override
	public Map<Produto, Integer> getCartContents() {
		return cart;
	}

	
}
