package model.repositories;

import java.util.List;

import model.entities.Produto;

public interface ProdutoRepository {
	
	void create(Produto produto);
	void update(int id, Produto updateProduto);
	void delete(int id);
	List<Produto> listAll();
	Produto findById(int id);
	
}
