package dbdemo.neo4j.repositories;

import dbdemo.neo4j.domain.Movie;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends GraphRepository<Movie> {
    Movie findByTitle(@Param("title") String title);
}


