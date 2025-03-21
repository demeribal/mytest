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
	 
	 @PostMapping("/delete")
	 @ResponseBody
	 public String deleteCartItem(@RequestParam("cartItemId") Integer cartItemId) {
	     cartService.deleteCartItem(cartItemId);
	     return "success";
	 }

}


/*
//테이블 생성

CREATE TABLE CART_ITEM (
    ID NUMBER PRIMARY KEY,
    MEMBER_ID NUMBER NOT NULL,
    PRODUCT_ID NUMBER NOT NULL, -- 외래키로 상품 ID 저장
    QUANTITY NUMBER,
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(ID)
);


CREATE TABLE CART_ITEM (
    ID NUMBER PRIMARY KEY,
    MEMBER_ID NUMBER NOT NULL,
    PRODUCT_NAME VARCHAR2(100),
    QUANTITY NUMBER,
    PRICE NUMBER,
    IMAGE_URL VARCHAR2(255)
);

d
//샘플 값
INSERT INTO CART_ITEM (ID, MEMBER_ID, PRODUCT_NAME, QUANTITY, PRICE)
VALUES (1, 101, '테스트 상품 1', 2, 5000);

INSERT INTO CART_ITEM (ID, MEMBER_ID, PRODUCT_NAME, QUANTITY, PRICE)
VALUES (2, 101, '테스트 상품 2', 1, 3000);

//시퀸스
CREATE SEQUENCE CART_ITEM_SEQ START WITH 1 INCREMENT BY 1;

//트리거
CREATE OR REPLACE TRIGGER CART_ITEM_TRG
BEFORE INSERT ON CART_ITEM
FOR EACH ROW
BEGIN
    SELECT CART_ITEM_SEQ.NEXTVAL INTO :NEW.ID FROM DUAL;
END;


COMMIT;



*/