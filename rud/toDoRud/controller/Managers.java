package rud.toDoRud.controller;

public class Managers {

    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }
}
