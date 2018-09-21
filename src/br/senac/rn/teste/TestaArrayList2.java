package br.senac.rn.teste;

import java.util.Scanner;

import br.senac.rn.loja.dao.SexoDAO;
import br.senac.rn.loja.model.Sexo;

@SuppressWarnings("unused")
public class TestaArrayList2 {

	public static void main(String[] args) {
		
		/*Scanner entrada = new Scanner(System.in);
		
		SexoDAO dao = new SexoDAO();
		
		int resposta;
		
		do {
			Sexo sexo = new Sexo();
			System.out.println("Informe o nome do Sexo:");
			sexo.setNome(entrada.next());
			System.out.println("Informe a sigla do Sexo:");
			sexo.setSigla(entrada.next().toUpperCase());
			dao.inserir(sexo);;
			System.out.println("Digit 0 (ZERO) para SAIR");
			resposta = entrada.nextInt();
		}while(resposta != 0);
		
		entrada.close();	
		
		Sexo sm = new Sexo();
		sm.setId(1);
		sm.setNome("teste");
		dao.editar(sm);
		
		dao.buscaTodos().forEach(sexo -> System.out.println(sexo));*/
		
		/*Sexo s = new Sexo();
		s.setNome("FEMININO");
		s.setSigla("F");*/
		
		SexoDAO dao = new SexoDAO();
		System.out.println(dao.buscaPorId(4));
		
		
	}

}
