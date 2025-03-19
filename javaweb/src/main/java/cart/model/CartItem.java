package cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CART_ITEM")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "MEMBER_ID")
    private Integer memberId;
    
    @Column(name = "PRODUCT_NAME")
    private String productName;
    
    @Column(name = "QUANTITY")
    private Integer quantity;
    
    @Column(name = "PRICE")
    private Integer price;
}
