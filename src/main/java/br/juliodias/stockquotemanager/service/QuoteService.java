package br.juliodias.stockquotemanager.service;

import br.juliodias.stockquotemanager.model.Quote;
import br.juliodias.stockquotemanager.repository.QuoteRepository;
import br.juliodias.stockquotemanager.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void postNewQuote(Quote quote) {
        quoteRepository.save(quote);
    }
}
