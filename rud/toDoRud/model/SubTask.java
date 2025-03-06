package rud.toDoRud.model;

public class SubTask extends Task {

    private int idEpic;

    public SubTask(String name, String description) {
        super(name, description);
    }

    public SubTask(String name, String description, int idEpic) {
        super(name, description);
        this.idEpic = idEpic;
    }

    public int getIdEpic() {
        return idEpic;
    }

    public void setIdEpic(int idEpic) {
        this.idEpic = idEpic;
    }
}
