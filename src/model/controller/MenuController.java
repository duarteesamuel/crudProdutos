package model.controller;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Produto;
import model.services.ProdutoService;

public class MenuController {
	
	private ProdutoService produtoService;
	private Scanner sc;
	
	public MenuController(ProdutoService produtoService, Scanner sc) {
		this.produtoService = produtoService;
		this.sc = sc;
	}
	
	public void menu() {
		System.out.println("Stock Management System");
		System.out.println("=======================");
		System.out.println("1. Add Product");
		System.out.println("2. Update Product");
		System.out.println("3. Delete Product");
		System.out.println("4. List All Products");
		System.out.println("0. Exit");
		System.out.print("Select the option you want: ");
		int option = sc.nextInt();
		System.out.println("============================");
		sc.nextLine();
		
		switch(option){
		case 1:
			addProduct();
			break;
		case 2:
			updateProduct();
			break;
		case 3:
			deleteProduct();
			break;
		case 4:
			showProducts();
			break;
		case 0:
			System.out.println("Thank you for using the system.");
			System.exit(0);
		default:
			System.out.println("Invalid option please enter a valid integer!");
		}
		menu();
	}
	
	public void addProduct() {
		System.out.println("===================");
		System.out.println("    ADD PRODUCT    ");
		System.out.println("===================");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Price R$ (Ex:990,00): ");
		Double price = sc.nextDouble();
		sc.nextLine();
		produtoService.create(new Produto(name, price));
	}
	
	public void updateProduct() {
		System.out.println("==================");
		System.out.println("    UPDATE DATA   ");
		System.out.println("==================");
		System.out.print("Enter the ID of the product you want to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Produto produto = produtoService.findById(id);
		if(produto == null) {
			throw new IllegalArgumentException("Error: Product not Found!");
		} else {
			System.out.print("New name: ");
			String newName = sc.nextLine();
			System.out.print("New price R$(Ex: 990,00): ");
			double newPrice = sc.nextDouble();
			sc.nextLine();
			Produto produtoAtualizado = new Produto(newName, newPrice);
			produtoService.update(id, produtoAtualizado);
		}
		
	}
	
	public void deleteProduct() {
		System.out.println("====================");
		System.out.println("   DELETE PRODUCT   ");
		System.out.println("====================");
		System.out.print("Enter the ID of the product you want to update:");
		int id = sc.nextInt();
		try {
			Produto produto = produtoService.findById(id);
			if(produto != null) {
				produtoService.delete(id);
			} else {
				throw new IllegalArgumentException("Error: Product not found!");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void showProducts() {
		System.out.println("======================");
		System.out.println("   LISTING PRODUCTS   ");
		System.out.println("======================");
		for (Produto p : produtoService.listAll()) {
			System.out.println(p);
		}
	} 
	
}