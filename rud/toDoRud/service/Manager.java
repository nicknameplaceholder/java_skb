package rud.toDoRud.service;

import rud.toDoRud.model.SubTask;
import rud.toDoRud.model.Task;
import rud.toDoRud.model.Epic;


import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    HashMap<Integer, Task> Task = new HashMap();
    HashMap<Integer, SubTask> SubTask = new HashMap();
    HashMap<Integer, Epic> Epic = new HashMap<>();
    private static int id = 0;
    ArrayList<Task> AllTasks = new ArrayList<>();


    public Task createTask(String name, String descr) {
        //подумать над реализацией метода для subTask и Epic
    }

    //В каждоый задаче продумать проверку на ввод не того id

    public Task getTaskById(int id) {
        //для Task простой вывод
        //для Epic выводится задача + количество его сабтасков
        //для subTask выводится задача + какая-то инфа о его эпике
    }

    public Task updateTask(Task task) {
        //Для Task получаем новый экземпляр класса, обновляем его и всё (Имя, описание и статус)
        //Для SabTask получаем новый экземпляр класса и обновляем его (Имя, описание и статус). В этом случае нужно
        //делать проверку статуса эпика.
        //Для Epic получаем новый экземпляр класса, можем изменить тоьлко имя и описание
    }

    public ArrayList<Task> deleteTask (int id) {
        //Удаление Task просто удалит Task
        //Удаление subTask удалит subTask, при это нужно сделать проверку статуса Epic
        //Удаление Epic ведет за собой удаление всех SubTask этого эпика
    }

    public ArrayList<SubTask> getAllSubTasksForEpic (int id) {
        //получаем список из эпика
        //сделать проверку на пустой список дабы избежать NullPointerException. Это хороший повод изучить конструкцию
        //try/catch для отлова ошибок и их обработки. Но это все будет дальше, поэтому можно не торопиться.
    }

    public ArrayList<Task> getAllTasks() {

    }



}
