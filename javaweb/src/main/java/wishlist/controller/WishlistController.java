package wishlist.controller;

import wishlist.service.WishlistService;
import wishlist.model.WishlistItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class WishlistController {
    
	@Autowired
    private WishlistService wishlistService;
    
    @GetMapping("/wishlist")
    public String wishlistPage(@RequestParam(value="memberId", defaultValue="1") int memberId, Model model) {
        List<WishlistItem> wishlistItems = wishlistService.getWishlistItems(memberId);
        model.addAttribute("wishlistItems", wishlistItems);
        return "wishlist/wishlistPage";
    }
    
	/*
	 * // setter for DI (혹은 @Autowired 사용) public void
	 * setWishlistService(WishlistService wishlistService) { this.wishlistService =
	 * wishlistService; }
	 */
}

/*
CREATE TABLE WISHLIST_ITEM (
    ID NUMBER PRIMARY KEY,
    MEMBER_ID NUMBER NOT NULL,
    PRODUCT_NAME VARCHAR2(100)
);

//데이터 삽입
INSERT INTO WISHLIST_ITEM (ID, MEMBER_ID, PRODUCT_NAME)
VALUES (1, 101, '찜한 상품 1');

INSERT INTO WISHLIST_ITEM (ID, MEMBER_ID, PRODUCT_NAME)
VALUES (2, 101, '찜한 상품 2');

COMMIT;


	CREATE SEQUENCE wishlist_item_seq START WITH 1 INCREMENT BY 1;

	-- 시퀀스 사용해서 insert하고 싶으면
	INSERT INTO WISHLIST_ITEM (id, member_id, product_name)
	VALUES (wishlist_item_seq.NEXTVAL, 1, '찜 상품 A');
*/