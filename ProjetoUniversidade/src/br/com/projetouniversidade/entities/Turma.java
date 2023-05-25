package br.com.projetouniversidade.entities;

import java.time.LocalDate;

public class Turma {

	private Long id;
	private int quantidadeMaxAluno;
	private boolean ativa;
	private LocalDate dataCriacao;

	public Turma() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidadeMaxAluno() {
		return quantidadeMaxAluno;
	}

	public void setQuantidadeMaxAluno(int quantidadeMaxAluno) {
		this.quantidadeMaxAluno = quantidadeMaxAluno;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
