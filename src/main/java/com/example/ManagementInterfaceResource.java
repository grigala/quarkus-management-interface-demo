package com.example;

import io.quarkus.vertx.http.ManagementInterface;
import io.vertx.ext.auth.ChainAuth;
import io.vertx.ext.auth.authentication.AuthenticationProvider;
import io.vertx.ext.web.handler.AuthenticationHandler;
import io.vertx.ext.web.handler.BasicAuthHandler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ManagementInterfaceResource {
  public void registerManagementRoutes(@Observes ManagementInterface mi) {
//    AuthenticationProvider authProvider = ChainAuth.any();
//    AuthenticationHandler basicAuthHandler = BasicAuthHandler.create(authProvider);
//    mi.router().route("/*").handler(basicAuthHandler);
    mi.router().get("/test").handler(ctx -> {
      if (ctx.user() != null) {
        this.helloWorld();
        ctx.response().setStatusCode(200).end("Ok");
      } else {
        ctx.response().setStatusCode(401).end("Unauthorized");
      }
    });
  }

  private void helloWorld() {
    System.out.println("Hello World");
  }

}