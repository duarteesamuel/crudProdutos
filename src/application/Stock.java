package application;

import java.util.Locale;
import java.util.Scanner;

import model.controller.MenuController;
import model.repositories.ProdutoRepository;
import model.repositories.ProdutoRepositoryImpl;
import model.services.ProdutoService;


public class Stock {

	public static void main(String[] args) {
		ProdutoRepository produtoRepository = new ProdutoRepositoryImpl();
		ProdutoService produtoService = new ProdutoService(produtoRepository);
		Scanner sc = new Scanner(System.in);
		
		MenuController menuController = new MenuController(produtoService, sc);
		
		menuController.menu();
	}

}
