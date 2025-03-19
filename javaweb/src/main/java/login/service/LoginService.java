package login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import login.model.Member;
import login.repository.MemberRepository;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

	
	@Autowired private BCryptPasswordEncoder passwordEncoder;
	 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("login procedure!!!!!!");
        System.out.println(username);

        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        System.out.println(member);

        List<GrantedAuthority> authorities = new ArrayList<>();
        switch (member.getRole()) {
            case "ROLE_ADMIN":
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
            case "ROLE_USER":
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                break;
            default:
                authorities.add(new SimpleGrantedAuthority("ROLE_GUEST"));
                break;
        }

        return new User(
                member.getUsername(),
                member.getPassword(), // 이미 암호화되어 있어야 함!
                authorities
        );
    }
}
