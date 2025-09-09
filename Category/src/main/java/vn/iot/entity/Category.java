package vn.iot.entity;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity @Table(name="categories")
public class Category implements Serializable {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="categoryId") private int categoryId;

  @Column(name="categoryname", columnDefinition="NVARCHAR(255)") private String categoryname;
  @Column(name="images", columnDefinition="NVARCHAR(255)") private String images;
  @Column(name="status") private int status;

  @OneToMany(mappedBy="category") private List<Video> videos;

  // getters/setters
  public int getCategoryId(){ return categoryId; }
  public void setCategoryId(int id){ this.categoryId=id; }
  public String getCategoryname(){ return categoryname; }
  public void setCategoryname(String n){ this.categoryname=n; }
  public String getImages(){ return images; }
  public void setImages(String i){ this.images=i; }
  public int getStatus(){ return status; }
  public void setStatus(int s){ this.status=s; }
  public List<Video> getVideos(){ return videos; }
  public void setVideos(List<Video> v){ this.videos=v; }
}
