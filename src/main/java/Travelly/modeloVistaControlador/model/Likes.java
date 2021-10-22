package Travelly.modeloVistaControlador.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table(name="likes")
public class Likes {
    @Id
    @Column(name = "user_id")
    private int userID;
    private int recommID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRecommID() {
        return recommID;
    }

    public void setRecommID(int recommID) {
        this.recommID = recommID;
    }
}

