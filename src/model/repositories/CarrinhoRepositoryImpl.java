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
				cart.put(produto, quantity);
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
		if(produto != null) {
			cart.remove(produto);
		}
	}

	@Override
	public Map<Produto, Integer> viewCart() {
		if(cart.isEmpty()) {
			throw new IllegalArgumentException("Cart is empty.");
		}
		
		for(Map.Entry<Produto, Integer> entry : cart.entrySet()) {
			Produto produto = entry.getKey();
			Integer quantity = entry.getValue();
			System.out.printf("|%s - x%d%n", produto.getName(), quantity);
		}
		return cart;
	}

	@Override
	public void finalizePurchase() {
		// TODO Auto-generated method stub
		
	}
	
}
