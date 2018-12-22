package dbdemo.neo4j.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "角色")
public class Role {
    @Id
    @GeneratedValue
    Long id;
    String name;

    @StartNode
    Movie movie;
    @EndNode
    Actor actor;

    public Role() {
    }

    public Role(Actor actor, Movie movie, String name) {
        this.actor = actor;
        this.movie = movie;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor getActor() {
        return actor;
    }

    public Movie getMovie() {
        return movie;
    }

}
