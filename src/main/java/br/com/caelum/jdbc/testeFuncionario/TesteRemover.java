package br.com.caelum.jdbc.testeFuncionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteRemover {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(2);
        FuncionarioDAO.removerFuncionario(funcionario);
    }
}
