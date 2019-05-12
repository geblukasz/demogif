package com.ak.demoGif.controller;

import com.ak.demoGif.model.Category;
import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.CategoryRepository;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {


    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/categories")
    public String gifCategories(ModelMap modelMap){
        List<Category> categoryList = categoryRepository.getAlllCategories();
        // 2. Przekazanie obiektow do widoku
        modelMap.put("categories", categoryList);
        return "categories";

    }
    @RequestMapping("/category/{id}")
    public String gifsCategory(@PathVariable int id, ModelMap modelMap){

        // 1. Pobranie gifów z id danej kategorii
        List<Gif> gifsByCategory = gifRepository.getGifsByCategoryId(id);

        // 2. Pobranie kategorii po id
        Category category = categoryRepository.getCategoryById(id);

        modelMap.put("gifs", gifsByCategory);
        modelMap.put("category", category);


        return "category";

    }

}
