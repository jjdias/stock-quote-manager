package br.juliodias.stockquotemanager.config;

import br.juliodias.stockquotemanager.model.Quote;
import br.juliodias.stockquotemanager.model.Stock;
import br.juliodias.stockquotemanager.repository.QuoteRepository;
import br.juliodias.stockquotemanager.repository.StockRepository;
import br.juliodias.stockquotemanager.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StockConfiguration {

    private StockService stockService;
    @Autowired
    public StockConfiguration(StockService stockService) {
        this.stockService = stockService;
    }

    @Bean
    CommandLineRunner commandLineRunner(StockRepository stockRepository) {
        return args -> {
            stockRepository.saveAll(stockService.getAllStocks());
        };
    }

}
