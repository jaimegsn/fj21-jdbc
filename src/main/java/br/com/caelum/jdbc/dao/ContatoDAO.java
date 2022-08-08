package br.com.caelum.jdbc.dao;


import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {
    public void inserirContato(Contato contato){
        String sql = "insert into contatos"+
                "(nome,email,endereco,dataNascimento)"+
                "values (?,?,?,?)";

        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3,contato.getEndereco());
            stmt.setDate(4,contato.getDataNascimento());
            stmt.execute();
            System.out.println("Novo Contato Inserido");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
