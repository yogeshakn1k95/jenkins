package com.artisantek;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
        }).start(5000);

        System.out.println("\nApplication is running on http://localhost:5000");
        System.out.println("Press Ctrl+C to stop.");

        app.get("/", ctx -> {
            ctx.html(Main.class.getResourceAsStream("/public/index.html"));
        });
    }
} 