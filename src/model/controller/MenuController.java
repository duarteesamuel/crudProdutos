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
		System.out.println("5. Exit");
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
		case 5:
			System.exit(0);
			System.out.println("Thank you for using the system.");
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
		//Implementar lógica
	}
	
	public void deleteProduct() {
		//Implementar lógica
	}
	
	public void showProducts() {
		//Implementar lógica
	}
	
}
