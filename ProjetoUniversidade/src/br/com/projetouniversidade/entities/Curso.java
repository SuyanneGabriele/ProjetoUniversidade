package br.com.projetouniversidade.entities;

import java.util.List;

public class Curso {

	private Long id;
	private String nome;
	private int quantidadeSemestres;
	private List<Disciplina> listaDisciplina;

	public Curso() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeSemestres() {
		return quantidadeSemestres;
	}

	public void setQuantidadeSemestres(int quantidadeSemestres) {
		this.quantidadeSemestres = quantidadeSemestres;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

}
