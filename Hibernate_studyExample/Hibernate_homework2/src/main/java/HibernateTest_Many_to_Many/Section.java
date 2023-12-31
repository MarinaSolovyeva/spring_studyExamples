package HibernateTest_Many_to_Many;


import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "section")
public class Section {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    @ManyToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable (name = "child_section",
            joinColumns = @JoinColumn (name = "section_id"),
            inverseJoinColumns = @JoinColumn (name = "child_id")
    )
    private List <Child> children;

    public void addChildToSection (Child child){
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
