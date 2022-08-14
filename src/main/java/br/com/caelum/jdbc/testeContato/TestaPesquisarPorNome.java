package br.com.caelum.jdbc.testeContato;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisarPorNome {
    public static void main(String[] args) {
        System.out.println("Contatos Encontrados:");
        for (Contato contato: ContatoDAO.pesquisarPorNome("Jaime")) {
            System.out.println("--------");
            System.out.println("Nome do Contato: "+contato.getNome());
            System.out.println("Nome do Contato: "+contato.getEmail());
            System.out.println("Nome do Contato: "+contato.getEndereco());
            System.out.println("Nome do Contato: "+contato.getDataNascimentoFormatted());

        }
    }
}
