package br.com.caelum.jdbc.testeFuncionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteAtualizar {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Jotaro");
        funcionario.setSenha("321");
        funcionario.setUsuario("jotaro");
        funcionario.setId(3);
        FuncionarioDAO.atualizarFuncionario(funcionario);
    }
}
