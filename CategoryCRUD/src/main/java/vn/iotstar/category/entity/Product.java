package vn.iotstar.category.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    
    @Column(length = 500, columnDefinition = "nvarchar(500) not null")
    private String productName;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(nullable = false)
    private double unitPrice;
    
    @Column(length = 200)
    private String images;
    
    @Column(columnDefinition = "nvarchar(500) not null")
    private String description;
    
    @Column(nullable = false)
    private double discount;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @Column(nullable = false)
    private short status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
