package br.com.caelum.jdbc.dao;


import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO{
    public static void inserirContato(Contato contato) throws DAOException{
        String sql = "insert into contatos"+
                "(nome,email,endereco,dataNascimento)"+
                "values (?,?,?,?)";

        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3,contato.getEndereco());
            stmt.setDate(4, contato.getDataNascimento());
            stmt.execute();
            System.out.println("Novo Contato Inserido");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Contato> getLista() throws DAOException{
        String SQL = "SELECT * FROM contatos";
        List<Contato> contatos = new ArrayList<>();
        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pst = con.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery()){

            while(rs.next()){
                Contato contatoTemp = new Contato();
                contatoTemp.setDataNascimento(rs.getDate("dataNascimento"));
                contatoTemp.setNome(rs.getString("nome"));
                contatoTemp.setEmail(rs.getString("email"));
                contatoTemp.setEndereco(rs.getString("endereco"));
                contatos.add(contatoTemp);
            }
            return contatos;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Contato pesquisarPorId(int id) throws DAOException{
        String SQL = "SELECT * FROM contatos WHERE id=?";
        try(Connection con = new ConnectionFactory().getConnection();
        PreparedStatement pst = createPreparedStatement(con,SQL,Integer.toString(id));
        ResultSet rs = pst.executeQuery()){
            if(rs.next()){
                Contato contato = new Contato();
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setNome(rs.getString("nome"));
                contato.setDataNascimento(rs.getDate("dataNascimento"));
                return contato;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Contato> pesquisarPorNome(String nome) throws DAOException{
        String SQL = "SELECT * FROM contatos WHERE nome LIKE CONCAT('%',?,'%')";
        try(Connection con = new ConnectionFactory().getConnection();
        PreparedStatement pst = createPreparedStatement(con,SQL,nome);
        ResultSet rs = pst.executeQuery()){
            List<Contato> contatos = new ArrayList<>();
            while(rs.next()){
                Contato contato = new Contato();
                contato.setNome(rs.getString("nome"));
                contato.setDataNascimento(rs.getDate("dataNascimento"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contatos.add(contato);
            }
            return contatos;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void removerContato(long id) throws DAOException{
        String SQL = "DELETE FROM contatos WHERE id=?";
        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pst = con.prepareStatement(SQL) ){
            pst.setLong(1,id);
            pst.execute();
            System.out.println("Contato Deletado");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void alterarContato(Contato contato,long id) throws DAOException{
        String SQL ="UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pst = con.prepareStatement(SQL)){

            pst.setString(1,contato.getNome());
            pst.setString(2,contato.getEmail());
            pst.setString(3,contato.getEndereco());
            pst.setDate(4,contato.getDataNascimento());
            pst.setLong(5,id);
            pst.execute();
            System.out.println("Informações do Contato Alterados");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static PreparedStatement createPreparedStatement(Connection con, String SQL, String parametro) throws SQLException{
        PreparedStatement pst = con.prepareStatement(SQL);
        pst.setString(1,parametro);
        return pst;
    }
}
