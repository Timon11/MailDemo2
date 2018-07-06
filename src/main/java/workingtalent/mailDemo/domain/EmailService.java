package workingtalent.mailDemo.domain;

import java.io.File;
import java.util.Properties;

import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
		
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("workingtalent.urenregistratie@gmail.com");
	    mailSender.setPassword("dailystandup1");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.EnableSSL.enable","true");
	     
	    return mailSender;
	}
		
	public void sendEmail() throws Exception {
		//send email
		MimeMessage message = getJavaMailSender().createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo("timon.verduijn@hotmail.com");
		helper.setFrom("workingtalent.urenregistratie@gmail.com");
		helper.setSubject("Urenregistratie"); //+ naam + datum
					
		helper.setText("<html>"
					  + "<body width=100% style=\"font-family:Open Sans,Helvetica Neue,Arial,sans-serif; margin:0;\">"
					      + "<table float=left bgcolor=\"#0f1410\" width=100% height=100px line-height=100px>"
					          + "<tr>"
					             + "<td width=185px>"
					                 + "<img src=\"cid:logoWT\" style=\"padding-left:15px; height:80px; margin:10px; display:block; padding-left:15px;\">"
					      		 + "</td>"
					             + "<td>"
					                 + "<FONT COLOR=\"#bceb1b\">"
					                 	+ "<h1 style=\"padding-left:15px; padding-right:15px; float:left; font-size:18; font-weight:700;\">"
					      		 			+ "Overzicht uren Timon Verduijn"
					                     + "</h1>"
					                 + "</FONT>"
					             + "</td>"
					         + "</tr>"
					     + "</table>"
					     + "<table align=center>"
					         + "<tr>"
					             + "<td>"
					                 + "<span >"
					                     + "De urenregistratie van Timon Verduijn staat klaar voor uw beoordeling:"
					                 + "</span>"
					             + "</td>"
					         + "</tr>"
					         + "<tr>"
					             + "<td align=center>"
					                 + "<button style=\"padding:8px; border:none; outline:none; overflow:hidden; width:200px; background-color:#0f1410; color:#bceb1b; font-size:18px; font-weight:700;\">Bekijk Urenregistratie</button>"
					      		 + "</td>"
					         + "</tr>"
					     + "</table>"
					     + "<br>"
					 + "</body>"
				+ "</html>"
					, true);
		
		FileSystemResource image01 = new FileSystemResource(new File("c:/_FILES/mailDemo/Images/logoWT.png"));
		helper.addInline("logoWT", image01);

		getJavaMailSender().send(message);
	}
}
