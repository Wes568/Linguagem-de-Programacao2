// Wesley Oliveira - CB300550X

import java.sql.*;

public class ClienteS {

	    private Connection connection;
	    String nome;
	    Integer idade;
	    Float peso;
	    Float altura;
	    String objetivo;

	    public ClienteS(){ 
	    	
	        new Conexao();
			try {
				this.connection = Conexao.fazConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	    } 
	    public void insert(Cliente c){ 
	    	
	        String insert = "insert into tb_clientes(nome,idade,peso,altura, objetivo) values(?,?,?,?,?)";
	        try { 
	            PreparedStatement state = connection.prepareStatement(insert);
	            state.setString(1, c.getNome());
	            state.setInt(2, c.getIdade());
	            state.setDouble(3, c.getPeso());
	            state.setDouble(4, c.getAltura());
	            state.setString(5, c.getObjetivo());
	            state.execute();
	            state.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        } 
	        
	    } 
	    
}



