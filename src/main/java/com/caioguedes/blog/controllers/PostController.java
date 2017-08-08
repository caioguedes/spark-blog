package com.caioguedes.blog.controllers;

import com.caioguedes.blog.dao.PostDao;
import com.caioguedes.blog.models.Post;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class PostController extends BaseController {

    private PostDao postDao;

    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    public String view(Request request, Response response) {

        Map<String, Object> data = new HashMap<>();
        int postId = Integer.parseInt(request.params("id"));

        Post post = this.postDao.get(postId);

        data.put("post", post);

        return template.render(new ModelAndView(data, "posts/view.hbs"));
    }

    public String create(Request request, Response response) {
        Map<String, Object> data = new HashMap<>();
        return template.render(new ModelAndView(data, "posts/create.hbs"));
    }

    public String post(Request request, Response response) {
        Map<String, Object> data = new HashMap<>();

        Post post = new Post();
        post.setTitle(request.queryParams("title"));
        post.setBody(request.queryParams("body"));

        this.postDao.save(post);

        data.put("message", "Post created!");
        return template.render(new ModelAndView(data, "posts/create.hbs"));
    }
}
