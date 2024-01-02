package de.qaware.seudemo;

import spark.Spark;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String message = "";
        System.out.println(Main.class.getCanonicalName());

        try {
            message = new String(Files.readAllBytes(Paths.get("/workspace/secret.txt")));
        } catch (IOException e) {
            message = "You are probably not running this in GitPod";
        }

        serve(message);
    }

    private static void serve(String message) {
        Spark.port(8080);
        Spark.get("/", (req, res) -> message);
    }
}