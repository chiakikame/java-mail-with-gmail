package org.thousandturtles.gmail_demo;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
        MailInfoRetriever retriever = new CLIMailInfoRetriever();
        MailInfo mailInfo = retriever.retrieveMailInfo();

        if (mailInfo.isNoAuth()) {
            System.out.println("Using No auth, mail with aspmx.l.google.com");
        } else {
            System.out.printf("Username: %s%n", mailInfo.getUsername());
            System.out.printf("Password: %c***%c%n"
                    , mailInfo.getPassword().charAt(0)
                    , mailInfo.getPassword().charAt(mailInfo.getPassword().length() - 1));
        }
        System.out.printf("Mail target: %s%n", mailInfo.getMailTo());

        try {
            Email mail = new SimpleEmail();
            if (mailInfo.isNoAuth()) {
                mail.setHostName("aspmx.l.google.com");
                mail.setSmtpPort(25);
                mail.setFrom("no-reply@thousandturtles.org");
            } else {
                mail.setHostName("smtp.gmail.com");
                mail.setSmtpPort(465);
                mail.setAuthentication(mailInfo.getUsername(), mailInfo.getPassword());
                mail.setSSLOnConnect(true);
                mail.setFrom(mailInfo.getMailer());
            }
            mail.setCharset("UTF-8");
            mail.addTo(mailInfo.getMailTo(), "White Mouse");
            mail.setSubject("測試郵件");
            mail.setMsg("這是測試郵件！\nThis is a test mail!\n");
            mail.send();

            System.out.println("Mail sent successfully.");
        } catch(EmailException ee) {
            ee.printStackTrace();
        }
    }
}
