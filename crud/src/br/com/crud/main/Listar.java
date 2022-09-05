package br.com.crud.main;

import br.com.crud.dao.PessoaDAO;
import br.com.crud.model.Pessoa;

public class Listar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		for (Pessoa c : pessoaDAO.getPessoas()) {
			System.out.println("\nNOME: " + c.getNome());
			System.out.println("IDADE: " + c.getIdade());
			System.out.println("\nEtnia: " + c.getEtnia());
		}
	}

}
