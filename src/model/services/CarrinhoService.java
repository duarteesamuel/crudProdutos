package model.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import model.entities.Produto;
import model.repositories.CarrinhoRepository;

public class CarrinhoService{
	
	private CarrinhoRepository carrinhoRepository;
	
	public CarrinhoService(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}
	
	
	public void buyProduct(int id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		carrinhoRepository.buyProduct(id);
		System.out.println("Product added successfully!");
	}
	
	
	public void removeProduct(int id) {
		//Implementar lógica
	}
	
	
	public void finalizePurchase() {
		//Implentar lógica
	}
	
	
	public Map<Produto, Integer> viewCart() {
		Map<Produto, Integer> cart = carrinhoRepository.getCartContents();
		
		if(cart.isEmpty()) {
			throw new IllegalArgumentException("Cart is Empty.");
		}
		double total = 0.0;
		for(Map.Entry<Produto, Integer> entry : cart.entrySet()) {
			Produto produto = entry.getKey();
			int quantity = entry.getValue();
			double productTotal = quantity * produto.getPrice();
			total += productTotal;
			System.out.printf("|Produto: %s \n|Quantity: %d \n|Subtotal: R$ %.2f%n", produto.getName(), quantity, productTotal);
			System.out.println();
		}
		System.out.printf("|Total value: R$ %.2f|%n", total);
		return cart;
	}

	
}
