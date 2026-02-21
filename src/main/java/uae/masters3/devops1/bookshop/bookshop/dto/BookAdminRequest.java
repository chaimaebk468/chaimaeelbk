package uae.masters3.devops1.bookshop.bookshop.dto;

import lombok.Data;

@Data
public class BookAdminRequest {

    private String title;
    private String author;
    private double price;
    private int stock;
    private String description;
    private Long categoryId;
}