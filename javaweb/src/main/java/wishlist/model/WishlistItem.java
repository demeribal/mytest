package wishlist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "WISHLIST_ITEM")
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wishlist_item_seq_gen")
    @SequenceGenerator(name = "wishlist_item_seq_gen", sequenceName = "WISHLIST_ITEM_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "MEMBER_ID")
    private Integer memberId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "IMAGE_URL")
    private String imageUrl;
}
