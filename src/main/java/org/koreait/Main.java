package org.koreait;

import org.koreait.exception.SQLErrorException;

public class Main {
    public static void main(String[] args) {
        try {
            new App().run();
        } catch (SQLErrorException e) {
            System.err.println("e.getOrigin : " + e.getOrigin());
            e.getOrigin().printStackTrace();
        }
    }
}