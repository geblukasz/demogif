package com.ak.demoGif.model.repository;


import com.ak.demoGif.model.Category;
import com.ak.demoGif.model.Gif;
import org.springframework.stereotype.Repository;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true, 1),
            new Gif("ben-and-mike", "mika", true, 2),
            new Gif("book-dominos", "mem", true, 0),
            new Gif("compiler-bot", "bot", true, 1),
            new Gif("cowboy-coder", "code", true, 1),
            new Gif("infinite-andrew", "andrew", true, 2)
    );
    public List<Gif> getGifs(){
        return ALL_GIFS;
    };

    public String getGifNames() {
        String result = "";
        for (Gif allGif : ALL_GIFS) {
            result += allGif.getName();
        }
        return result;
    }

    public List<Gif> getFavoritesGifs() {
        List<Gif> favoriteGifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS){
            if (gif.getFavorite()){
                favoriteGifs.add(gif);
            }
        }
        return favoriteGifs;
    }

    public List<Gif> getGifsByCategoryId(int id) {
        List<Gif> categories = new ArrayList<>();

        for (Gif gif : ALL_GIFS){
            if (gif.getCategoryId() == id){
                categories.add(gif);
            }
        }
        return categories;
    }

    public Gif getGifByName(String name) {

        for (Gif gif : ALL_GIFS){
            if (name.equals(gif.getName())){
                return gif;
            }
        }
        return null;
//        return Optional.empty();
    }
}
