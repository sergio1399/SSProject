package practice.utils;

import javax.security.auth.login.AccountException;

/**
 * Created by sergi on 24.03.2018.
 */
public class MyAppException extends AccountException{

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public MyAppException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
