package de.qaware.seudemo;

import io.javalin.Javalin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String message = "";
        System.out.println(Main.class.getCanonicalName());

        try {
            // please don't check this file in the terminal, that's no fun!
            message = new String(Files.readAllBytes(Paths.get("/workspace/secret.txt")));
        } catch (IOException e) {
            message = "You are probably not running this in GitPod";
        }

        serve(message);
    }

    private static void serve(String message) {
        // Start a super simple Webserver that only returns the specified message
        Javalin.create()
                .get("/", ctx -> ctx.result(message))
                .start(8080);
    }
}