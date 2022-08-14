package br.com.caelum.jdbc.testeContato;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {
    public static void main(String[] args) {
        for (Contato contato: ContatoDAO.getLista()) {
            System.out.println("---------");
            System.out.println("Nome Contato: "+contato.getNome());
            System.out.println("Email Contato: "+contato.getEmail());
            System.out.println("Endereço Contato: "+contato.getEndereco());
            System.out.println("Data de Nascimento do Contato: "+contato.getDataNascimentoFormatted());
        }
    }
}
