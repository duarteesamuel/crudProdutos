package model.repositories;


import java.util.Map;

import model.entities.Produto;

public interface CarrinhoRepository {
	
	void buyProduct(int id);
	void removeProduct(int id);
	void finalizePurchase();
	Map<Produto, Integer> viewCart();
	
}
