package com.example.dimuch.companion.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Dimuch on 18.03.2018.
 */
@ToString @NoArgsConstructor @AllArgsConstructor public class ShoppingCenter {
  @Getter @Setter private int id;
  @Getter @Setter private int logoShoppingCenter;
  @Getter @Setter @SerializedName("name") private String name;
  @Getter @Setter @SerializedName("rating") private double rating;
  @Getter @Setter @SerializedName("address") private String address;
  @Getter @Setter @SerializedName("stores") private List<Store> stores;

  public ShoppingCenter(String name, double rating, String address, List<Store> stores) {
    this.name = name;
    this.rating = rating;
    this.address = address;
    this.stores = stores;
  }
}
