package wishlist.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "WISHLIST_ITEM")  // 실제 테이블명 매핑
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")  // PK 컬럼명
    private int id;

    @Column(name = "MEMBER_ID")
    private int memberId;

    @Column(name = "PRODUCT_NAME")
    private String productName;
}
/*
CREATE TABLE PRODUCT (
	    ID NUMBER PRIMARY KEY,
	    NAME VARCHAR2(100) NOT NULL,
	    PRICE NUMBER NOT NULL,
	    IMAGE_URL VARCHAR2(255)
	);

	CREATE SEQUENCE PRODUCT_SEQ START WITH 1 INCREMENT BY 1;

	INSERT INTO PRODUCT (ID, NAME, PRICE, IMAGE_URL)
	VALUES (PRODUCT_SEQ.NEXTVAL, '나이키', 25000, '/static/image/nike.jpg');

	INSERT INTO PRODUCT (ID, NAME, PRICE, IMAGE_URL)
	VALUES (PRODUCT_SEQ.NEXTVAL, '아디다스', 45000, '/static/image/adidas.jpg');

	INSERT INTO PRODUCT (ID, NAME, PRICE, IMAGE_URL)
	VALUES (PRODUCT_SEQ.NEXTVAL, '휠라', 60000, '/static/image/fila.jpg');

	SELECT * FROM PRODUCT;

*/