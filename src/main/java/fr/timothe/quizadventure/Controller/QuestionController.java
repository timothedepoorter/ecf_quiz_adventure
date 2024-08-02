package fr.timothe.quizadventure.Controller;

import fr.timothe.quizadventure.Entity.Question;
import fr.timothe.quizadventure.Service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping()
    public List<Question> getAllQuestions() {
        return this.questionService.findAll();
    }

    @GetMapping("/{difficulty}")
    public List<Question> getQuestionsByDifficulty(@PathVariable String difficulty) {
        return this.questionService.findQuestionByDifficulty(difficulty);
    }
}
