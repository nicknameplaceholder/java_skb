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

    public Task getTaskById(int id) {
        if(task.containsKey(id)) {
            return task.get(id);
        } else if (subTask.containsKey(id)) {
            return subTask.get(id);
        } else if (epic.containsKey(id)) {
            return epic.get(id);
        }

        return null;
        //для Task простой вывод
        //для Epic выводится задача + количество его сабтасков
        //для subTask выводится задача + какая-то инфа о его эпике
    }

    public Task updateTask(Task taskForUpdate) {
        int ids = taskForUpdate.getId();
        if(task.containsKey(ids)) {
            task.remove(ids);
            return task.put(ids, taskForUpdate);
        } else if (subTask.containsKey(ids)) {
            subTask.remove(ids);
            return subTask.put(ids, (SubTask) taskForUpdate);
        } else if (epic.containsKey(id)) {
            epic.remove(ids);
            return epic.put(ids, (Epic) taskForUpdate);
        }

        return null;
        //Для Task получаем новый экземпляр класса, обновляем его и всё (Имя, описание и статус)
        //Для SabTask получаем новый экземпляр класса и обновляем его (Имя, описание и статус). В этом случае нужно
        //делать проверку статуса эпика.
        //Для Epic получаем новый экземпляр класса, можем изменить тоьлко имя и описание
    }


    public ArrayList<SubTask> getAllSubTasksForEpic(int id) {
        if(epic.containsKey(id)) {
            Epic epicForWork = epic.get(id);
            ArrayList<SubTask> subTaskArrayList = new ArrayList<>();
            ArrayList<Integer> tempListForCount = new ArrayList<>();
            tempListForCount.add(epicForWork.getSubTaskForEpic());
            for(Integer i : tempListForCount) {
                subTaskArrayList.add(subTask.get(i));
            }
            return subTaskArrayList;
        } else {
            return null;
        }
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> allTasks = new ArrayList<>();
        allTasks.addAll(task.values());
        allTasks.addAll(subTask.values());
        allTasks.addAll(epic.values());
        return allTasks;
    }

}
