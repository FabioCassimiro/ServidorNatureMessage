
package br.com.unip.sicc.natureMessage.exception;

public class UserInUseException extends Exception {

    public UserInUseException() {
        
    }

    public UserInUseException(String msg) {
        super(msg);
    }
}
