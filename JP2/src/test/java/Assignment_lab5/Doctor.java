package Assignment_lab5;

import java.io.Serializable;

public class Doctor implements Serializable {

    private String id;
    private String name;
    private String specialization;
    private int availHours;

    public Doctor(String id, String name, String specialization, int availHours) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availHours = availHours;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailHours() {
        return availHours;
    }

    public void setAvailHours(int availHours) {
        this.availHours = availHours;
    }

    @Override
    public String toString() {
        return "Doctor{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", specialization='" + specialization + '\''
                + ", availHours=" + availHours
                + '}';
    }
}
