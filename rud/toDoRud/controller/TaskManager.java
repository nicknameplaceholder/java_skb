package rud.toDoRud.controller;

import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.util.TypeOfTask;

import java.util.ArrayList;

public interface TaskManager {

    Task createTaskAndEpic(String name, String descr, TypeOfTask typeOfTask);

    Task createSubTask(String name, String descr, TypeOfTask typeOfTask, Epic epic);

    Task getTaskById(int id);

    Task updateTask(Task task);

    boolean deleteTask(int id);

    ArrayList<SubTask> getAllSubTasksForEpic(int id);

    ArrayList<Task> getAllTasks();

    ArrayList<Task> getHistory();
}
