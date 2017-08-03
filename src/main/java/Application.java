import models.Post;

import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {
        get("/", (request, response) -> {

            Post post1 = new Post();
            post1.setTitle("First Blog Post");
            post1.setBody("This is the first post of blog, then... is the number 1.");

            String html = "<html><head></head><body><h2>" + post1.getTitle() + "</h1><p>" + post1.getTitle() + "</p></body></html>";
            return html;
        });
    }
}