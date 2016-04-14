package dbdemo.mongo.repositories;


import dbdemo.mongo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
	User findByUsername(String username);
}
