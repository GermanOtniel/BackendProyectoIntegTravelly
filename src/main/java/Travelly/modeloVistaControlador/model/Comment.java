package Travelly.modeloVistaControlador.model;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "comment_id")
    private int commID;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @Column(name = "user_id")
    private Long userID;

    @ManyToOne
    @JoinColumn(name="recommendation_id")
    private Recommendation recommendation;
    @Column(name = "recommendation_id")
    private Long recommendationId;
    private String comment;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    public int getCommID() {
        return commID;
    }

    public void setCommID(int commID) {
        this.commID = commID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comments) {
        this.comment = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
