package rud.toDoRud.model;

import rud.toDoRud.util.Status;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Integer> subTaskForEpic = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public ArrayList<Integer> getSubTaskForEpic() {
        return subTaskForEpic;
    }

    public void setSubTaskForEpic(int subTaskId) {
        subTaskForEpic.add(subTaskId);
    }
}
