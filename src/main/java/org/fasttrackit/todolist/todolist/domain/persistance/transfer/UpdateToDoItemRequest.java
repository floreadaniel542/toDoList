package org.fasttrackit.todolist.todolist.domain.persistance.transfer;

public class UpdateToDoItemRequest {

    private boolean done;


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "UpdateToDoItemRequest{" +
                "done=" + done +
                '}';
    }
}
