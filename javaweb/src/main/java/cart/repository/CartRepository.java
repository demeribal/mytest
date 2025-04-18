package cart.repository;

import cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer> {

    // memberId로 장바구니 목록 조회
    List<CartItem> findByMemberId(Integer memberId);
    
    //다중 삭제
    void deleteAllByIdIn(List<Integer> ids);

}


