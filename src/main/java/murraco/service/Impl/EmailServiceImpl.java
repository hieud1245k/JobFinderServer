package murraco.service.Impl;

import lombok.RequiredArgsConstructor;
import murraco.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private static final String NO_REPLY_ADDRESS = "hieuminh22690@gmail.com";

    private final JavaMailSender emailSender;

//    private final SimpleMailMessage template;

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NO_REPLY_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to,
                                               String subject,
                                               String ...templateModel) {
//        String text = String.format(Objects.requireNonNull(template.getText()), (Object) templateModel);
//        sendSimpleMessage(to, subject, text);
    }
}
