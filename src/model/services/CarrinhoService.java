package model.services;

import java.util.HashMap;
import java.util.Map;

import model.entities.Produto;
import model.repositories.CarrinhoRepository;

public class CarrinhoService implements CarrinhoRepository{
	
	private CarrinhoRepository carrinhoRepository;
	
	public CarrinhoService(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}
	
	@Override
	public void buyProduct(int id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id");
		}
		
		carrinhoRepository.addProduct(id);
		System.out.println("Product added successfully!");
	}
	
	@Override
	public void removeProduct(int id) {
		
	}
	
	@Override
	public void finalizePurchase() {
		//Implentar lógica
	}
	
	@Override
	public Map<Produto, Integer> viewCart() {
		return carrinhoRepository.viewCart();
	}
}
