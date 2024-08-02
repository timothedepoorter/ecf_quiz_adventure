package fr.timothe.quizadventure.Controller;

import fr.timothe.quizadventure.Entity.Player;
import fr.timothe.quizadventure.Service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping()
    public List<Player> getPlayers() {
        return this.playerService.findAll();
    }

    @GetMapping("/{username}")
    public Player getPlayerByName(@PathVariable String username) {
        return this.playerService.findPlayerByName(username);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Player addPlayer(@RequestBody Player player) {
        return this.playerService.save(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@RequestBody Player player, @PathVariable String id) {
        return this.playerService.update(player, id);
    }
}
