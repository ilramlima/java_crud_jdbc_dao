package aplicacao;

import java.sql.Connection;

import bancodedados.ConexaoBancoDeDados;

public class App {

	public static void main(String[] args) {
		
		Connection conexao = ConexaoBancoDeDados.abrirConexao();
		ConexaoBancoDeDados.fecharConexao();

	}

}
