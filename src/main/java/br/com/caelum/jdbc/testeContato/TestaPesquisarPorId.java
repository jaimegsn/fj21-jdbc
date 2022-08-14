package br.com.caelum.jdbc.testeContato;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisarPorId {
    public static void main(String[] args) {
        Contato contato = ContatoDAO.pesquisarPorId(1);
        System.out.println("-------");
        System.out.println("Nome do Contato: "+contato.getNome());
        System.out.println("Email do Contato: "+contato.getEmail());
        System.out.println("Endereço do Contato: "+contato.getEndereco());
        System.out.println("Data de Nascimento do Contato: "+contato.getDataNascimentoFormatted());

    }
}
