package fr.timothe.quizadventure.Repository;

import fr.timothe.quizadventure.Entity.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, String> {
    public Optional<Player> findByUsername(String username);
    public Optional<Player> findById(String id);
}
