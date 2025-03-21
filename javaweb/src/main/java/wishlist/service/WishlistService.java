package wishlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.model.Product;
import product.repository.ProductRepository;
import wishlist.model.WishlistItem;
import wishlist.repository.WishlistRepository;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;
    
    @Autowired
    private ProductRepository productRepository;

 // 찜 목록 조회
    public List<WishlistItem> getWishlistItems(Integer memberId) {
        return wishlistRepository.findByMemberId(memberId);
    }

    // 찜 목록에 추가
    public void addToWishlist(Long productId, int memberId) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setMemberId(memberId);
        wishlistItem.setProductId(productId);
        wishlistItem.setProductName(product.getName());
        wishlistItem.setPrice(product.getPrice());
        wishlistItem.setImageUrl(product.getImageUrl());

        wishlistRepository.save(wishlistItem);
    }
}