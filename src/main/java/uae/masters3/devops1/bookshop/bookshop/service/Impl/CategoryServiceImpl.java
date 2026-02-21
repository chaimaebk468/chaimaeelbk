package uae.masters3.devops1.bookshop.bookshop.service.Impl;



import org.springframework.stereotype.Service;
import uae.masters3.devops1.bookshop.bookshop.dto.CategoryResponse;
import uae.masters3.devops1.bookshop.bookshop.repository.CategoryRepository;
import uae.masters3.devops1.bookshop.bookshop.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indispensable pour l'injection
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(cat -> new CategoryResponse(cat.getId(), cat.getName()))
                .collect(Collectors.toList());
    }
}
