package com.example.dimuch.companion.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimuch on 25.03.2018.
 */

public class Profile {

  public String name;
  public String firstName;
  public String lastName;
  public String email;
  public String pageLink;
  public String photoUrl;
  public List<Store> favoriteStoresList;

  public Profile() {
    favoriteStoresList = new ArrayList<>();
  }

  public Profile(Profile other) {
    this();
    this.name = other.name;
    this.firstName = other.firstName;
    this.lastName = other.lastName;
    this.email = other.email;
    this.pageLink = other.pageLink;
    this.photoUrl = other.photoUrl;
  }

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("Profile{");
    sb.append("name='").append(name).append('\'');
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(name).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", pageLink='").append(pageLink).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
