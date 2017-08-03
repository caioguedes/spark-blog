import spark.Spark;

import controllers.Index;

public class Application {

    public static void main(String[] args) {
        Spark.staticFiles.location("/public");
        Spark.get("/", (request, response) -> new Index().get(request, response));
    }
}