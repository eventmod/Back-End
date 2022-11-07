package int371.project.EventMod.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
  
  @Autowired
  private JavaMailSender mailSender;

  public void sendEmail(String toEmail, String subject, String content) {

    SimpleMailMessage message = new SimpleMailMessage();

      message.setFrom("eventmod.senior@gmail.com");
      message.setTo(toEmail);
      message.setSubject(subject);
      message.setText(content);

      mailSender.send(message);

      System.out.println("Mail Send...");
    
  }
}
