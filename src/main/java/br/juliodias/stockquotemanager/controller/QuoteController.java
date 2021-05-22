package br.juliodias.stockquotemanager.controller;

import br.juliodias.stockquotemanager.model.Quote;
import br.juliodias.stockquotemanager.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/quote")
public class QuoteController {

    private QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public void postNewStock(@RequestBody Quote quote){
        quoteService.postNewQuote(quote);
    }
}
