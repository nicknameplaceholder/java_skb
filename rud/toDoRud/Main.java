package rud.toDoRud;


import rud.toDoRud.controller.Manager;
import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.util.TypeOfTask;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();


        manager.createTaskAndEpic("Task 1", "Description 1", TypeOfTask.TASK);
        manager.createTaskAndEpic("Task 2", "Description 2", TypeOfTask.TASK);
        manager.createTaskAndEpic("Task 3", "Description 3", TypeOfTask.TASK);

        Epic epic1 = (Epic) manager.createTaskAndEpic("Epic 1", "Description 1", TypeOfTask.EPIC);
        Epic epic2 = (Epic) manager.createTaskAndEpic("Epic 2", "Description 2", TypeOfTask.EPIC);

        SubTask subTask1 = (SubTask) manager.createSubTask("SubTask1", "SubTask1", TypeOfTask.SUBTASK, epic1);
        SubTask subTask2 = (SubTask) manager.createSubTask("SubTask2", "SubTask2", TypeOfTask.SUBTASK, epic1);
        SubTask subTask3 = (SubTask) manager.createSubTask("SubTask3", "SubTask3", TypeOfTask.SUBTASK, epic1);

        SubTask subTask4 = (SubTask) manager.createSubTask("SubTask4", "SubTask4", TypeOfTask.SUBTASK, epic2);
        SubTask subTask5 = (SubTask) manager.createSubTask("SubTask5", "SubTask5", TypeOfTask.SUBTASK, epic2);
        SubTask subTask6 = (SubTask) manager.createSubTask("SubTask6", "SubTask6", TypeOfTask.SUBTASK, epic2);


        System.out.println("достаем все таски ");
        System.out.println(manager.getAllTasks());
        System.out.println("/n" + "Разграничение " + "/n");
        System.out.println("достаем все сабтаски для эпика 1 ");
        System.out.println(manager.getAllSubTasksForEpic(epic1.getId()));
        System.out.println("/n" + "Разграничение " + "/n");




    }
}