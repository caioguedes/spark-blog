package com.caioguedes.blog.controllers;

import com.caioguedes.blog.dao.PostDao;
import spark.ModelAndView;
import spark.Response;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

public class IndexController extends BaseController {

    private PostDao postDao;

    public IndexController(PostDao postDao) {
        this.postDao = postDao;
    }

    public String get(Request request, Response response) {
        Map<String, Object> data = new HashMap<>();

        data.put("posts", this.postDao.all());

        return template.render(new ModelAndView(data, "index.hbs"));
    }
}
