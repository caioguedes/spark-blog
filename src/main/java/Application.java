import static spark.Spark.*;

import controllers.Index;

public class Application {

    public static void main(String[] args) {
        staticFiles.location("/public");

        get("/", (request, response) -> new Index().get(request, response));
    }
}