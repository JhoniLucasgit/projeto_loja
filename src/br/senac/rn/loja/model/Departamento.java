package br.senac.rn.loja.model;

public class Departamento implements Comparable<Departamento>{
	
	private Integer id;
	private String nome;
	private String sigla;
	private float desconto;
	
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
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public Integer getId() {
		return id;
	}	
	public void setId(Integer id) {
		this.id = id;
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
		Departamento dep = (Departamento) obj;
		return this.id.equals(dep.id);
	}
	@Override
	public String toString() {
		return "Departamento [id=" + this.id + ", nome=" + this.nome + ", sigla=" + this.sigla + ", desconto=" + this.desconto + "]";
	}
	public int compareTo(Departamento dep) {		
		return this.nome.compareTo(dep.nome); 
	}
}
