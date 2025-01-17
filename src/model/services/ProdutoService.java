package model.services;

import java.util.List;

import model.entities.Produto;
import model.repositories.ProdutoRepository;

public class ProdutoService{
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
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
	
	public void update(int id, Produto updatedProduct) {
		Produto existingProduct = findById(id);
		if(existingProduct == null) {
			throw new IllegalArgumentException("Product with ID "+ id + " not found!");
		}
		
		existingProduct.setName(updatedProduct.getName());
		existingProduct.setPrice(updatedProduct.getPrice());
		produtoRepository.update(id, existingProduct);
		System.out.println("Product updated successfully!");
	}
	
	public void delete(int id) {
		Produto existingProduct = findById(id);
		if(existingProduct == null) {
			throw new IllegalArgumentException("Product with ID " + id + " not found!");
		}
		produtoRepository.delete(id);
		System.out.println("Product deleted successfully!");
	}
	
	
	public List<Produto> listAll(){
		List<Produto> produtos = produtoRepository.listAll();
		
		if(produtos.isEmpty()) {
			throw new IllegalArgumentException("Stock is empty!");
		} else {
			for(Produto p : produtos) {
				System.out.println(p);
			}
		}
		
		return produtos;
	}
	
	public Produto findById(int id) {
		Produto produto = produtoRepository.findById(id);
		if(produto == null) {
			throw new IllegalArgumentException("Error: Product with ID " + id + " not found!");
		}
		
		return produto;
	}

	
}
