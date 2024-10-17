package com.example.demo.controller;

import com.example.demo.model.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping()
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }
    @GetMapping("/add")
    public String add(Model model, @ModelAttribute Category category) {
        model.addAttribute("category", category);
        return "category/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute Category category) {
        if (categoryService.saveOrUpdate(category)!=null) {
            return "redirect:/category";
        }
        return "category/add";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/update";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Category category) {
        if (categoryService.saveOrUpdate(category)!=null) {
            return "redirect:/category";
        }
        return "category/update";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/category";
    }
}
