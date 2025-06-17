package org.example.springairag.controllers;

import org.example.springairag.model.Answer;
import org.example.springairag.model.Question;
import org.example.springairag.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionContoller {
    private final OpenAIService openAIService;


    public QuestionContoller(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }
}
