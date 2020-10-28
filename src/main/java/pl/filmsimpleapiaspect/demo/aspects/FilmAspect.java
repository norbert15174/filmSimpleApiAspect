package pl.filmsimpleapiaspect.demo.aspects;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Aspect
@Component
public class FilmAspect {


    JavaMailSender javaMailSender;

    @Autowired
    public FilmAspect(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Before("@annotation(FilmAnnotation)")
    private void sendMail() throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo("faronnorbertkrk@gmail.com");
        mimeMessageHelper.setSubject("New Film");
        mimeMessageHelper.setText("<h1>Ktos dodaje nowy film<h1>" , true);
        javaMailSender.send(mimeMessage);


    }

}
