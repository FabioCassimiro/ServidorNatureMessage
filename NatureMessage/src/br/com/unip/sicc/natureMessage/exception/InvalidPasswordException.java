package br.com.unip.sicc.natureMessage.exception;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {
        
    }
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
