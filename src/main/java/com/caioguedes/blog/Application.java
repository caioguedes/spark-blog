package com.caioguedes.blog;

import com.caioguedes.blog.controllers.IndexController;
import com.caioguedes.blog.controllers.PostController;
import com.caioguedes.blog.dao.PostDao;

import spark.Spark;

public class Application {

    public static void main(String[] args) {
        Spark.staticFiles.location("/public");

        if (!System.getProperty("server_port").isEmpty()) {
            Spark.port(Integer.parseInt(System.getProperty("server_port")));
        }

        Spark.get("/", (request, response) -> new IndexController(new PostDao()).get(request, response));
        Spark.get("/posts/create", (request, response) -> new PostController(new PostDao()).create(request, response));
        Spark.get("/posts/:id", (request, response) -> new PostController(new PostDao()).view(request, response));
        Spark.post("/posts", (request, response) -> new PostController(new PostDao()).post(request, response));
    }
}