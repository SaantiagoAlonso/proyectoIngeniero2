package co.scastillos.security2.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
public class MailConfig {

    Dotenv dotenv = Dotenv.configure().load();


    @Bean
    public JavaMailSender javaMailSender() {

        String mailUsername = dotenv.get("email_username");
        String mailPassword = dotenv.get("email_password");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(mailUsername);
        mailSender.setPassword(mailPassword);

        // Configure additional properties if needed
        /*Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true");*/

        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true");


        return mailSender;
    }

}
