package com.uttara.spring.services;

import com.uttara.spring.beans.EmailBean;
import com.uttara.spring.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {
//    @Autowired
//    private JavaMailSender mailSender;
    public String sendEmail(EmailBean emailBean) {
        if(emailBean==null) {
            return "Invalid Input";
        }
        else {
            try {
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
                mailSender.setHost("smtp.gmail.com");
                mailSender.setPort(587);
                mailSender.setUsername("sriganeshharitz@gmail.com");
                mailSender.setPassword("953537679431102gg@@");

                Properties props = mailSender.getJavaMailProperties();
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.debug", "true");
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setSubject(emailBean.getSubject());
                String[] emails = emailBean.getEmails().split(",");
                for(String email:emails) {
                    simpleMailMessage.setBcc(email);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Hello,\t");
                    stringBuilder.append(emailBean.getBody());
                    stringBuilder.append(" ");
                    stringBuilder.append(emailBean.getUrl());
                    simpleMailMessage.setText(stringBuilder.toString());
                    mailSender.send(simpleMailMessage);
                }
                return Constant.SUCCESS;
            }
            catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
                return "Oops Something happened while sending emails";
            }

        }
    }
}
