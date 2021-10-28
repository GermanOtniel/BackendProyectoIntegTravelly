package Travelly.modeloVistaControlador.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table(name="media")
public class Media {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "media_id")
  private int mediaId;
//  @ManyToOne
//  @JoinColumn(name="user_id")
//  private User user;
    private int userId;

//  @ManyToOne
//  @JoinColumn(name="recommendation_id")
//  private Recommendation recommendation;
  private int recommendationId;
  private String content;
  private String mediaType;

  public String getMediaType() {
    return mediaType;
  }
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
  public int getMediaId() {
    return mediaId;
  }
  public void setMediaId(int mediaId) {
    this.mediaId = mediaId;
  }
  /*public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }*/
   public int getUserId() {
     return userId;
   }
   public void setUserId(int userID) {
     this.userId = userID;
   }
  /*public Recommendation getRecommendation() {
    return recommendation;
  }
  public void setRecommendation(Recommendation recommendation) {
    this.recommendation = recommendation;
  }*/

  public int getRecommendationId() {
    return recommendationId;
  }

  public void setRecommendationId(int recommendationId) {
    this.recommendationId = recommendationId;
  }

  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  

}
