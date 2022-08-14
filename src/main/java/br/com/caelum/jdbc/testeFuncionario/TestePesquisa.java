package br.com.caelum.jdbc.testeFuncionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

import java.util.List;

public class TestePesquisa {
    public static void main(String[] args) {
        List<Funcionario>  funcionarios = FuncionarioDAO.pesquisarFuncionarioNome("y");

        for (Funcionario funcionario: funcionarios) {
            System.out.println("-----");
            System.out.println("Nome: "+funcionario.getNome());
            System.out.println("Usuario: "+funcionario.getUsuario());
            System.out.println("Senha: ****");
        }
    }
}
