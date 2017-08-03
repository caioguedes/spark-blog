import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        get("/", (request, response) -> "Welcome to the blog! :D");
    }
}