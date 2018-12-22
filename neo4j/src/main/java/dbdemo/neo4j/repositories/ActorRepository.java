package dbdemo.neo4j.repositories;

import dbdemo.neo4j.domain.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
}


