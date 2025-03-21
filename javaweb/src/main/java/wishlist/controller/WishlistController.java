package wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wishlist.model.WishlistItem;
import wishlist.service.WishlistService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    
	@Autowired
    private WishlistService wishlistService;
    
	
    @GetMapping("/wishlist")
    public String wishlistPage(@RequestParam(value="memberId", defaultValue="1") int memberId, Model model) {
        List<WishlistItem> wishlistItems = wishlistService.getWishlistItems(memberId);
        model.addAttribute("wishlistItems", wishlistItems);
        return "wishlist/wishlistPage";
    }
    
    @PostMapping("/add")
    @ResponseBody
    public String addToWishlist(@RequestParam("productId") Long productId,
                                @RequestParam(value = "memberId", defaultValue = "1") int memberId) {

        wishlistService.addToWishlist(productId, memberId);
        return "success";
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
    PRODUCT_ID NUMBER NOT NULL,
    PRODUCT_NAME VARCHAR2(100),
    PRICE NUMBER,
    IMAGE_URL VARCHAR2(255)
);


//데이터 삽입
INSERT INTO WISHLIST_ITEM (ID, MEMBER_ID, PRODUCT_NAME)
VALUES (1, 101, '찜한 상품 1');

INSERT INTO WISHLIST_ITEM (ID, MEMBER_ID, PRODUCT_NAME)
VALUES (2, 101, '찜한 상품 2');

COMMIT;


//시퀸스 삭제
DROP SEQUENCE WISHLIST_ITEM_SEQ;

*/