package com.algaworks.brewer.mail;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import com.algaworks.brewer.storage.FotoStorage;

@Component
public class Mailer {

	private static Logger logger = LoggerFactory.getLogger(Mailer.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine thymeleaf;

	@Autowired
	private FotoStorage fotoStorage;

	@Async
	public void enviar(Venda venda) {
		Context context = new Context(new Locale("pt", "BR"));
		context.setVariable("venda", venda);
		context.setVariable("logo", "logo");

		Map<String, String> fotos = new HashMap<>();
		boolean adicionarMockCerveja = false;
		for (ItemVenda item : venda.getItens()) {
			Cerveja cerveja = item.getCerveja();
			if (cerveja.temFoto()) {
				String cid = "foto-" + cerveja.getCodigo();
				context.setVariable(cid, cid);
				fotos.put(cid, String.format("%s|%s", cerveja.getFoto(), cerveja.getContentType()));
			} else {
				adicionarMockCerveja = true;
				context.setVariable("mockCerveja", "mockCerveja");
			}
		}

		try {
			String email = thymeleaf.process("mail/ResumoVenda", context);
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setFrom("leandroces@hotmail.com");
			helper.setTo(venda.getCliente().getEmail());
			helper.setSubject(String.format("Brewer - Venda nº %d", venda.getCodigo()));
			helper.setText(email, true);

			helper.addInline("logo", new ClassPathResource("static/images/logo-gray.png"));

			for (String cid : fotos.keySet()) {
				String foto = fotos.get(cid).split("\\|")[0];
				String contentType = fotos.get(cid).split("\\|")[1];

				byte[] arrayFoto = fotoStorage.recuperarThumbnail(foto);
				helper.addInline(cid, new ByteArrayResource(arrayFoto), contentType);
			}

			if (adicionarMockCerveja) {
				helper.addInline("mockCerveja", new ClassPathResource("static/images/mock-cerveja.png"));
			}

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
