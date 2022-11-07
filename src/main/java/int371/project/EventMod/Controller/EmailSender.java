package int371.project.EventMod.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import int371.project.EventMod.Service.EmailSenderService;

@CrossOrigin
@RestController
public class EmailSender {

  @Autowired
  private EmailSenderService emailSenderService;

  @PostMapping("/sendEmail")
  public void sendEmail (@RequestParam("toEmail") String toEmail, @RequestParam("subject") String subject, @RequestParam("content") String content) throws Exception {
    emailSenderService.sendEmail(toEmail, subject, content);
  }
  
}
