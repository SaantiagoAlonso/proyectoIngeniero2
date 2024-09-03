package co.scastillos.security2.service;

import co.scastillos.security2.dto.SetPasswordDto;
import co.scastillos.security2.entity.StructuraCorreo;
import co.scastillos.security2.entity.Usuario;
import co.scastillos.security2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Value("${spring.email.username}")
    private String fromEmail;

    public void enviarCorreo(String correo, StructuraCorreo structuraCorreo){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setSubject(structuraCorreo.getAsunto());
        simpleMailMessage.setText(structuraCorreo.getMensaje());
        simpleMailMessage.setTo(correo);

        javaMailSender.send(simpleMailMessage);

    }

    public String RamdonPassword(){

        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        StringBuilder newPassword = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(CHARACTERS.length());
            newPassword.append(CHARACTERS.charAt(index));
        }
        return newPassword.toString();

    }

    @Transactional
    public void changePassword(SetPasswordDto email) {
        Usuario user = userRepository.findByEmail(email.email()).orElse(null);
        String password = RamdonPassword();
        StructuraCorreo structuraCorreo = new StructuraCorreo();
        structuraCorreo.setAsunto("Restablecer Contraseña");
        structuraCorreo.setMensaje("su nueva contraseña es : " + password);
        enviarCorreo(user.getEmail(), structuraCorreo);
        user.setPassword(passwordEncoder.encode(password));
    }
}
