package com.algaworks.brewer.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.ItemVenda;
import com.algaworks.brewer.model.Venda;

@Component
public class Mailer {

	private static Logger logger = LoggerFactory.getLogger(Mailer.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine thymeleaf;

	@Async
	public void enviar(Venda venda) {

		Context context = new Context();
		context.setVariable("venda", venda);
		context.setVariable("logo", "logo");
		
		for(ItemVenda item : venda.getItens()){
			Cerveja cerveja = item.getCerveja();
//			String variavelCid = "foto-" + cerveja.getf
//			context.setVariable(name, value);
		}


		try {
			String email = thymeleaf.process("mail/ResumoVenda", context);
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setFrom("leandroces@hotmail.com");
			helper.setTo(venda.getCliente().getEmail());
			helper.setSubject("Brewer - Venda Realizada");
			helper.setText(email, true);
			
			helper.addInline("logo", new ClassPathResource("static/images/logo-gray.png"));

			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			logger.error("Erro enviando e-mail", e);
		}

	}

	public void simple(Venda venda) {
		SimpleMailMessage mensagem = new SimpleMailMessage();
		mensagem.setFrom("leandroces@hotmail.com");
		mensagem.setTo(venda.getUsuario().getEmail());
		mensagem.setSubject("Venda Efetuada");
		mensagem.setText("Obrigado, sua venda foi processada");

		mailSender.send(mensagem);
		System.out.println(">>>>>>> email enviado!");
	}

}
