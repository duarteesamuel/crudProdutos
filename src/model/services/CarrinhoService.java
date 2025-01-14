package model.services;

import java.util.Map;

import model.entities.Produto;
import model.repositories.CarrinhoRepository;
import model.repositories.ProdutoRepository;

public class CarrinhoService implements CarrinhoRepository{
	
	private CarrinhoRepository carrinhoRepository;
	
	public CarrinhoService(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}
	
	@Override
	public void addProduct(Produto produto, Integer quantity) {
		carrinhoRepository.addProduct(produto, quantity);
		System.out.println("Product added to cart successfully.");
	}
	
	@Override
	public void removeProduct(int id) {
		
	}
	
	@Override
	public void finalizePurchase() {
		
	}
	
	@Override
	public Map<Produto, Integer> viewCart() {
		Map<Produto, Integer> cart = carrinhoRepository.viewCart();
		
		if(cart.isEmpty()) {
			throw new IllegalArgumentException("The cart is empty.");
		} else {
			System.out.println("Items in cart:");
			for(Map.Entry<Produto, Integer> entry : cart.entrySet()) {
				Produto product = entry.getKey();
				Integer quantity = entry.getValue();
				System.out.printf("|Product: %s - Quantity: %dx ", product.getName(), quantity);
			}
		}
		return cart;
	}
}
