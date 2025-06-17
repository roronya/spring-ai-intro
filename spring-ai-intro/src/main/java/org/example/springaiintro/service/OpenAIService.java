package org.example.springaiintro.service;

import org.example.springaiintro.model.Answer;
import org.example.springaiintro.model.GetCapitalRequest;
import org.example.springaiintro.model.GetCapitalResponse;
import org.example.springaiintro.model.Question;

public interface OpenAIService {

    String getAnswer(String question);

    Answer getAnswer(Question question);

    GetCapitalResponse getCapital(GetCapitalRequest getCapitalRequest);

    Answer getCapitalWithInfo(GetCapitalRequest getCapitalRequest);
}
