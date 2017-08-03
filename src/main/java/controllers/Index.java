package controllers;

import models.Post;
import spark.ModelAndView;
import spark.Response;
import spark.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Index extends Controller {

    public String get(Request request, Response response) {
        Map<String, Object> data = new HashMap<>();

        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post(){{
            setTitle("#1 Welcome to the blog!");
            setBody("<p>Well, this is the first blog post... then it's the number one.</p>");
        }});

        posts.add(new Post(){{
            setTitle("#2 Lorem ipsum dolor sit amet, consectetur adipiscing elit!");
            setBody("<p>Fusce faucibus quam vitae magna hendrerit sodales. Nullam scelerisque sapien quis risus porta");
        }});

        data.put("posts", posts);

        return template.render(new ModelAndView(data, "index.hbs"));
    }
}
