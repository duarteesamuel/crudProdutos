package model.repositories;

import java.util.Map;

import model.entities.Produto;

public interface CarrinhoRepository {
	
	void addProduct(Produto produto, Integer quantity);
	void removeProduct(int id);
	void finalizePurchase();
	Map<Produto, Integer> viewCart();
	
}
