package org.example.springaiintro.controller;

import org.example.springaiintro.model.Answer;
import org.example.springaiintro.model.GetCapitalRequest;
import org.example.springaiintro.model.GetCapitalResponse;
import org.example.springaiintro.model.Question;
import org.example.springaiintro.service.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/capitalWithInfo")
    public Answer getCapitalWithInfo(@RequestBody GetCapitalRequest getCapitalRequest) {
        return openAIService.getCapitalWithInfo(getCapitalRequest);
    }

    @PostMapping("/capital")
    public GetCapitalResponse askCapital(@RequestBody GetCapitalRequest getCapitalReqeust) {
        return openAIService.getCapital(getCapitalReqeust);
    }

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question) {
        return openAIService.getAnswer(question);
    }
}
