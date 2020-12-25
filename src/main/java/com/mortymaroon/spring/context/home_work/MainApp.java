package com.mortymaroon.spring.context.home_work;

import com.mortymaroon.spring.context.ContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    private static boolean stared;

    private static boolean isStared() {
        return stared;
    }

    public static void main(String[] args) {
        stared = true;
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        Cart cart = context.getBean("cartImpl", CartImpl.class);
        System.out.print("Enter command -inf: ");
        Scanner scanner = new Scanner(System.in);
        while (isStared()) {
            String[] command = scanner.nextLine().split("/");
            switch (command[0]) {
                case "-inf":
                    System.out.println("List commands:\n" +
                            "-inf information\n" +
                            "-add/id add product by id\n" +
                            "-show shows products in cart\n" +
                            "-del/id removes product dy id\n" +
                            "-exit exit from program");
                    break;
                case "-add":
                    cart.addProductById(Integer.parseInt(command[1]));
                    break;
                case "-show":
                    cart.showProducts();
                    break;
                case "-del":
                    cart.deleteProductById(Integer.parseInt(command[1]));
                    break;
                case "-exit":
                    stared = false;
                    break;
                default:
                    System.out.print("Unknown command. Enter -inf to see list of command: ");
            }
        }
        context.close();
    }
}
