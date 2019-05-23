package com.allthatBTS.exception;

import org.springframework.security.core.AuthenticationException;

public class SocialTypeNotExistException extends AuthenticationException {
    public SocialTypeNotExistException(String msg, Throwable t) {
        super(msg, t);
    }

    public SocialTypeNotExistException(String msg) {
        super(msg);
    }
}
