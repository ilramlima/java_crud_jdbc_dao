package bancodedados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBancoDeDados {
	
	private static Connection conexao = null;
	
	
	private static Properties carregarPropriedades() {
		
		try (FileInputStream fileInputStream = new FileInputStream("datasource.properties")) {
			
			Properties propriedades = new Properties();
			propriedades.load(fileInputStream);
			return propriedades;
			
		} catch (IOException e) {
			
			throw new DbException(e.getMessage());
		}
	}
	
	public static Connection abrirConexao() {
		
		if (conexao == null) {
			
			try {
				
				Properties propriedades = carregarPropriedades();
				String url = propriedades.getProperty("dburl");
				conexao = DriverManager.getConnection(url, propriedades);
				
			} catch (SQLException e) {
				
				throw new DbException(e.getMessage());
			}
		}
		
		return conexao;
	}
	
	public static void fecharConexao() {
		
		if (conexao != null) {
			
			try {
				
				conexao.close();
				conexao = null;
								
			} catch (SQLException e) {
				
				throw new DbException(e.getMessage());
			}
		}
	}
}
