package rud.toDoRud.service;


import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.util.TypeOfTask;

import java.util.ArrayList;
import java.util.HashMap;

public class Service {

    HashMap<Integer, Task> task = new HashMap();
    HashMap<Integer, SubTask> subTask = new HashMap();
    HashMap<Integer, Epic> epic = new HashMap<>();
    private static int id = 0;

    ArrayList<Task> allTasks = new ArrayList<>(); //подумать над структурой для вывода всех тасков


    public Task createTask(String name, String description) {
        Task newTask = new Task(name, description);
        newTask.setId(id);
        id += 1;
        task.put(newTask.getId(), newTask);
        return newTask;
    }

    public Epic createEpic(String name, String description) {
        Epic newEpic = new Epic(name, description);
        newEpic.setId(id);
        id += 1;
        epic.put(newEpic.getId(), newEpic);
        return newEpic;
    }

    public SubTask createSubTask(String name, String description, Epic epic) {
        SubTask newSubTask = new SubTask(name, description, epic.getId());
        newSubTask.setId(id);
        id += 1;
        subTask.put(newSubTask.getId(), newSubTask);
        epic.setSubTaskForEpic(epic.getId());
        return newSubTask;
    }


}
