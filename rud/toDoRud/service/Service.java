package rud.toDoRud.service;


import rud.toDoRud.model.Epic;
import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.util.Status;
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
        epic.setSubTaskForEpic(newSubTask);
        id += 1;
        subTask.put(newSubTask.getId(), newSubTask);
        return newSubTask;
    }

    public Task getTaskById(int id) {
        if (task.containsKey(id)) {
            return task.get(id);
        } else if (subTask.containsKey(id)) {
            return subTask.get(id);
        } else if (epic.containsKey(id)) {
            return epic.get(id);
        }
        return null;
    }

    public Task updateTask(Task taskForUpdate) {
        int ids = taskForUpdate.getId();
        if (task.containsKey(ids)) {
            task.remove(ids);
            task.put(ids, taskForUpdate);
            return task.get(ids);
        } else if (subTask.containsKey(ids)) {
            subTask.remove(ids);
            SubTask subTask1 = (SubTask) taskForUpdate;
            updateEpicStatus(epic.get(subTask1.getIdEpic()));
            subTask.put(ids, (SubTask) taskForUpdate);
            return subTask.get(ids);
        } else if (epic.containsKey(ids)) {
            epic.remove(ids);
            epic.put(ids, (Epic) taskForUpdate);
            return epic.get(ids);
        }
        return null;
    }


    public ArrayList<SubTask> getAllSubTasksForEpic(int id) {
        if (epic.containsKey(id)) {
            Epic epicForWork = epic.get(id);
            ArrayList<SubTask> subTaskArrayList = new ArrayList<>();
            subTaskArrayList.addAll(epicForWork.getSubTaskForEpic());
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

    public boolean deleteTask(int id) {
        ArrayList<SubTask> tempListForCount = new ArrayList<>();
        if (epic.containsKey(id)) {
            tempListForCount.addAll(getAllSubTasksForEpic(id));
            for (SubTask subTask : tempListForCount) {
                deleteTask(subTask.getId());
                return true;
            }
            epic.remove(id);
        } else if (subTask.containsKey(id)) {
            int epicId = subTask.get(id).getIdEpic();
            subTask.remove(id);
            updateEpicStatus(epic.get(epicId));
            return true;
        } else if (task.containsKey(id)) {
            task.remove(id);
            return true;
        }
        return false;
    }

    public void updateEpicStatus(Epic epicForUpdateStatus) {
        int weight = 0;
        ArrayList<SubTask> tempList = new ArrayList<>(epicForUpdateStatus.getSubTaskForEpic());

        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).getStatus() == Status.NEW) {
                weight++;
            } else if (tempList.get(i).getStatus() == Status.IN_PROGRESS) {
                weight = weight + 2;
            } else if (tempList.get(i).getStatus() == Status.DONE) {
                weight = weight + 3;
            }
        }
        if (weight == tempList.size()) {
            epicForUpdateStatus.setStatus(Status.NEW);
        } else if (weight == tempList.size() * 3) {
            epicForUpdateStatus.setStatus(Status.DONE);
        } else {
            epicForUpdateStatus.setStatus(Status.IN_PROGRESS);
        }
    }

}
