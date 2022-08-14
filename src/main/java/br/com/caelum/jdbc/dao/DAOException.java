package br.com.caelum.jdbc.dao;

public class DAOException extends RuntimeException {
    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }
}
