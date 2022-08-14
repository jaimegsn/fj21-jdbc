package br.com.caelum.jdbc.modelo;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Contato {
    private String nome;
    private String email;
    private String endereco;
    private Date dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimentoFormatted() {
        String mascara = "dd/MM/YYYY";
        SimpleDateFormat sdf = new SimpleDateFormat(mascara);
        return sdf.format(this.dataNascimento);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
