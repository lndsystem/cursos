package com.lndsystem;

import static io.javalin.apibuilder.ApiBuilder.crud;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.lndsystem.dao.DAO;

import io.javalin.Javalin;
import io.javalin.json.JavalinJson;


public class Application {
	public static void main(String[] args) {
		Javalin app = Javalin.create()
				.enableCorsForAllOrigins()
				.defaultContentType("application/json")
				.start(7000);

		DAO dao = new DAO();
		bindJson();
		
		app.get("/", ctx -> ctx.result("Hello from Javalin By School of net")); 
		
		app.routes(() -> {
			/**
			 * .get() -> getAll
			 * .get(:id) - getOne
			 * .put/.patch -> update
			 * .delete -> delete
			 */
			crud("people/:id", new PersonCrud(dao));
		});
		
	}

	
	protected static void bindJson() {
		Jsonb json = JsonbBuilder.create();
		
		JavalinJson.setFromJsonMapper(json::fromJson);
		JavalinJson.setToJsonMapper(json::toJson);
	}
}
