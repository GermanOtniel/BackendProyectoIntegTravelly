package Travelly.modeloVistaControlador.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="recommendations")
public class Recommendation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "recommendation_id")
    private int recommID;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    private String summary;
    private String text;
    private int userId;
    private String location;
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
//    public int getCategoryID() {
//        return categoryId;
//    }
//
//    public void setCategoryID(int categoryID) {
//        this.categoryId = categoryID;
//    }

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

    public int getUserID() {
        return userId;
    }

    public void setUserID(int userID) {
        this.userId = userID;
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
}
