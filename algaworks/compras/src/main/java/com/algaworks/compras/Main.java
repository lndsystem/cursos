package com.algaworks.compras;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.algaworks.compras.config.AppConfigAutowired;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigAutowired.class);

		// Bean
		// Checkout checkout = context.getBean(Checkout.class);
		// checkout.finalizar();

		// Componentes
		ChecoutComponent c1 = context.getBean(ChecoutComponent.class);
		c1.finalizar();
		
		ChecoutComponent c2 = context.getBean(ChecoutComponent.class);
		c2.finalizar();
		
		ChecoutComponent c3 = context.getBean(ChecoutComponent.class);
		c3.finalizar();

		System.out.println(c1.getQuantidadePedidosFinalizados());

		((ConfigurableApplicationContext) context).close();
	}
}
