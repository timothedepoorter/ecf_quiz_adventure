package fr.timothe.quizadventure.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Game {
    @MongoId
    private ObjectId id;
    private String state;
    private Integer score;
    @DBRef
    private Player player;
    @DBRef
    private List<Question> questions;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }
}
