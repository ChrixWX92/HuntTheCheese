package org.example;

import org.example.service.CheesyScenario;

public class Main {

    public static void main(String[] args) {
        CheesyScenario cheesyScenario = new CheesyScenario("--M--K---------C", 1, 8);
        System.out.println(cheesyScenario.huntTheCheese());
    }

}