package br.juliodias.stockquotemanager.service;

import br.juliodias.stockquotemanager.model.Stock;
import br.juliodias.stockquotemanager.repository.StockRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService() {
    }

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public Stock getStocks(String id) {
        return stockRepository.findById(id)
                .orElse(null);
    }

    public void postNewStock(Stock stock) throws Exception {
        if (isStockValid(stock)) {
            stockRepository.save(stock);
        } else {
            throw new Exception();
        }
    }

    public Boolean isStockValid(Stock stock) {
        for (Stock index : getAllStocks()) {
            if (index.getId().equals(stock.getId())) {
                return true;
            }
        }
        return false;
    }

    public List<Stock> getAllStocks() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/stock")).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            List<Stock> stocks = objectMapper.readValue(response.body(), new TypeReference<List<Stock>>() {
            });

            return stocks;
        } catch (Exception e) {
            return null;
        }
    }
}
