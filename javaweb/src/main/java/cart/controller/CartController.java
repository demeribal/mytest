package cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cart.model.CartItem;
import cart.service.CartService;
import product.model.Product;
import product.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
    
	 @GetMapping
	    public String cartPage(@RequestParam(value = "memberId", defaultValue = "1") int memberId, Model model) {
	        List<CartItem> cartItems = cartService.getCartItems(memberId);
	        System.out.println(memberId);
	        model.addAttribute("cartItems", cartItems);
	        return "cart/cartPage";
	    }
	 
	 @PostMapping("/add")
	 @ResponseBody
	 public String addToCart(@RequestParam("productId") Long productId, 
			 @RequestParam(value = "memberId", defaultValue = "1") int memberId) {
	     cartService.addToCart(productId, memberId);
	     return "success";
	 }
}


/*
//테이블 생성
CREATE TABLE CART_ITEM (
    ID NUMBER PRIMARY KEY,
    MEMBER_ID NUMBER NOT NULL,
    PRODUCT_NAME VARCHAR2(100),
    QUANTITY NUMBER,
    PRICE NUMBER
);

d
//샘플 값
INSERT INTO CART_ITEM (ID, MEMBER_ID, PRODUCT_NAME, QUANTITY, PRICE)
VALUES (1, 101, '테스트 상품 1', 2, 5000);

INSERT INTO CART_ITEM (ID, MEMBER_ID, PRODUCT_NAME, QUANTITY, PRICE)
VALUES (2, 101, '테스트 상품 2', 1, 3000);

COMMIT;



*/