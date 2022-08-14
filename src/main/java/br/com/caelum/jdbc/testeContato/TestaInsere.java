package br.com.caelum.jdbc.testeContato;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Date;

public class TestaInsere {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setEmail("teste@teste");
        contato.setNome("Yamato");
        contato.setEndereco("Tv. Jose Viana de Souza");
        contato.setDataNascimento(Date.valueOf("2021-03-17"));
        ContatoDAO.inserirContato(contato);
    }
}
