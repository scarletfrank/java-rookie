package pro.scarlet.spring.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pro.scarlet.spring.login.pojo.Category;
import pro.scarlet.spring.login.dao.CategoryDAO;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list(){
        // Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll();
    }

    public Category get(int id) {
        Category c =  categoryDAO.findById(id).orElse(null);
        return c;
    }
    
}
