package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.model.Product;
import product.service.ProductService;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String productList(Model model) {
        List<Product> products = productService.getAllProducts();
        
     // 디버깅용 로그 찍기
        System.out.println("products: " + products);
        System.out.println("불러온 상품 수 : " + (products != null ? products.size() : "null"));

        
        model.addAttribute("products", products);
        return "product/productList";
    }
}
/*
 // 테이블 생성
CREATE TABLE PRODUCTS (
ID NUMBER PRIMARY KEY,
NAME VARCHAR2(100) NOT NULL,
PRICE NUMBER NOT NULL,
DESCRIPTION VARCHAR2(4000),
IMAGE_URL VARCHAR2(255)
);

//데이터 삽입
INSERT INTO PRODUCTS (ID, NAME, PRICE, DESCRIPTION, IMAGE_URL)
VALUES (1, '상품 A', 10000, '상품 설명 A', 'images/product1.png');

INSERT INTO PRODUCTS (ID, NAME, PRICE, DESCRIPTION, IMAGE_URL)
VALUES (2, '상품 B', 15000, '상품 설명 B', 'images/product2.png');

COMMIT;


*/