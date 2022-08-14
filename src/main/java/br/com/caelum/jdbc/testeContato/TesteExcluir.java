package br.com.caelum.jdbc.testeContato;

import br.com.caelum.jdbc.dao.ContatoDAO;

public class TesteExcluir {
    public static void main(String[] args) {
        ContatoDAO.removerContato(3); // Contato deletado por ID
    }
}
