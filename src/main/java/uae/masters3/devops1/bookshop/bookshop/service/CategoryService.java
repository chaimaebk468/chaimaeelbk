package uae.masters3.devops1.bookshop.bookshop.service;





import uae.masters3.devops1.bookshop.bookshop.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
}
