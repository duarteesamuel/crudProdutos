package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Produto;
import model.repositories.ProdutoRepository;

public class ProdutoService implements ProdutoRepository{
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public void create(Produto produto) {
		try {
			if(produto.getName().isEmpty()) {
				throw new IllegalArgumentException("Error: Product name cannot be null.");
			}
			if(produto.getPrice() <= 0) {
				throw new IllegalArgumentException("Error: Product value less than or equal 0.");
			}
			
			produtoRepository.create(produto);
			System.out.println("product registered in stock.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void update(int id, Produto updateProduto) {
		try {
			Produto produto = produtoRepository.findById(id);
			if(produto == null) {
				throw new IllegalArgumentException("Error: Product not found!");
			} else {
				produtoRepository.update(id, updateProduto);
				System.out.println("Product updated successfully!");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void delete(int id) {
		try {
			Produto produto = produtoRepository.findById(id);
			if(produto == null) {
				throw new IllegalArgumentException("Error: Product not found!");
			} else {
				produtoRepository.delete(id);
				System.out.println("Product removed successfully!");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public List<Produto> listAll(){
		List<Produto> produtos = produtoRepository.listAll();
		
		try {
			if(produtos.isEmpty()) {
				throw new IllegalArgumentException("Stock is empty!");
			} else {
				for(Produto p : produtos) {
					System.out.println(p);
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return produtos;
	}
	
	@Override
	public Produto findById(int id) {
		Produto produto = produtoRepository.findById(id);
		try {
			if(produto == null) {
				throw new IllegalArgumentException("Error: Product not found!");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return produto;
	}

	
}
