package vn.iot.entity;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity @Table(name="videos")
public class Video implements Serializable {
  @Id @Column(name="videoId") private String videoId;

  @ManyToOne @JoinColumn(name="categoryId")
  private Category category;

  @Column(name="title", columnDefinition="NVARCHAR(255)") private String title;
  @Column(name="poster", columnDefinition="NVARCHAR(255)") private String poster;
  @Column(name="description", columnDefinition="NVARCHAR(MAX)") private String description;
  @Column(name="active") private boolean active;
  @Column(name="views") private int views;

  // getters/setters
  public String getVideoId(){ return videoId; }
  public void setVideoId(String id){ this.videoId=id; }
  public Category getCategory(){ return category; }
  public void setCategory(Category c){ this.category=c; }
  public String getTitle(){ return title; }
  public void setTitle(String t){ this.title=t; }
  public String getPoster(){ return poster; }
  public void setPoster(String p){ this.poster=p; }
  public String getDescription(){ return description; }
  public void setDescription(String d){ this.description=d; }
  public boolean getActive(){ return active; }
  public void setActive(boolean a){ this.active=a; }
  public int getViews(){ return views; }
  public void setViews(int v){ this.views=v; }
}
