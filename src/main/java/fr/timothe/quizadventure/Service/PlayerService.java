package fr.timothe.quizadventure.Service;

import fr.timothe.quizadventure.Entity.Player;
import fr.timothe.quizadventure.Repository.PlayerRepository;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findPlayerByName(String username) throws ResponseStatusException {
        return this.playerRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun joueur trouvé avec le pseudo : " + username
                )
        );
    }

    public Player save(Player player) {
        Optional<Player> existingPlayer = playerRepository.findByUsername(player.getUsername());
        if (existingPlayer.isPresent()) {
            Player p = existingPlayer.get();
            return p;
        } else {
            return playerRepository.save(player);
        }
    }

    public Player findById(String id) {
        return this.playerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun joueur trouvé avec l'id' : " + id
                ));
    }

    public void delete(Player player) {
        this.playerRepository.delete(player);
    }

    public Player update(Player player, String id) {
        this.findById(id);
        player.setId(new ObjectId(id));
        return this.playerRepository.save(player);
    }
}
