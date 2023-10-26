import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private long id;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.id = -1; // Initialize with invalid id
        this.father = null;
        this.mother = null;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate);
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        if (child != null && !children.contains(child)) {
            children.add(child);
            if (gender == Gender.Male) {
                child.setFather(this);
            } else if (gender == Gender.Female) {
                child.setMother(this);
            }
        }
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
}
