package br.com.crud.main;
import br.com.crud.dao.PessoaDAO;
import br.com.crud.model.Pessoa;
import java.util.Scanner;


public class Cadastrar {

	public static void main(String[] args) {
		int opcao = 1;
		Scanner entrada = new Scanner(System.in);
		while (opcao == 1) {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa();
		
		System.out.println("Digite o nome:");
		String nome = entrada.next().toString();
		System.out.println("Digite a idade:");
		int idade = entrada.nextInt();
		System.out.println("Digite sua etnia:");
		String etnia = entrada.next().toString();
		
		pessoa.setNome(nome);
		pessoa.setIdade(idade);
		pessoa.setEtnia(etnia);
		pessoaDAO.save(pessoa);
		
		System.out.println("Pessoa salva com sucesso!");
		
		System.out.println("Deseja cadastrar uma nova pessoa?");
		System.out.println("Digite 1-Cadastrar");
		System.out.println("Digite 0-Sair");
		opcao = entrada.nextInt();
		
		}
		System.out.println("Até mais!");
		entrada.close();
	}
}


