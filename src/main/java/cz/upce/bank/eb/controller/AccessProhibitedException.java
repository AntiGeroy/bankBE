package cz.upce.bank.eb.controller;

public class AccessProhibitedException extends RuntimeException {

    public AccessProhibitedException(String message) {
        super(message);
    }
}
