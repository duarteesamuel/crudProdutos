package model.repositories;

import java.util.ArrayList;
import java.util.List;

import model.entities.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository{
	
	private List<Produto> produtos = new ArrayList<>();
	
	@Override
	public void create(Produto produto) {
		produtos.add(produto);
	}
	
	@Override
	public void update(int id, Produto updateProduto) {
		Produto produto = findById(id);
		if(produto != null) {
			produto.setName(updateProduto.getName());
			produto.setPrice(updateProduto.getPrice());
		}
	}
	
	@Override
	public void delete(int id) {
		Produto produto = findById(id);
		if(produto != null) {
			produtos.remove(produto);
		}
	}
	
	
	@Override
	public List<Produto> listAll(){
		return produtos;
	}
	
	@Override
	public Produto findById(int id) {
		return produtos.stream()
			.filter(produto -> produto.getId() == id)
			.findFirst()
			.orElse(null);
	}
}
