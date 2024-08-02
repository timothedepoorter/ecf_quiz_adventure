package fr.timothe.quizadventure.Controller;

import fr.timothe.quizadventure.Entity.Game;
import fr.timothe.quizadventure.Service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    private final GameService gameService;

    @GetMapping()
    public List<Game> getGames() {
        return gameService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody Game game) {
        return gameService.save(game);
    }
}
