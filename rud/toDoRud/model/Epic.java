package rud.toDoRud.model;

import rud.toDoRud.util.Status;
import rud.toDoRud.util.TypeOfTask;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<SubTask> subTaskForEpic = new ArrayList<>();
    private final TypeOfTask typeOfTask;

    public Epic(String name, String description) {
        super(name, description);
        typeOfTask = TypeOfTask.EPIC;
    }

    public ArrayList<SubTask> getSubTaskForEpic() {
        return subTaskForEpic;
    }

    public void setSubTaskForEpic(SubTask subTask) {
        subTaskForEpic.add(subTask);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", id=" + super.getId() +
                ", status=" + super.getStatus() +
                ", typeOfTask=" + typeOfTask +
                ", subTaskForEpic=" + subTaskForEpic +
                '}' + "\n";
    }
}
