package com.algaworks.brewer.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.algaworks.brewer.mail.Mailer;

@Configuration
@ComponentScan(basePackageClasses = Mailer.class)
@PropertySource({ "classpath:env/mail-${ambiente:home}.properties" })
@PropertySource(value = { "file://${HOME}/.brewer-mail.properties" }, ignoreResourceNotFound = true) // recuperar_por_arquivo
public class MailConfig {

	@Autowired
	private Environment env;

	@Bean
	public JavaMailSender mailSerder() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.sendgrid.net");
		mailSender.setPort(587);
		mailSender.setUsername(env.getProperty("username"));
		mailSender.setPassword(env.getProperty("password"));

		System.out.println(">>>>>>>>> username: " + env.getProperty("username"));
		System.out.println(">>>>>>>>> password: " + env.getProperty("password"));

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.stmp.auth", true);
		props.put("mail.stmp.starttls.enable", true);
		props.put("mail.debug", false);
		props.put("mail.stmp.connectiontimeout", 10000); // miliseconds

		mailSender.setJavaMailProperties(props);

		return mailSender;
	}
}
