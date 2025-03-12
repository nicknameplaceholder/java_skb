package rud.toDoRud;


import rud.toDoRud.controller.Managers;
import rud.toDoRud.controller.TaskManager;
import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.util.TypeOfTask;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = Managers.getDefault();


        Task task1 = manager.createTaskAndEpic("Task 1", "Description 1", TypeOfTask.TASK);
        Task task2 = manager.createTaskAndEpic("Task 2", "Description 2", TypeOfTask.TASK);
        Task task3 = manager.createTaskAndEpic("Task 3", "Description 3", TypeOfTask.TASK);


        Epic epic1 = (Epic) manager.createTaskAndEpic("Epic 1", "Description 1", TypeOfTask.EPIC);
        Epic epic2 = (Epic) manager.createTaskAndEpic("Epic 2", "Description 2", TypeOfTask.EPIC);


        SubTask subTask1 = (SubTask) manager.createSubTask("SubTask1", "SubTask1", TypeOfTask.SUBTASK, epic1);
        SubTask subTask2 = (SubTask) manager.createSubTask("SubTask2", "SubTask2", TypeOfTask.SUBTASK, epic1);
        SubTask subTask3 = (SubTask) manager.createSubTask("SubTask3", "SubTask3", TypeOfTask.SUBTASK, epic1);


        SubTask subTask4 = (SubTask) manager.createSubTask("SubTask4", "SubTask4", TypeOfTask.SUBTASK, epic2);
        SubTask subTask5 = (SubTask) manager.createSubTask("SubTask5", "SubTask5", TypeOfTask.SUBTASK, epic2);
        SubTask subTask6 = (SubTask) manager.createSubTask("SubTask6", "SubTask6", TypeOfTask.SUBTASK, epic2);

        System.out.println("Достаем задачи по id для заполнения истории");
        System.out.println(manager.getTaskById(0));
        System.out.println(manager.getTaskById(1));
        System.out.println(manager.getTaskById(2));
        System.out.println(manager.getTaskById(0));
        System.out.println(manager.getTaskById(1));
        System.out.println(manager.getTaskById(2));
        System.out.println(manager.getTaskById(0));
        System.out.println(manager.getTaskById(1));
        System.out.println(manager.getTaskById(2));
        System.out.println(manager.getTaskById(0));
        System.out.println(manager.getTaskById(7));
        System.out.println(manager.getTaskById(8));
        System.out.println(manager.getTaskById(9));
        System.out.println("\n" + " Разграничение " + "\n");

        System.out.println("Смотрим историю просмотров");
        System.out.println(manager.getHistory());
        System.out.println("\n" + " Разграничение " + "\n");

//        System.out.println("Достаем все таски \n");
//        System.out.println(manager.getAllTasks().toString());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Смотрим историю просмотров");
//        System.out.println(manager.getHistory());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Достаем все сабтаски для эпика 1 ");
//        System.out.println(manager.getAllSubTasksForEpic(epic1.getId()).toString());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Смотрим историю просмотров");
//        System.out.println(manager.getHistory());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Достаем все сабтаски для эпика 2 ");
//        System.out.println(manager.getAllSubTasksForEpic(epic2.getId()).toString());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Смотрим историю просмотров");
//        System.out.println(manager.getHistory());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Достаем Task по ID = 0");
//        System.out.println(manager.getTaskById(0));
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Смотрим историю просмотров");
//        System.out.println(manager.getHistory());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Достаем Epic по ID = 3");
//        System.out.println(manager.getTaskById(3));
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Достаем SubTask по ID = 6");
//        System.out.println(manager.getTaskById(6));
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Смотрим историю просмотров");
//        System.out.println(manager.getHistory());
//        System.out.println("\n" + " Разграничение " + "\n");

//        System.out.println("Обновляем Task");
//        Task task1Updated = task1;
//        task1Updated.setName("Updated task1");
//        task1Updated.setDescription("updated description 1");
//        task1Updated.setStatus(Status.IN_PROGRESS);
//        System.out.println(manager.updateTask(task1Updated).toString());
//        System.out.println("\n" + " Разграничение " + "\n");

//        System.out.println("Обновляем Epic");
//        Epic epic1Updated = epic1;
//        epic1Updated.setName("Updated epic 1");
//        epic1Updated.setDescription("updated description 1");
//        epic1Updated.setStatus(Status.IN_PROGRESS);
//        System.out.println(manager.updateTask(epic1Updated).toString());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Обновляем SubTask");
//        SubTask subTask5Updated = subTask5;
//        subTask5Updated.setName("Updated subTask 5");
//        subTask5Updated.setDescription("updated description 5");
//        subTask5Updated.setStatus(Status.IN_PROGRESS);
//        System.out.println(manager.updateTask(subTask5Updated).toString());
//        System.out.println("\n" + " Проверяем изменение состояния Epic2" + "\n");
//        System.out.println(manager.getTaskById(4).toString());
//        System.out.println("\n" + " Разграничение " + "\n");


//        System.out.println("Удаляем Task");
//        System.out.println(manager.deleteTask(0));
//        System.out.println(manager.getAllTasks());
//        System.out.println("\n" + " Разграничение " + "\n");

//        System.out.println("Удаляем Epic");
//        System.out.println(manager.deleteTask(3));
//        System.out.println(manager.getAllTasks());
//        System.out.println("\n" + " Разграничение " + "\n");
//
//        System.out.println("Удаляем SubTask");
//        System.out.println(manager.deleteTask(7));
//        System.out.println(manager.getAllTasks());
//        System.out.println("\n" + " Разграничение " + "\n");


    }

}