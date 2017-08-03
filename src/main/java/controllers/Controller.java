package controllers;

import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Controller {

    protected static TemplateEngine template;

    static {
        template = new HandlebarsTemplateEngine();
    }
}
