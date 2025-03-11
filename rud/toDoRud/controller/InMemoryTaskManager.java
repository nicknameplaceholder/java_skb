package rud.toDoRud.controller;

import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.service.Service;
import rud.toDoRud.util.TypeOfTask;

import java.util.ArrayList;


public class InMemoryTaskManager implements TaskManager {


    Service service = new Service();

    @Override
    public Task createTaskAndEpic(String name, String descr, TypeOfTask typeOfTask) {
        if (typeOfTask == TypeOfTask.TASK) {
            return service.createTask(name, descr);
        } else if (typeOfTask == TypeOfTask.EPIC) {
            return service.createEpic(name, descr);
        }
        return null;
    }

    @Override
    public Task createSubTask(String name, String descr, TypeOfTask typeOfTask, Epic epic) {
        if (typeOfTask == TypeOfTask.SUBTASK) {
            SubTask st = service.createSubTask(name, descr, epic);
            return st;
        }
        return null;
    }

    @Override
    public Task getTaskById(int id) {
        return service.getTaskById(id);
    }

    @Override
    public Task updateTask(Task task) {
        return service.updateTask(task);
    }

    @Override
    public boolean deleteTask(int id) {
        return service.deleteTask(id);
    }

    @Override
    public ArrayList<SubTask> getAllSubTasksForEpic(int id) {
        return service.getAllSubTasksForEpic(id);
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @Override
    public ArrayList<Task> getHistory() {
        return service.getHistory();
    }


}
