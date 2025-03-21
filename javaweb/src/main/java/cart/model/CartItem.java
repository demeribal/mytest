package cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import product.model.Product;

@Entity
@Data
@Table(name = "CART_ITEM")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_item_seq_gen")
    @SequenceGenerator(name = "cart_item_seq_gen", sequenceName = "CART_ITEM_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "MEMBER_ID")
    private Integer memberId;
    
    @Column(name = "PRODUCT_ID")
    private Long productId;
 
    @Column(name = "PRODUCT_NAME")
    private String productName;
    
    @Column(name = "PRICE")
    private Integer price;
    
    @Column(name = "QUANTITY")
    private Integer quantity;
    
    @Column(name = "IMAGE_URL")
    private String imageUrl;
}
