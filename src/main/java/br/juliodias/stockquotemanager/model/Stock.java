package br.juliodias.stockquotemanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Stock {

    @Id
    private String id;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
    @JsonManagedReference
    private List<Quote> quotes;


    public Stock() {
    }

    public Stock(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Stock(String id, List<Quote> quotes) {
        this.id = id;
        this.quotes = quotes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
//        return description;
        return null;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
