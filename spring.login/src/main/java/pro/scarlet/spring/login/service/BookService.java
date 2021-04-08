package pro.scarlet.spring.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import pro.scarlet.spring.login.dao.BookDAO;
import pro.scarlet.spring.login.pojo.Book;
import pro.scarlet.spring.login.pojo.Category;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;
    
    public List<Book> list(){
        // Sort sort = new Sort(Sort.Direction.DESC, null);
        // return bookDAO.findAll(sort);
        return bookDAO.findAll();
    }

    public void addOrUpdate(Book book){
        bookDAO.save(book);
    }

    public void deleteById(int id){
        bookDAO.deleteById(id);
    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }
    
}
