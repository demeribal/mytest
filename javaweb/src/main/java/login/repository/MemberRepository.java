package login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import login.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // username으로 검색
    Optional<Member> findByUsername(String username);
}
