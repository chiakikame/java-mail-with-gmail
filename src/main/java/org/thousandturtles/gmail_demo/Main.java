package org.thousandturtles.gmail_demo;

import java.util.Scanner;

/**
 * Created by Chiaki Chikame on 8/10/15.
 * <p>
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/txt/copying/ for more details.
 * <p>
 * Args[0]: username
 * Args[1]: password
 * Args[2]: mail to ..
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;
        String target;

        System.out.print("Username of GMail:");
        if (scanner.hasNextLine()) {
            userName = scanner.nextLine();
        } else {
            System.out.println("Please specify username of GMail");
            return;
        }

        System.out.print("Password of GMail:");
        if (scanner.hasNextLine()) {
            password = scanner.nextLine();
        } else {
            System.out.println("Please specify password of GMail");
            return;
        }

        System.out.print("Address of the one who receive the mail:");
        if (scanner.hasNextLine()) {
            target = scanner.nextLine();
        } else {
            System.out.println("Please specify mail receiver");
            return;
        }

        System.out.printf("Username: %s%n", userName);
        System.out.printf("Password: %c***%c%n", password.charAt(0), password.charAt(password.length() - 1));
        System.out.printf("Mail target: %s%n", target);
    }
}
