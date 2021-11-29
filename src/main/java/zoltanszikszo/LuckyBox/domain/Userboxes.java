package zoltanszikszo.LuckyBox.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Userboxes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userboxesid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String name;
    private String category;
    private int price;
    private String img;
    private String alt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="userid")
    private User user;

    public Userboxes() {

    }

    public Userboxes(String name, String category, int price, LocalDate date, String img, String alt){
        super();
        this.name = name;
        this.category = category;
        this.price = price;
        this.date = date;
        this.img = img;
        this.alt = alt;
    }

    public Long getUserboxesid() {
        return userboxesid;
    }

    public void setUserboxesid(Long userboxesid){
        this.userboxesid = userboxesid;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getImg(){
        return img;
    }

    public void setImg(){
        this.img = img;
    }

    public String getAlt(){
        return alt;
    }

    public void setAlt(){
        this.alt = alt;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString(){
        return "Box{" +
                "id=" + userboxesid +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", date=" + date +
                ", img=" + img +
                ", alt=" + alt +
                '}';
    }
}
