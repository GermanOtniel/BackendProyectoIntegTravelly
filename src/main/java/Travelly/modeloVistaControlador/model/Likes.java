package Travelly.modeloVistaControlador.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table(name="likes")
public class Likes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "likes_id")
    private int likesId;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="recommendation_id")
    private Recommendation recommendation;

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
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
}

