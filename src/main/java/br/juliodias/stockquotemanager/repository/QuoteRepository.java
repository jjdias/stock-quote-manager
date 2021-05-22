package br.juliodias.stockquotemanager.repository;

import br.juliodias.stockquotemanager.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
