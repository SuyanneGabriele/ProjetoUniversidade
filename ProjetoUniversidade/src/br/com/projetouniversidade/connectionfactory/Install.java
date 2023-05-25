package br.com.projetouniversidade.connectionfactory;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Install extends Configuration {

	public static void main(String[] args) {
		Install ins = new Install();
		// Usando
		try {
			// Registrando o driver JDBC
			Class.forName(JDBC_DRIVER);

			ins.conn = DriverManager.getConnection(BANCO, USER, PASS);

			ins.stmt = ins.conn.createStatement();

			if (ins.existe) {
				System.out.println("Install.main() Ok, Base (" + BASE + ") já existe.");
			} else {
				System.out.println("Install.main() Base (" + BASE + ") aida não existe.");
				ins.stmt.executeUpdate("CREATE DATABASE " + BASE);
				System.out.println("Install.main() Base (" + BASE + ") criada com sucesso.");
				ins.fechaConexao();

				System.out.println("Install.main() Conectando novamente agora com a base.");
				ins.conn = DriverManager.getConnection(BANCO + BASE, USER, PASS);
				ins.stmt = ins.conn.createStatement();

				System.out.println("Install.main() 1 Criando tabela Usuário");
				ins.stmt.executeUpdate(" CREATE TABLE tb_usuario ( " + "	us_codusu int(11) NOT NULL AUTO_INCREMENT,"
						+ "   us_nomusu varchar(100) NOT NULL," + "   us_emausu varchar(100) NOT NULL,"
						+ "   PRIMARY KEY (us_codusu)  ) ");

				// Inserindo vário registros
				ins.stmt.executeUpdate(" INSERT INTO tb_usuario ( us_nomusu, us_emausu ) "
						+ " VALUES ( 'Usuário 1', 'email1@teste.com' )" + "      , ( 'Usuário 2', 'email2@teste.com' )"
						+ "      , ( 'Usuário 3', 'email3@teste.com' )"
						+ "      , ( 'Usuário 4', 'email4@teste.com' ) ");

				// inserindo apenas um registro
				ins.stmt.executeUpdate(" INSERT INTO tb_usuario ( us_nomusu, us_emausu ) "
						+ " VALUES ( 'Usuário 5', 'email5@teste.com' ) ");

				// arrecadando o "insert ID" id do último registro inserido na última sentença
				ResultSet rs = ins.stmt.executeQuery("SELECT LAST_INSERT_ID()");
				if (rs.next()) {
					System.out.println("Install.main() Último usuário registrado" + rs.getInt(1)); // retorna '5'
				}

			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		ins.fechaConexao();
	}

}
