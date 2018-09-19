package br.senac.rn.teste;

import java.util.Scanner;

import br.senac.rn.loja.dao.DepartamentoDAO;
import br.senac.rn.loja.model.Departamento;

public class TestaDepartamento {

	public static void main(String[] args) {		
		Scanner entrada = new Scanner(System.in);
		DepartamentoDAO dao = new DepartamentoDAO();
		int resposta;
		
		do {
			Departamento dep = new Departamento();
			System.out.println("Informe o nome do departamento:");
			dep.setNome(entrada.next());
			System.out.println("Informe a sigla do departamento:");
			dep.setSigla(entrada.next());
			System.out.println("Informe o desconto do departamento:");
			dep.setDesconto(entrada.nextFloat());
			dao.inserir(dep);
			System.out.println("Digit 0 (ZERO) para SAIR");
			resposta = entrada.nextInt();
		}while(resposta != 0);
		
		Departamento d = new Departamento();
		d.setId(1);
		d.setNome("teste");
		dao.editar(d);
		
		entrada.close();		
		
		dao.buscaTodos().forEach(dep -> System.out.println(dep));
	}
}
