package Travelly.modeloVistaControlador.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="recommendations")
public class Recommendation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "recommendation_id")
    private int recommID;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    private String summary;
    private String text;
    //private int userId;
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;
    private String location;
    @OneToMany(mappedBy = "recommendationId")
    List<Media> uploadedMedia;

//    @Transient
//    @Formula("select count(*) from Comment c where c.recommendationId = recommID")
//    private int numberOfComments;
    @OneToMany(mappedBy = "recommendationId")
    List<Comment> comments;

    @OneToMany(mappedBy = "recommendationId")
    List<Likes> likes;

    @CreationTimestamp
    private Date createdAt;

    public int getRecommID() {
        return recommID;
    }

    public void setRecommID(int recommID) {
        this.recommID = recommID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*public int getUserID() {
        return userId;
    }

    public void setUserID(int userID) {
        this.userId = userID;
    }*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Media> getUploadedMedia() {
        return uploadedMedia;
    }

    public void setUploadedMedia(List<Media> uploadedMedia) {
        this.uploadedMedia = uploadedMedia;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /*public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }*/

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }
}
