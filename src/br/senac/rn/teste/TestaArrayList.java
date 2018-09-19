package br.senac.rn.teste;

import java.util.LinkedList;
import java.util.List;
import br.senac.rn.loja.model.Sexo;

public class TestaArrayList {
	
	public static void main(String[] args) {
		/*ArrayList melhor pra add e pior pra remover
		 *LinkedList melhor para remover e pior para adicionar*/
		List<Sexo> sexos = new LinkedList<Sexo>();		
		
		Sexo s1 = new Sexo();
		//s1.setId(1);
		s1.setNome("Masculino");
		s1.setSigla("M");
		
		Sexo s2 = new Sexo();
		//s2.setId(2);
		s2.setNome("Feminino");
		s2.setSigla("F");
		
		Sexo s3 = new Sexo();
		//s3.setId(3);
		s3.setNome("Não Informado");
		s3.setSigla("N");
		
		sexos.add(s2);
		sexos.add(s3);
		sexos.add(s1);
		
		/*Sexo s4 = new Sexo();
		s4.setId(2);*/
		
		/*sexos.remove(s1);/*remove passando o objeto*/
		sexos.remove(2);/*remove passando o indice*/
		
		/*metodo contains vê se aquele elemento está na lista, 
		 * não necessariamente precisa add para dps comparar*/
		/*para saber o tamanho da lista nome_da_lista.size()*/
		//System.out.println(sexos);
		
		//iterando a list
		for(int i = 0; i > sexos.size(); i++) {
			System.out.println(sexos.get(i));
		}
		
		//iterando melhor
		/*
		for(Sexo sexo : sexos) {
			System.out.println(sexo);
		}*/
		
		//contains com for
		for(Sexo sexo : sexos) {
			if(sexo.getId() == 6) {
				System.out.println(sexo);
				System.out.println("Achou");
				break;
			}
		}
		
	}
}
