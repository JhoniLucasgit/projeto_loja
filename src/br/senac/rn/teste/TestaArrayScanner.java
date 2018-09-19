package br.senac.rn.teste;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import br.senac.rn.loja.model.Sexo;

public class TestaArrayScanner {

	public static void main(String[] args) {
		List<Sexo> sexos = new LinkedList<Sexo>();
		
		int resposta = 1;
		//int id = 1;
		Scanner entrada = new Scanner(System.in);
		
		do {
			Sexo sexo = new Sexo();
			//sexo.setId((int) (Math.random()*100)); // sexo.setId(id);
			System.out.println("Informe o nome do Sexo:");
			sexo.setNome(entrada.next());
			System.out.println("Informe a sigla do Sexo:");
			sexo.setSigla(entrada.next());
			sexos.add(sexo);
			System.out.println("Digit 0 (ZERO) para SAIR");
			resposta = entrada.nextInt();
			//id++;
		}while(resposta != 0);
		
		entrada.close();		
		
		Collections.sort(sexos);//ordenando 
		/*Expressão Lambda */
		sexos.forEach(sexo -> System.out.println(sexo));	
	}
	/*
	Iteração simplificada
	for(Sexo s : sexos) {
		System.out.println(s);
	}
	
	Iteração normal
	for(int i = 0; i > sexos.size(); i++) {
		Sexo s = sexos.get(i);
		System.out.println(s);
	}*/
	
}
