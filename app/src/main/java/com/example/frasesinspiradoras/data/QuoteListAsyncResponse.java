package com.example.frasesinspiradoras.data;

import com.example.frasesinspiradoras.model.Frase;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Frase> frases);
}
