package fr.timothe.quizadventure.Service;

import fr.timothe.quizadventure.Entity.Game;
import fr.timothe.quizadventure.Entity.Player;
import fr.timothe.quizadventure.Entity.Question;
import fr.timothe.quizadventure.Repository.GameRepository;
import fr.timothe.quizadventure.Repository.PlayerRepository;
import fr.timothe.quizadventure.Repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final QuestionRepository questionRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game save(Game game) {
        Player player = playerRepository.findById(game.getPlayer().getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Joueur inconnu"
                ));
        List<Question> questions = game.getQuestions();
        for (Question question : questions) {
            questionRepository.findById(String.valueOf(question.getId()))
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Question inconnue pour l'id : " + question.getId()
                    ));
        }

        game.setPlayer(player);
        game.setQuestions(questions);
        return gameRepository.save(game);
    }
}
