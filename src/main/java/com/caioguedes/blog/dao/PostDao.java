package com.caioguedes.blog.dao;

import com.caioguedes.blog.database.ConnectionFactory;
import com.caioguedes.blog.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    public Post get(int id) {
        try (
            Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from posts where id = ?")
        ) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                return null;
            }

            result.next();

            Post post = new Post() {{
                setId(result.getInt("id"));
                setTitle(result.getString("title"));
                setBody(result.getString("body"));
            }};

            return post;

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Post> all() {
        String query = "select * from posts";

        try (
            Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(query)
        ) {
            ResultSet result = statement.executeQuery();

            if (!result.isBeforeFirst()) {
                return null;
            }

            List<Post> posts = new ArrayList<>();
            while (result.next()) {
                posts.add(new Post() {{
                    setId(result.getInt("id"));
                    setTitle(result.getString("title"));
                    setBody(result.getString("body"));
                }});
            }

            return posts;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return new ArrayList<Post>();
    }

    public boolean save(Post post) {
        String query = "insert into posts values (?, ?, ?);";

        try (
            Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(query)
        ) {

            statement.setInt(1, post.getId());
            statement.setString(2, post.getTitle());
            statement.setString(3, post.getBody());

            statement.execute();

            return true;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }
}
