package fr.timothe.quizadventure.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;


@RequiredArgsConstructor
@Getter
@Setter
public class Question {
    @MongoId
    private ObjectId id;
    private String text;
    private String difficulty;
    private List<String> answer;
    private String correctAnswer;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }
}
