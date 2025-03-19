package wishlist.service;

import wishlist.model.WishlistItem;
import wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public List<WishlistItem> getWishlistItems(int memberId) {
        return wishlistRepository.findByMemberId(memberId);
    }
}
