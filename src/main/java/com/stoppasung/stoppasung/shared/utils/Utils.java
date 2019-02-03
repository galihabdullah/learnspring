package com.stoppasung.stoppasung.shared.utils;

import com.google.common.collect.Lists;
import com.sun.mail.smtp.SMTPSaslAuthenticator;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.apache.commons.io.Charsets;
import org.apache.tomcat.util.digester.DocumentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "012345789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String emailProvider = "galihabdullah471@gmail.com";
    private final String passProvider = "tcinsqckypgoqdgb";


    public String generateVericationToken(int length) {
        return randomString(length);
    }

    public String randomString(int length) {
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    public void sendmail(String userEmail, String userName, String message) throws AddressException, MessagingException, IOException {
        try{
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailProvider, passProvider);
                }
            });
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(emailProvider, false));

            InternetAddress[] toAddress = {new InternetAddress(userEmail)};
            msg.setRecipients(Message.RecipientType.TO, toAddress);
            msg.setSubject(userEmail);
            msg.setContent(message, "text/html");
            msg.setSentDate(new Date());

            Transport.send(msg);
        }catch (MailException e){
            e.printStackTrace();
        }

    }

}