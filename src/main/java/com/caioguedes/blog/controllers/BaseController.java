package com.caioguedes.blog.controllers;

import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class BaseController {

    protected static TemplateEngine template;

    static {
        template = new HandlebarsTemplateEngine();
    }
}
