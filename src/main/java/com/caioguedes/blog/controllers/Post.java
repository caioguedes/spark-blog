package com.caioguedes.blog.controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class Post extends Controller {

    public String view(Request request, Response response) {

        Map<String, Object> data = new HashMap<>();

        data.put("post", new com.caioguedes.blog.models.Post(){{
            setTitle("#1 Welcome to the blog!");
            setBody("<p>Well, this is the first blog post... then it's the number one.</p>");
        }});

        return template.render(new ModelAndView(data, "posts/view.hbs"));
    }
}
