package br.juliodias.stockquotemanager.repository;

import br.juliodias.stockquotemanager.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
}
