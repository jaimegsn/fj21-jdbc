package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Date;

public class TestaInsere {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setEmail("jaime.neto@example.com");
        contato.setNome("Jaime Neto");
        contato.setEndereco("Tv. Jose Viana de Souza");
        contato.setDataNascimento(Date.valueOf("2000-03-17"));
        ContatoDAO dao = new ContatoDAO();
        dao.inserirContato(contato);
    }
}
