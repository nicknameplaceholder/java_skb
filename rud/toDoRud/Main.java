package rud.toDoRud;


import rud.toDoRud.controller.Manager;
import rud.toDoRud.model.Task;
import rud.toDoRud.util.TypeOfTask;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        Task task1 = manager.createTask("aad", "asd", TypeOfTask.TASK);
        System.out.println(manager.getAllTasks().toString());

    }
}