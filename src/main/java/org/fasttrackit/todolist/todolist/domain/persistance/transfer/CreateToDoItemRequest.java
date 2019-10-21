package org.fasttrackit.todolist.todolist.domain.persistance.transfer;


import java.time.LocalDate;

public class CreateToDoItemRequest {

    private String description;
    private LocalDate deadline;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
}
