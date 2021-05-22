package br.juliodias.stockquotemanager.service;

import br.juliodias.stockquotemanager.model.Stock;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceTest {

    private StockService stockService = new StockService();

    @Test
    void isStockValid() {

        assertFalse(stockService.isStockValid(
                new Stock("petr3", "Qualquercoisa")
        ));
        assertTrue(stockService.isStockValid(
                new Stock("petr4", "Petrobras PN")
        ));


    }
}