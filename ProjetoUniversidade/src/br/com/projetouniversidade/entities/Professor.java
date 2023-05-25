package br.com.projetouniversidade.entities;

import java.time.LocalDate;
import java.util.List;

public class Professor extends Pessoa {

	private Long id;
	private LocalDate dataContratacao;
	private boolean ativo;
	private List<Disciplina> disciplinaLecionada;

	public Professor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Disciplina> getDisciplinaLecionada() {
		return disciplinaLecionada;
	}

	public void setDisciplinaLecionada(List<Disciplina> disciplinaLecionada) {
		this.disciplinaLecionada = disciplinaLecionada;
	}

}
