package br.com.caelum.jdbc.testeContato;

import br.com.caelum.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) {

        try(Connection connection = new ConnectionFactory().getConnection()){
            System.out.println(connection);
            System.out.println("Conexão aberta!!");
        }catch(SQLException e ){
            e.printStackTrace();
        }
    }
}
