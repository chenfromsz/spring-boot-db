package dbdemo.neo4j.test;

import dbdemo.neo4j.Application;
import dbdemo.neo4j.config.Neo4jConfig;
import dbdemo.neo4j.domain.Actor;
import dbdemo.neo4j.domain.Movie;
import dbdemo.neo4j.domain.Role;
import dbdemo.neo4j.repositories.ActorRepository;
import dbdemo.neo4j.repositories.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Neo4jConfig.class, Application.class})
@SpringBootTest
public class Neo4jTest {
    private static Logger logger = LoggerFactory.getLogger(Neo4jTest.class);

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ActorRepository actorRepository;

    @Before
    public void initData(){
        movieRepository.deleteAll();
        actorRepository.deleteAll();

        Movie movie = new Movie();
        movie.setTitle("战狼");
        movie.setYear("2015");

        Actor actor = new Actor();
        actor.setBorn(1974);
        actor.setName("吴京");

        movie.addRole(actor,  "冷峰");

        movieRepository.save(movie);
        Assert.notNull(movie.getId(), "create error");

    }

    @Test
    public void get(){
        Movie movie = movieRepository.findByTitle("战狼");
        Assert.notNull(movie, "find error");
        logger.info("===movie=== movie:{}, {}",movie.getTitle(), movie.getYear());
        for(Role role : movie.getRoles()){
            logger.info("====== actor:{}, role:{}", role.getActor().getName(), role.getName());
        }
    }
}
