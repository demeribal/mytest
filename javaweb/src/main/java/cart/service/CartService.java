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
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        CartItem cartItem = new CartItem();
        cartItem.setMemberId(memberId);
        cartItem.setProductName(product.getName());
        cartItem.setQuantity(1); // 기본 수량 1로 넣음
        cartItem.setPrice(product.getPrice());

        cartRepository.save(cartItem);
	}
}
