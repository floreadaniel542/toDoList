package org.fasttrackit.todolist.todolist.domain.persistance.transfer;

import org.fasttrackit.todolist.todolist.domain.ToDoItem;
import org.fasttrackit.todolist.todolist.domain.persistance.DatabaseConfiguration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoitemRepository {

    public void createToDoItem(CreateToDoItemRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = "INSERT INTO  to_do_item (description, deadline) VALUES (? , ?)";
        // try-with-resources
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadline()));

            preparedStatement.executeUpdate();

        }

    }

    public void updateToDoItem(long id, boolean done) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE to_do_item SET done=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, done);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();

        }
    }

    public void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM to_do_item WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<ToDoItem> getToDoItems() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT id, description, deadLine, done FROM to_do_item";

        List<ToDoItem> toDoItems = new ArrayList<>();

        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                ToDoItem toDoItem = new ToDoItem();

                toDoItem.setId(resultSet.getLong("id"));
                toDoItem.setDescription(resultSet.getString("description"));
                toDoItem.setDeadLine(resultSet.getDate("deadline").toLocalDate());
                toDoItem.setDone(resultSet.getBoolean("done"));

                toDoItems.add(toDoItem);

            }

        }
        return toDoItems;
    }
}

