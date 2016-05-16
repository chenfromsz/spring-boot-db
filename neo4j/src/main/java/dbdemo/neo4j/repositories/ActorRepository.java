package dbdemo.neo4j.repositories;

import dbdemo.neo4j.domain.Actor;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends GraphRepository<Actor> {
}


