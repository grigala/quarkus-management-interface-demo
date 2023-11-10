package com.example;

import io.quarkus.vertx.http.ManagementInterface;
import jakarta.enterprise.event.Observes;

public class ManagementInterfaceResource {

  public void registerManagementRoutes(@Observes ManagementInterface mi) {
    mi.router().get("/test").handler(ctx -> {
        this.helloWorld();
        ctx.response().setStatusCode(200).end("Ok");
    });
  }

  private void helloWorld() {
    System.out.println("Hello World");
  }

}