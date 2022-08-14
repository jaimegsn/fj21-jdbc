package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public static void adicionarFuncionario(Funcionario funcionario){
        String SQL = "INSERT INTO funcionario (nome,usuario,senha)"+
                "VALUES (?,?,?)";

        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pst = con.prepareStatement(SQL)){

            pst.setString(1,funcionario.getNome());
            pst.setString(2,funcionario.getUsuario());
            pst.setString(3,funcionario.getSenha());
            pst.execute();
            System.out.println("Novo funcionário cadastrado");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void removerFuncionario (Funcionario funcionario){
        String SQL = "DELETE FROM funcionario WHERE id=?";
        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pst = con.prepareStatement(SQL)){

            pst.setLong(1,funcionario.getId());
            pst.execute();
            System.out.println("Funcionário removido com sucesso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void atualizarFuncionario (Funcionario funcionario){
        String SQL = "UPDATE funcionario SET nome=?,usuario=?,senha=? WHERE id=?";
        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pst = con.prepareStatement(SQL)){

            pst.setString(1, funcionario.getNome());
            pst.setString(2,funcionario.getUsuario());
            pst.setString(3,funcionario.getSenha());
            pst.setLong(4,funcionario.getId());
            pst.execute();
            System.out.println("Funcionário atualizado com sucesso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Funcionario> pesquisarFuncionarioNome(String nome){
        String SQL = "SELECT * FROM funcionario WHERE nome LIKE CONCAT('%',?,'%')";
        List<Funcionario> funcionarios = new ArrayList<>();

        try(Connection con = new ConnectionFactory().getConnection();
        PreparedStatement pst = createPST(SQL,con,nome);
            ResultSet rs = pst.executeQuery()){
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setId(rs.getLong("id"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                funcionarios.add(funcionario);
            }
            System.out.println("Pesquisa realizada");
            return funcionarios;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    private static PreparedStatement createPST(String SQL,Connection con,String nome) throws SQLException {
        PreparedStatement pst = con.prepareStatement(SQL);
        pst.setString(1,nome);
        return pst;
    }
}
