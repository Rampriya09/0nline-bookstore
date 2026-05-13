package com.bookstore.online_bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        String sql = "SELECT * FROM books";
        List<Book> listBooks = jdbcTemplate.query(sql, 
                new BeanPropertyRowMapper<>(Book.class));
        
        model.addAttribute("listBooks", listBooks);
        return "index"; 
    }
}