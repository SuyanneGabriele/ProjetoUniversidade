package br.com.projetouniversidade.connectionfactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
	
	// Driver JDBC
		public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 

		// URL do servidor MYSQL
		public static final String BANCO = "jdbc:mysql://localhost/";

		// Nome da base
		public static final String BASE  = "abc";

		// Credenciais
		public static final String USER = "root";
		public static final String PASS = "root";

		public java.sql.Connection conn;
		public java.sql.Statement  stmt; 
		public Boolean existe = false; 

		public Configuration() 
		{
			System.out.println("Config.Config()");
			
			
			try {
				// Registrando o driver JDBC
				Class.forName( JDBC_DRIVER );
				this.conn = DriverManager.getConnection(BANCO, USER, PASS);
				this.stmt = this.conn.createStatement();

				// Verifica se o banco existe
				// information_schema: é a base que contém todas as bases do banco mysql
				// SCHEMATA: é a tabela que garda o nome de todas as tabelas no mysql
				java.sql.ResultSet res = this.stmt.executeQuery(
						 " SELECT COUNT(1) AS qtd "
						+"   FROM information_schema.SCHEMATA " 
						+"  WHERE SCHEMA_NAME = '"+BASE+"' ;");
				res.first();
				if( res.getInt(1)==0) {
					System.out.println("Config.Config() Base ("+BASE+") ainda não existe.");
				}
				else {
					System.out.println("Config.Config() Base ("+BASE+") já existe.");
					this.fechaConexao();
					this.conn = DriverManager.getConnection(BANCO+BASE, USER, PASS);
					System.out.println("Config.Config() Ok, conectado a base.");
					this.existe = true; 
					this.stmt = this.conn.createStatement();
				}
			}
			catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
				System.out.println("Config.Config() ERRO JDBC parece não estar configurado em seu projeto Java.");
			}
			catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
				System.out.println("Config.Config() ERRO ao conectar na base de dados");
			}
		}
		
		public void fechaConexao(){
			System.out.println("Config.fechaConexao()");
			try{
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2){
			
			}
			
			try{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}

}
