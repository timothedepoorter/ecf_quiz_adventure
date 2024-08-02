package fr.timothe.quizadventure.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;


@AllArgsConstructor
@Getter
@Setter
public class Player {
    @MongoId
    private ObjectId id;
    private String username;
    private Integer highscore;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }
}
