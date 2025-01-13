package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Produto;
import model.repositories.ProdutoRepository;

public class ProdutoService implements ProdutoRepository{
	
	private List<Produto> produtos = new ArrayList<>();
	
	@Override
	public void create(Produto produto) {
		try {
			if(produto.getName().isEmpty()) {
				throw new IllegalArgumentException("Error: product name cannot be null.");
			}
			if(produto.getPrice() <= 0) {
				throw new IllegalArgumentException("Error: product value less than or equal to 0");
			}
			
			produtos.add(produto);
			System.out.println("Product registered in stock.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void update(int id, Produto updateProduto) {
		try {
			Produto produto = findById(id);
			if(produto != null) {
				produto.setName(updateProduto.getName());
				produto.setPrice(updateProduto.getPrice());
				System.out.println("Product updated: " + produto);
			}
			else {
				throw new NullPointerException("Error: Product not found!");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void delete(int id) {
		try {
			Produto produto = findById(id);
				if(produto != null) {
					produtos.remove(produto);
					System.out.println("Product removed successfully!");
				}
				else {
					throw new NullPointerException("Error: Product not found!");
				}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List<Produto> listAll(){
		try {
			if(produtos.isEmpty()) {
				throw new NullPointerException("Stock is empty!");
			}
			return produtos;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Produto findById(int id) {
		return produtos.stream()
				.filter(produto -> produto.getId() == id)
				.findFirst()
				.orElse(null);
		
	}

	
}
