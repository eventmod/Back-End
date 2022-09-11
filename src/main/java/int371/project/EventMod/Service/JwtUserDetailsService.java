package int371.project.EventMod.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import int371.project.EventMod.Models.AuthenticationUser;
import int371.project.EventMod.Repositories.AccountsJpaRepository;

import org.springframework.security.core.GrantedAuthority;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	AccountsJpaRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthenticationUser user = userRepository.findByUsername(username);
		String role = "";
    if (user.getAdmins() != null && user.getCreators() == null) {
      role = "ADMIN";
    } else if (user.getCreators() != null && user.getAdmins() == null) {
      role = "CREATOR";
    }
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
}