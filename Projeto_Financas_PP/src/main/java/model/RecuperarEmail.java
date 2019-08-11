package model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import daoJPA.UsuarioDaoJPA;
import dto.UsuarioDTO;

public class RecuperarEmail {

	public void enviarEmail(UsuarioDTO dto) throws Exception {
		String username = "vain.suporte@gmail.com";
		String password = "vaininvestimentos123";
		String assunto = "Recuperação de senha";

		if (dto != null) {
			String mensagemEmail = "Olá, aqui é do suport da Vain Investimentos. Sua senha recuperada é: "
					+ dto.getSenha();

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class", 
		    "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			session.setDebug(true);

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username)); // Remetente

				Address[] toUser = InternetAddress.parse(dto.getEmail());

				message.setRecipients(Message.RecipientType.TO, toUser);
				message.setSubject(assunto);// Assunto
				message.setText(mensagemEmail);
				Transport.send(message);
				JOptionPane.showMessageDialog(null, "Configura sua caixa de e-mail");
			} catch (MessagingException e) {
				throw new RuntimeException("Não foi possível enviar o email. " + e.getMessage());
			}
		}

	}

}
