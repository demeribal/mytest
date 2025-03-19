package wishlist.repository;

import wishlist.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistItem, Integer> {

    // memberId로 위시리스트 아이템 조회
    List<WishlistItem> findByMemberId(int memberId);
}
