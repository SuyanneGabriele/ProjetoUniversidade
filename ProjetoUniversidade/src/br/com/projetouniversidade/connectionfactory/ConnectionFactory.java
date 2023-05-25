package br.com.projetouniversidade.connectionfactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory extends Configuration {
	
	public ConnectionFactory() {
		super();
	}
	
	
	 /**
     * Executa uma Query
     * @param String SQL
     * @return ResultSet da sentença,  ou Null 
     */
    public java.sql.ResultSet consulta(String str){
    	ResultSet res = null;
		try {
			System.out.println("*Conexao->consulta() sql = "+str);
			res = (ResultSet) this.stmt.executeQuery(""+str+"");
		} 
		catch (SQLException e) {
			System.out.println("*Conexao->consulta() Erro");
			e.printStackTrace();
		}
    	return res;
    }
    
    /**
     * Executa um Insert<br>
     * @param String SQL
     * @return int o código do último registro adicionado
     */
    public int inserir(String sql){
    	int cod = 0;
		try {
			this.stmt.executeUpdate(sql);
			ResultSet rs = (ResultSet) this.stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {
		        cod = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("*Conexao->insert() Erro");
			e.printStackTrace();
		}
    	return cod;
    }
    
    /**
     * Executa um Update ou um Delete<br>
     * @param String SQL
     * @return int número de registros afettados
     */
    public int comando(String sql){
    	int qtd = 0;
		try {
			qtd = this.stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("*Conexao->comando() Erro");
			e.printStackTrace();
		}
    	return qtd;
    }

}
