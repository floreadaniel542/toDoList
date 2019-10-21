package org.fasttrackit.todolist;

import org.fasttrackit.todolist.todolist.domain.ToDoItem;
import org.fasttrackit.todolist.todolist.domain.persistance.transfer.CreateToDoItemRequest;
import org.fasttrackit.todolist.todolist.domain.persistance.transfer.ToDoitemRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        CreateToDoItemRequest request = new CreateToDoItemRequest();
        request.setDescription("Learn JDBC");
        request.setDeadline(LocalDate.now().plusWeeks(1));

        ToDoitemRepository toDoitemRepository = new ToDoitemRepository();
       //toDoitemRepository.createToDoItem(request);

        List<ToDoItem> toDoItems = toDoitemRepository.getToDoItems();

        System.out.println(toDoItems);

    }
}
