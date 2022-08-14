package br.com.caelum.jdbc.testeContato;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

import java.sql.Date;

public class TesteAltera {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Jotaro");
        contato.setEmail("Jotaro@gmail");
        contato.setDataNascimento(Date.valueOf("2007-07-14"));
        contato.setEndereco("Rua da maria joana");
        ContatoDAO.alterarContato(contato,4);
    }
}
