package dbdemo.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Movie {
    @Id
    @GeneratedValue
    Long id;
    String title;
    String year;

    @Relationship(type="角色", direction = Relationship.OUTGOING)
    List<Role> roles = new ArrayList<>();

    public Role addRole(Actor actor, String name){
        Role role = new Role(actor,this, name);
        this.roles.add(role);
        return role;
    }

    public Movie() { }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
