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
        try {
            Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select * from posts where id = ?"
            );
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

            result.close();
            statement.close();
            connection.close();

            return post;

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Post> all() {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "select * from posts"
            );
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

            result.close();
            statement.close();
            connection.close();

            return posts;

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
