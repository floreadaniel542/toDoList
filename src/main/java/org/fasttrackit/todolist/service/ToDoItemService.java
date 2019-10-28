package org.fasttrackit.todolist.service;

import org.fasttrackit.todolist.todolist.domain.ToDoItem;
import org.fasttrackit.todolist.todolist.domain.persistance.transfer.CreateToDoItemRequest;
import org.fasttrackit.todolist.todolist.domain.persistance.transfer.ToDoitemRepository;
import org.fasttrackit.todolist.todolist.domain.persistance.transfer.UpdateToDoItemRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ToDoItemService {

    private ToDoitemRepository  toDoitemRepository = new ToDoitemRepository();

    public void createToDoItem(CreateToDoItemRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating to-do-item: " + request);
        toDoitemRepository.createToDoItem(request);
    }
    public void updateToDoItem(long id, UpdateToDoItemRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating to-do-item: " + request);
        toDoitemRepository.updateToDoItem(id, request.isDone());
    }

    public  void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting item " + id);
        toDoitemRepository.deleteToDoItem(id);
    }
    public List<ToDoItem> getToDoItems() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving to-do-items...");
        return toDoitemRepository.getToDoItems();
    }
}
