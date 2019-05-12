package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/showGifsInBrowser")
    @ResponseBody
    public String showGifsInBrowser(){
        return gifRepository.getGifNames();
    }

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap){
        // 1. Wyciąganie gifów
        List<Gif> gifList = gifRepository.getGifs();
        // 2. Przekazanie gifa do view
        modelMap.put("gifs", gifList);
        // 3. Zwracanie widoku
        return "home";
    }

    @RequestMapping("/favorites")
    public String gifFavortes(ModelMap modelMap){
        //Według schematu:
        // 1. Pobieramy liste gifow (tylko ulubionych)
        List<Gif> favoriteGifs = gifRepository.getFavoritesGifs();

        // 2. Przekazanie gifow do widoku
        modelMap.put("gifs", favoriteGifs);

        // Informacja: widok nazywa sie favorites.html

        return "favorites";
    }

    /*
    C - create
    R - read
    U - update
    D - delete

    * */

    @RequestMapping("/gif/{name}")
    public String gifRepository(@PathVariable String name, ModelMap modelMap){
        Gif gif  = gifRepository.getGifByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }


}
