package com.example.dimuch.companion.data.model;

import com.example.dimuch.companion.R;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Dimuch on 07.12.2017.
 */
@ToString @NoArgsConstructor @AllArgsConstructor public class Store {
  @Getter @Setter private int id;
  @Getter @Setter private boolean favorite;
  @Getter @Setter private int logoStore = R.drawable.store;
  @Getter @Setter @SerializedName("name") private String name;
  @Getter @Setter @SerializedName("rating") private double rating;
  @Getter @Setter @SerializedName("type") private String type;
  @Getter @Setter @SerializedName("address") private String address;
  @Getter @Setter @SerializedName("website") private String website;
  @Getter @Setter @SerializedName("phone") private String phone;
  @Getter @Setter @SerializedName("workSchedule") private String workSchedule;
}
