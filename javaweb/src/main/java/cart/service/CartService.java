package cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.model.CartItem;
import cart.repository.CartRepository;
import product.model.Product;
import product.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;

    // 장바구니 목록 조회
    public List<CartItem> getCartItems(Integer memberId) {
        // memberId에 해당하는 장바구니 항목 조회
        return cartRepository.findByMemberId(memberId);
    }

 // 장바구니에 상품 추가    
    public void addToCart(Long productId, int memberId) {
        System.out.println("장바구니 추가 시도: productId=" + productId + ", memberId=" + memberId);

        Product product = productRepository.findById(productId)
            .orElseThrow(() -> {
                System.out.println("상품 못 찾음! productId: " + productId);
                return new IllegalArgumentException("상품을 찾을 수 없습니다.");
            });
    
        CartItem cartItem = new CartItem();
        cartItem.setMemberId(memberId);
        cartItem.setProductId(productId);
        cartItem.setProductName(product.getName());
        cartItem.setQuantity(1); // 기본 수량 1로 넣음
        cartItem.setPrice(product.getPrice());
        cartItem.setImageUrl(product.getImageUrl());

        cartRepository.save(cartItem);
        System.out.println("장바구니에 추가 완료: " + cartItem);
	}
    
    public void deleteCartItem(Integer cartItemId) {
        cartRepository.deleteById(cartItemId);
    }
    
    

}
