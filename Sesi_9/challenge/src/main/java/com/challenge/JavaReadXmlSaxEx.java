package com.challenge;

import java.util.List;

public class JavaReadXmlSaxEx {
    public static void main(String[] args) {
        MyRunner runner = new MyRunner();
        List<User> lines = runner.parseUsers();

        System.out.print(lines);
        
    }
}
