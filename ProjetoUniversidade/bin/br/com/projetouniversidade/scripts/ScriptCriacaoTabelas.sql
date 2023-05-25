	CREATE DATABASE universidade;
	
	CREATE TABLE universidade.pessoa (
		id_pessoa INT NOT NULL AUTO_INCREMENT,
		nome VARCHAR(255) NOT NULL,
		data_nascimento DATE,
		documento VARCHAR(20),
		endereco VARCHAR(200),
		PRIMARY KEY (id_pessoa)
	);
	
	CREATE TABLE universidade.admin (
		id_admin INT NOT NULL AUTO_INCREMENT,
		id_pessoa INT NOT NULL,
		login VARCHAR(100),
		senha VARCHAR(100),
		PRIMARY KEY (id_admin),
		CONSTRAINT fk_admin_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES universidade.pessoa (id_pessoa)
	);
	
	CREATE TABLE universidade.aluno (
		id_aluno INT NOT NULL AUTO_INCREMENT,
		id_pessoa INT NOT NULL,
		PRIMARY KEY (id_aluno),
		CONSTRAINT fk_aluno_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES universidade.pessoa (id_pessoa)
	);
	
	CREATE TABLE universidade.professor (
		id_professor INT NOT NULL AUTO_INCREMENT,
		id_pessoa INT NOT NULL,
		data_contratacao DATE,
		ativo BOOLEAN,
		PRIMARY KEY (id_professor),
		CONSTRAINT fk_professor_id_pessoa FOREIGN KEY (id_pessoa) REFERENCES universidade.pessoa (id_pessoa)
	);
	
	CREATE TABLE universidade.disciplina (
		id_disciplina INT NOT NULL AUTO_INCREMENT,
		nome VARCHAR(255) NOT NULL,
		carga_horaria SMALLINT,
		PRIMARY KEY (id_disciplina)
	);
	
	CREATE TABLE universidade.curso (
		id_curso INT NOT NULL AUTO_INCREMENT,
		nome VARCHAR(255) NOT NULL,
		quantidade_semestre SMALLINT,
		PRIMARY KEY (id_curso)
	);
	
	CREATE TABLE universidade.curso_disciplina (
		id_curso_disciplina INT NOT NULL AUTO_INCREMENT,
		id_curso INT NOT NULL,
		id_disciplina INT NOT NULL,
		PRIMARY KEY (id_curso_disciplina),
		CONSTRAINT fk_curso_disciplina_id_curso FOREIGN KEY (id_curso) REFERENCES universidade.curso (id_curso),
		CONSTRAINT fk_curso_disciplina_id_disciplina FOREIGN KEY (id_disciplina) REFERENCES universidade.disciplina (id_disciplina)
	);
	
	CREATE TABLE universidade.professor_disciplina (
		professor_disciplina INT NOT NULL AUTO_INCREMENT,
		id_professor INT NOT NULL,
		id_disciplina INT NOT NULL,
		PRIMARY KEY (professor_disciplina),
		CONSTRAINT fk_professor_disciplina_id_professor FOREIGN KEY (id_professor) REFERENCES universidade.professor (id_professor),
		CONSTRAINT fk_professor_disciplina_id_disciplina FOREIGN KEY (id_disciplina) REFERENCES universidade.disciplina (id_disciplina)
	);
	
	CREATE TABLE universidade.turma (
		id_turma INT NOT NULL AUTO_INCREMENT,
		data_criacao DATE,
		quantidade_max_alunos SMALLINT,
		ativa BOOLEAN,
		PRIMARY KEY (id_turma)
	);
	
	CREATE TABLE universidade.matricula (
		id_matricula INT NOT NULL AUTO_INCREMENT,
		id_aluno INT NOT NULL,
		id_curso INT NOT NULL,
		id_turma INT NOT NULL,
		semestre_atual SMALLINT,
		ativa BOOLEAN,
		data_matricula DATE,
		PRIMARY KEY (id_matricula),
		CONSTRAINT fk_matricula_id_aluno FOREIGN KEY (id_aluno) REFERENCES universidade.aluno (id_aluno),
		CONSTRAINT fk_matricula_id_curso FOREIGN KEY (id_curso) REFERENCES universidade.curso (id_curso),
		CONSTRAINT fk_matricula_id_turma FOREIGN KEY (id_turma) REFERENCES universidade.turma (id_turma)
	);