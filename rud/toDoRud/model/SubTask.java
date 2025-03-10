package rud.toDoRud.model;

import rud.toDoRud.util.TypeOfTask;

public class SubTask extends Task {

    private int idEpic;
    private final TypeOfTask typeOfTask;

    public SubTask(String name, String description, int idEpic) {
        super(name, description);
        this.idEpic = idEpic;
        typeOfTask = TypeOfTask.SUBTASK;
    }

    public int getIdEpic() {
        return idEpic;
    }

    public void setIdEpic(int idEpic) {
        this.idEpic = idEpic;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", id=" + super.getId() +
                ", status=" + super.getStatus() +
                ", typeOfTask=" + typeOfTask +
                ", idEpic=" + idEpic +
                '}'  + "\n";
    }
}
