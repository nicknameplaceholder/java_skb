package rud.toDoRud.controller;

import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.service.Service;
import rud.toDoRud.util.TypeOfTask;

import java.util.ArrayList;


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
            SubTask st = service.createSubTask(name, descr, epic);
            service.updateEpicStatus(epic);
            return st;
        }
        return null;
    }

    public Task getTaskById(int id) {
        Task task = service.getTaskById(id);
        return task;
    }

    public Task updateTask(Task task) {
        Task taskForReturn = service.updateTask(task);
        return taskForReturn;
    }

    public boolean deleteTask(int id) {
        return service.deleteTask(id);
    }

    public ArrayList<SubTask> getAllSubTasksForEpic(int id) {
        ArrayList<SubTask> subTaskArrayList;
        subTaskArrayList = service.getAllSubTasksForEpic(id);
        return subTaskArrayList;
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> allTasks = new ArrayList<>();
        allTasks = service.getAllTasks();
        return allTasks;
    }


}
