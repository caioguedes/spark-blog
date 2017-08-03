import controllers.Index;
import controllers.Post;

import spark.Spark;

public class Application {

    public static void main(String[] args) {
        Spark.staticFiles.location("/public");
        Spark.get("/", (request, response) -> new Index().get(request, response));
        Spark.get("/posts/:id", ((request, response) -> new Post().view(request, response)));
    }
}