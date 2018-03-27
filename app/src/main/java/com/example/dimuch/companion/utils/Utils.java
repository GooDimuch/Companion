package com.example.dimuch.companion.utils;

import com.example.dimuch.companion.data.model.Store;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dimuch on 27.03.2018.
 */

public class Utils {

  public static void sortList(List<Store> list, int countFavorite) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = i; j < list.size(); j++) {
        if (list.get(j).isFavorite()) {
          Collections.swap(list, i, j);
          break;
        }
      }
    }
    Collections.sort(list.subList(0, countFavorite),
        ((o1, o2) -> o1.getName().compareTo(o2.getName())));
    Collections.sort(list.subList(countFavorite, list.size()),
        ((o1, o2) -> o1.getName().compareTo(o2.getName())));
  }
}
