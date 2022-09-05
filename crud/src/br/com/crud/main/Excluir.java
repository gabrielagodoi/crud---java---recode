package br.com.crud.main;

import br.com.crud.model.Pessoa;
import java.util.Scanner;

import br.com.crud.dao.PessoaDAO;

public class Excluir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao = 1;
		Scanner entrada = new Scanner(System.in);
		while (opcao == 1) {
		
		PessoaDAO contatoDAO = new PessoaDAO();
		
		for (Pessoa c : contatoDAO.getPessoas()) {
			System.out.println("CODIGO: " + c.getId());
			System.out.println("NOME: " + c.getNome());
			System.out.println("IDADE: " + c.getIdade());
			System.out.println("ETNIA: " + c.getEtnia());
			System.out.println("\n");
		}
		
		
		System.out.println("Digite o código que deseja excluir:");
		int codDel = entrada.nextInt();
		contatoDAO.removeById(codDel);
		System.out.println("Pessoa excluida com sucesso\n");
	
		System.out.println("Deseja excluir uma nova pessoa?");
		System.out.println("Digite 1-Excluir novamente");
		System.out.println("Digite 0-Sair");
		opcao = entrada.nextInt();
	
		}
		System.out.println("Até mais!");
		entrada.close();
	
	}
	
	

}
