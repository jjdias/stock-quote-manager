package br.juliodias.stockquotemanager.controller;

import br.juliodias.stockquotemanager.model.Stock;
import br.juliodias.stockquotemanager.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stock")
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getStocks() {
        return stockService.getStocks();
    }

    @GetMapping("/single/{id}")
    public Stock getStocks(@PathVariable("id") String id) {
        return stockService.getStocks(id);
    }

    @PostMapping
    public ResponseEntity<Object> postNewStock(@RequestBody Stock stock){
        try{
            stockService.postNewStock(stock);
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("nok");
        }
    }
}
