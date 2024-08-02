package fr.timothe.quizadventure.Repository;

import fr.timothe.quizadventure.Entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends MongoRepository<Question, String> {
    public Optional<List<Question>> findAllByDifficulty(String difficulty);
}
