package org.thousandturtles.gmail_demo;

import java.util.Scanner;

/**
 * Created by Chiaki Chikame on 8/11/15.
 * <p>
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/txt/copying/ for more details.
 */
class CLIMailInfoRetriever implements MailInfoRetriever {
    @Override
    public MailInfo retrieveMailInfo() {
        Scanner scanner = new Scanner(System.in);
        MailInfo mi = new MailInfo();

        System.out.print("Use SMTP server (Y/N)?");
        if (scanner.hasNextLine()) {
            String useSMTP = scanner.nextLine().toUpperCase();
            if (useSMTP.equals("Y") || useSMTP.equals("YES")) {
                mi.setNoAuth(false);
            } else {
                mi.setNoAuth(true);
            }
        }

        if (!mi.isNoAuth()) {
            System.out.print("Username of GMail:");
            if (scanner.hasNextLine()) {
                mi.setUsername(scanner.nextLine());
            } else {
                System.out.println("Please specify username of GMail");
                return null;
            }

            System.out.print("Password of GMail:");
            if (scanner.hasNextLine()) {
                mi.setPassword(scanner.nextLine());
            } else {
                System.out.println("Please specify password of GMail");
                return null;
            }
        }

        System.out.print("Address of the one who receive the mail:");
        if (scanner.hasNextLine()) {
            mi.setMailTo(scanner.nextLine());
        } else {
            System.out.println("Please specify mail receiver");
            return null;
        }

        return mi;
    }
}
