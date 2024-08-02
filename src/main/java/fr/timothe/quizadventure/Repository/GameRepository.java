package fr.timothe.quizadventure.Repository;

import fr.timothe.quizadventure.Entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
}
