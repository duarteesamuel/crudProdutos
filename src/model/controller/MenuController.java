package model.controller;

import java.util.Scanner;

import model.entities.Produto;
import model.services.ProdutoService;
import utils.Utils;

public class MenuController {
	
	private ProdutoService produtoService;
	private Scanner sc;
	
	public MenuController(ProdutoService produtoService, Scanner sc) {
		this.produtoService = produtoService;
		this.sc = sc;
	}
	
	public void menu() {
		System.out.println("Loading...");
		Utils.timeout();
		System.out.println("=======================");
		System.out.println("Stock Management System");
		System.out.println("=======================");
		System.out.println("1. Add Product");
		System.out.println("2. Update Product");
		System.out.println("3. Delete Product");
		System.out.println("4. List All Products");
		System.out.println("5. Buy Products     ");
		System.out.println("0. Exit");
		System.out.print("Select an option: ");
		int option = sc.nextInt();
		System.out.println("============================");
		sc.nextLine();
		
		switch(option){
		case 1:
			Utils.timeout();
			addProduct();
			break;
		case 2:
			Utils.timeout();
			updateProduct();
			break;
		case 3:
			Utils.timeout();
			deleteProduct();
			break;
		case 4:
			Utils.timeout();
			showProducts();
			break;
		case 5:
			Utils.timeout();
			buyProducts();
			break;
		case 0:
			System.out.println("Closing...");
			Utils.timeout();
			System.out.println("Thank you for using the system.");
			System.exit(0);
		default:
			System.out.println("Invalid option!");
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
		Produto produto = new Produto(name, price);
		produtoService.create(produto);
	}
	
	public void updateProduct() {
		System.out.println("==================");
		System.out.println("    UPDATE DATA   ");
		System.out.println("==================");
		System.out.print("Enter the ID of the product you want to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			System.out.print("New name: ");
			String newName = sc.nextLine();
			System.out.print("New price R$ (Ex: 990,00): ");
			double newPrice = sc.nextDouble();
			sc.nextLine();
			Produto existingProduct = new Produto(newName, newPrice);
			produtoService.update(id, existingProduct);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
		
	}
	
	public void deleteProduct() {
		System.out.println("====================");
		System.out.println("   DELETE PRODUCT   ");
		System.out.println("====================");
		System.out.print("Enter the ID of the product you want to update: ");
		int id = sc.nextInt();
		try {
			produtoService.delete(id);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void showProducts() {
		System.out.println("======================");
		System.out.println("   LISTING PRODUCTS   ");
		System.out.println("======================");
		try {
			produtoService.listAll();
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	} 
	
	public void buyProducts() {
		
	}
	
}