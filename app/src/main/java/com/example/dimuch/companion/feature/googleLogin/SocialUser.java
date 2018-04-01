package com.example.dimuch.companion.feature.googleLogin;
import com.example.dimuch.companion.App;
import com.example.dimuch.companion.data.model.Profile;
import java.io.Serializable;
import javax.inject.Inject;

public class SocialUser implements Serializable {

  public String userId;
  public String accessToken;
  public String photoUrl;
  @Inject Profile profile;

  public SocialUser() {
  }

  public SocialUser(SocialUser other) {
    App.getComponent().inject(this);
    this.userId = other.userId;
    this.accessToken = other.accessToken;
    this.photoUrl = other.photoUrl;
    if (other.profile != null) {
      this.profile = new Profile(other.profile);
    }
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SocialUser that = (SocialUser) o;

    return userId != null ? userId.equals(that.userId) : that.userId == null;
  }

  @Override public int hashCode() {
    return userId != null ? userId.hashCode() : 0;
  }

  @Override public String toString() {
    final StringBuilder sb = new StringBuilder("SocialUser{");
    sb.append("userId='").append(userId).append('\'');
    sb.append(", accessToken='").append(accessToken).append('\'');
    sb.append(", photoUrl='").append(photoUrl).append('\'');
    sb.append(", profile=").append(profile);
    sb.append('}');
    return sb.toString();
  }
}