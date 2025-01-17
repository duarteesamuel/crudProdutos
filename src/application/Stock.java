package application;

import java.util.Scanner;

import model.controller.MenuController;
import model.repositories.CarrinhoRepository;
import model.repositories.CarrinhoRepositoryImpl;
import model.repositories.ProdutoRepository;
import model.repositories.ProdutoRepositoryImpl;
import model.services.CarrinhoService;
import model.services.ProdutoService;


public class Stock {

	public static void main(String[] args) {
		ProdutoRepository produtoRepository = new ProdutoRepositoryImpl();
		ProdutoService produtoService = new ProdutoService(produtoRepository);
		CarrinhoRepository carrinhoRepository = new CarrinhoRepositoryImpl(produtoRepository);
		CarrinhoService carrinhoService = new CarrinhoService(carrinhoRepository);
		Scanner sc = new Scanner(System.in);
		
		MenuController menuController = new MenuController(produtoService, carrinhoService, sc);
		
		menuController.menu();
	}

}
