package br.juliodias.stockquotemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Quote {

    @Id
    @SequenceGenerator(
            name = "quote_sequence",
            sequenceName = "quote_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quote_sequence"
    )
    private Integer id;
    private LocalDate insertDate;
    private double value;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    @JsonBackReference
    private Stock stock;

    public Quote() {
    }


    public Quote(LocalDate insertDate, double value, Stock stock) {
        this.insertDate = insertDate;
        this.value = value;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
