package org.fasttrackit.todolist.todolist.domain;

import java.time.LocalDate;

public class ToDoItem {

    private long id;
    private String description;
    private LocalDate deadLine;
    private boolean done;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

}
