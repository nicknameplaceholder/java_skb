package rud.toDoRud.controller;

import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.service.Service;
import rud.toDoRud.util.TypeOfTask;

import java.util.ArrayList;
import java.util.HashMap;


public class Manager {


    Service service = new Service();

    public Task createTaskAndEpic(String name, String descr, TypeOfTask typeOfTask) {
        if (typeOfTask == TypeOfTask.TASK) {
            return service.createTask(name, descr);
        } else if (typeOfTask == TypeOfTask.EPIC) {
            return service.createEpic(name, descr);
        }
        return null;
    }

    public Task createSubTask(String name, String descr, TypeOfTask typeOfTask, Epic epic) {
        if (typeOfTask == TypeOfTask.SUBTASK) {
            return service.createSubTask(name, descr, epic);
        }
        return null;
    }

    //В каждоый задаче продумать проверку на ввод не того id

    public Task getTaskById(int id) {
        Task task = service.getTaskById(id);
        return task;
        //для Task простой вывод
        //для Epic выводится задача + количество его сабтасков
        //для subTask выводится задача + какая-то инфа о его эпике
    }

    public Task updateTask(Task task) {
        Task taskForReturn = service.updateTask(task);
        return taskForReturn;
        //Для Task получаем новый экземпляр класса, обновляем его и всё (Имя, описание и статус)
        //Для SabTask получаем новый экземпляр класса и обновляем его (Имя, описание и статус). В этом случае нужно
        //делать проверку статуса эпика.
        //Для Epic получаем новый экземпляр класса, можем изменить тоьлко имя и описание
    }

    public ArrayList<Task> deleteTask(int id) {

        //Удаление Task просто удалит Task
        //Удаление subTask удалит subTask, при это нужно сделать проверку статуса Epic
        //Удаление Epic ведет за собой удаление всех SubTask этого эпика
    }

    public ArrayList<SubTask> getAllSubTasksForEpic(int id) {
        ArrayList<SubTask> subTaskArrayList = new ArrayList<>();
        subTaskArrayList= service.getAllSubTasksForEpic(id);
        return subTaskArrayList;
        //получаем список из эпика
        //сделать проверку на пустой список дабы избежать NullPointerException. Это хороший повод изучить конструкцию
        //try/catch для отлова ошибок и их обработки. Но это все будет дальше, поэтому можно не торопиться.
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> allTasks = new ArrayList<>();
        allTasks = service.getAllTasks();
        return allTasks;
    }


}
