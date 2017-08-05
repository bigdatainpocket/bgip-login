package com.bgip.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("admin@admin.com");
        javaMailSender.send(mailMessage);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static final String REGISTER_MESSAGE = "<p>Hi Muthahar,</p>"+
    				"<p> Your account is almost ready! To get the most out of BGIP, be sure to install BGIP on your computer and phone.</p>"+
    				"<p>CLICK HERE TO CONFIRM EMAIL</p>"+
    				"<p>Any file you save to your BGIP will automatically save to all your computers, phones and even the BGIP website.<br />BGIP also lets you easily share docs and photos, and collaborate with friends.</p>";
    					


	
	public static final String TOKEN_GENERATE = "<p style=\"text-align: left;\">            </p>"+
			"<h1 style=\"text-align: left;\"><span style=\"color: #3366ff;\">       <img src=\"http://54.187.66.164/mediaserver/image.php?imageid=7e2e52c827fe37c6fed5dd9341701818&&width=1200&quality=100&height=600&e_staturation=100&crop=fit&gravity=\" alt=\"FabCircles\" width=\"356\" height=\"128\" /></span></h1>"+
			"<p> </p>"+
			"<p><span style=\"font-family: Verdana; font-size: large;\"><span style=\"color: #3366ff;\">Almost done..., @Name</span></span></p>"+
			"<p><span style=\"font-family: Verdana; font-size: medium;\"><span style=\"color: #999999;\">Welcome to FabCircles, </span></span> <span style=\"font-family: Verdana; font-size: medium;\"><span style=\"color: #999999;\">To activate your account and verify your email address, please click the following Button </span></span></p>"+
			"<p> </p>"+
			"<p><span style=\"color: #999999;\">                                   <a href=\"@Token\" target=\"_blank\"><img src=\"http://54.187.66.164/mediaserver/image.php?imageid=76840fb41d4eaa8ae50960b6a2a90c6a&&width=1200&quality=100&height=600&e_staturation=100&crop=fit&gravity=\" alt=\"\" width=\"294\" height=\"38\" /></a><br /></span></p>";
				

	
	public static final String SUCCESS_MESSAGE = "<h1 style=\"text-align: left;\"><span style=\"color: #3366ff;\">      <img src=\"http://54.187.66.164/mediaserver/image.php?imageid=7e2e52c827fe37c6fed5dd9341701818&&width=1200&quality=100&height=600&e_staturation=100&crop=fit&gravity=\" alt=\"FabCircles\" width=\"651\" height=\"234\" /></span></h1>"+
			"<p> </p>"+
			"<p><span style=\"font-family: Verdana; font-size: large;\"><span style=\"color: #3366ff;\">Hi @Name,</span></span></p>"+
			"<p><span style=\"font-family: Verdana; font-size: medium;\"><span style=\"color: #999999;\">Your account has been created – it will now be easier than ever to share and connect with your friends., Login</span></span><span style=\"font-family: Verdana; font-size: medium;\"><span style=\"color: #999999;\"> your Account and update your Profile.</span></span></p>"+
			"<p> </p>"+
			"<p> </p>"+
			"<p><span style=\"color: #999999;\">                                          <a href=\"http://54.187.66.164/fabcircles/home/login\"><img src=\"http://54.187.66.164/mediaserver/image.php?imageid=92b5dadb13eecec071985d1184bbe2f1&&width=1200&quality=100&height=600&e_staturation=100&crop=fit&gravity=\" alt=\"\" width=\"160\" height=\"50\" /></a><br /></span></p>";
				

    
    
    
    
    
}
