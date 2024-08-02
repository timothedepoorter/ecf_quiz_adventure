package fr.timothe.quizadventure.Service;

import fr.timothe.quizadventure.Entity.Question;
import fr.timothe.quizadventure.Repository.QuestionRepository;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

    @Service
    @AllArgsConstructor
    public class QuestionService {
        private final QuestionRepository questionRepository;

        public List<Question> findAll() {
            return questionRepository.findAll();
        }

        public List<Question> findQuestionByDifficulty(String difficulty) throws ResponseStatusException {
            return this.questionRepository.findAllByDifficulty(difficulty).orElseThrow(
                    () -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Aucune question trouvée avec la difficulté : " + difficulty
                    )
            );
        }
}
