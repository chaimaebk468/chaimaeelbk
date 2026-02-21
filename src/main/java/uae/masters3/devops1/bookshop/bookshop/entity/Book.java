package uae.masters3.devops1.bookshop.bookshop.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String author;

    private double price;

    private int stock;


    @Column(length = 2000)
    private String description;

    @JsonBackReference   // ← côté enfant (ne sera pas sérialisé)


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public Category getCategory() {
        return category;
    }



    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setAuthor(String author) { this.author = author; }

    public void setPrice(double price) { this.price = price; }

    public void setStock(int stock) { this.stock = stock; }

    public void setDescription(String description) { this.description = description; }

    public void setCategory(Category category) { this.category = category; }
}


