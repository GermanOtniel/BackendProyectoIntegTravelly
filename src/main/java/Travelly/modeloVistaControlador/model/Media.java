package Travelly.modeloVistaControlador.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table(name="media")
public class Media {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name = "media_id")
  private int mediaId;
  private int userId;
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
  public int getUserId() {
    return userId;
  }
  public void setUserId(int userID) {
    this.userId = userID;
  }
  public int getRecommID() {
    return recommendationId;
  }
  public void setRecommID(int recommendationId) {
    this.recommendationId = recommendationId;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  

}
