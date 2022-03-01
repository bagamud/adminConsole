package peter.ic.adminconsole.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import peter.ic.adminconsole.entity.Users;

@Service
public class TurtlePostman {
    final JavaMailSender javaMailSender;

    public TurtlePostman(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Users user, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Уведомление администратора");
        simpleMailMessage.setText("Уважаемый(ая) " + user.getFirstName() + " " + user.getMiddleName() + "!");
        javaMailSender.send(simpleMailMessage);
    }
}
