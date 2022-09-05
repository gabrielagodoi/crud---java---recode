package br.com.crud.main;

import java.util.Scanner;

import br.com.crud.dao.PessoaDAO;
import br.com.crud.model.Pessoa;

public class Atualizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao = 1;
		Scanner entrada = new Scanner(System.in);
		while (opcao == 1) {
		
			PessoaDAO pessoaDAO = new PessoaDAO();
		
		for (Pessoa c : pessoaDAO.getPessoas()) {
			System.out.println("CODIGO: " + c.getId());
			System.out.println("NOME: " + c.getNome());
			System.out.println("IDADE: " + c.getIdade());
			System.out.println("ETNIA: " + c.getEtnia());
			System.out.println("\n");
		}
		System.out.println("Digite o código que deseja atualizar:");
		int codAtt = entrada.nextInt();
		
		Pessoa pessoaAtt = new Pessoa();
		pessoaAtt.setId(codAtt);
		System.out.println("Digite o nome:");
		String nome = entrada.next().toString();
		pessoaAtt.setNome(nome);
		System.out.println("Digite a idade:");
		int idade = entrada.nextInt();
		pessoaAtt.setIdade(idade);

		
		System.out.println("Pessoa atualizada com sucesso\n");
	
		System.out.println("Deseja atualizar uma nova Pessoa?");
		System.out.println("Digite 1-Atualizar novamente");
		System.out.println("Digite 0-Sair");
		opcao = entrada.nextInt();
	
		}
		System.out.println("Até mais!");
		entrada.close();
	
	}
	

}
