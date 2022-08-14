package br.com.caelum.jdbc.testeFuncionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteAdicionar {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Taynan Gouveia");
        funcionario.setUsuario("taynan");
        funcionario.setSenha("123");
        FuncionarioDAO.adicionarFuncionario(funcionario);
    }
}
