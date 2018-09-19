package br.senac.rn.loja.model;

public class Sexo implements Comparable<Sexo>{
	
	private Integer id; // static é controlado pela classe
	private String nome;
	private String sigla;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Sexo sexo = (Sexo) obj;
		return this.id.equals(sexo.id); /*return ((Sexo) obj).id == this.id;*/
	}	
	
	@Override
	public String toString() {
		return "Sexo [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	@Override
	public int compareTo(Sexo sexo) {
		
		return this.nome.compareTo(sexo.nome); // comparação de string
	}	
}
/* compareTo = ordem crescente
int id = sexo.id;
if (this.id < id) {
	return -1;
}else if(this.id > id) {
	return +1;
}
return 0;*/
/* compareTo = ordem decrescente
int id = sexo.id;
if (this.id < id) {
	return +1;
}else if(this.id > id) {
	return -1;
}
return 0;*/
