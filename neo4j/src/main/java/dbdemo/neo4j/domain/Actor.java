package dbdemo.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Actor {
    @Id
    @GeneratedValue
    Long id;
    private String name;
    private int born;

    public Actor() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public int getBorn() {
        return born;
    }

}
