package zoltanszikszo.LuckyBox.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="usertable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid", nullable = false, updatable = false)
    private Long userid;

    @Column(name="username", nullable = false, updatable = false)
    private String username;

    @Column(name="passwordHash", nullable = false)
    private String passwordHash;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="role", nullable = false)
    private String role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Userboxes> boxes;

    public User() {

    }

    public User(String username, String passwordHash, String email, String role){
        super();
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Long getUserid(){
        return userid;
    }

    public void setUserid(Long userid){
        this.userid = userid;
    }

    public String getPasswordHash(){
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash){
        this.passwordHash = passwordHash;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email = email;
    }

    public String getRole(){
        return role;
    }

    public void setRole(){
        this.role = role;
    }

    public List<Userboxes> getBoxes(){
        return boxes;
    }

    public void setBoxes(List<Userboxes> boxes) {
        this.boxes = boxes;
    }
}
