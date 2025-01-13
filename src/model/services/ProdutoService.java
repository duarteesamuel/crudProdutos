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
		if(produto.getName().isEmpty()) {
			throw new IllegalArgumentException("Error: Product name cannot be null.");
		}
		if(produto.getPrice() <= 0) {
			throw new IllegalArgumentException("Error: Product value less than or equal 0.");
		}
		
		produtoRepository.create(produto);
		System.out.println("product registered in stock.");
	}
	
	@Override
	public void update(int id, Produto updateProduto) {
		Produto produto = produtoRepository.findById(id);
		if(produto == null) {
			throw new IllegalArgumentException("Error: Product not found!");
		}
		produtoRepository.update(id, updateProduto);
		System.out.println("Product updated successfully!");
	}
	
	@Override
	public void delete(int id) {
		Produto produto = produtoRepository.findById(id);
		if(produto == null) {
			throw new IllegalArgumentException("Error: Product not found!");
		}
		produtoRepository.delete(id);
		System.out.println("Product removed successfully!");
	}
	
	
	@Override
	public List<Produto> listAll(){
		List<Produto> produtos = produtoRepository.listAll();
		if(produtos.isEmpty()) {
			throw new NullPointerException("Stock is empty!");
		}
		return produtos;
	}
	
	@Override
	public Produto findById(int id) {
		Produto produto = produtoRepository.findById(id);
		if(produto == null) {
			throw new NullPointerException("Error: Product not found!");
		}
		return produto;
	}

	
}
