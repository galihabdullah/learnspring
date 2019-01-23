package com.stoppasung.stoppasung.shared.utils;

import com.google.common.collect.Lists;
import com.sun.mail.smtp.SMTPSaslAuthenticator;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.apache.commons.io.Charsets;
import org.apache.tomcat.util.digester.DocumentProperties;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private JavaMailSender mailSender;


    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "012345789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String emailProvider = "galihabdullah471@gmail.com";
    private final String passProvider = "tcinsqckypgoqdgb";
    private final String emailHost = "smtp.gmail.com";
    private final String emailPort = "465";
    private final String emailName = "ayopulih";
    private final String url = "http://localhost:8080/verification?token=";



    public String generateVericationToken(int length){
        return randomString(length);
    }

    public String randomString(int length){
        StringBuilder returnValue = new StringBuilder();
        for(int i = 0; i < length; i++){
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    public void sendmail(String userEmail, String userName, String userToken) throws AddressException, MessagingException, IOException {
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

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
        msg.setSubject("Verifikasi Email Ayo Pulih");
        String message = "Silahkan verifikasi email anda dengan klik link dibawah ini \n "+ url+userToken;
        msg.setContent(message, "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);
    }

    public static String getMD5EncryptedValue(String password) {
        final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            password = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return password;
    }

}
