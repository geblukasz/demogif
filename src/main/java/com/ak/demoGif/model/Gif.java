package com.ak.demoGif.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gif {

   private String name;
   private String username;
   private Boolean favorite;
   private int categoryId;

   public Gif(String name, String username, Boolean favorite, int categoryId) {
      this.name = name;
      this.username = username;
      this.favorite = favorite;
      this.categoryId = categoryId;
   }
}
