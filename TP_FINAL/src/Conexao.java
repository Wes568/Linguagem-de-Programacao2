// Wesley Oliveira - CB300550X

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection fazConexao() throws SQLException {
		
		String url = "jdbc:mysql://localhost/db_clientes";
		String user = "root";
		String password = "minhasenha";
		
		try {
			
			return DriverManager.getConnection(url, user, password);
		
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
}
