package int371.project.EventMod.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import int371.project.EventMod.Models.AuthenticationUser;
import int371.project.EventMod.Models.JwtRequest;
import int371.project.EventMod.Models.JwtResponse;
import int371.project.EventMod.Repositories.AccountsJpaRepository;
import int371.project.EventMod.Service.JwtTokenService;
import int371.project.EventMod.Service.ServiceUtil;

@CrossOrigin
@RestController
public class AuthenController {
  
  @Autowired
  JwtTokenService jwtTokenService;

  @Autowired
	AccountsJpaRepository accountsJpaRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

  // --------------------- GetMapping ---------------------

  @GetMapping("/me")
  public AuthenticationUser getMe() {
    String username = ServiceUtil.getUsername();
    // System.out.println(username);
    return accountsJpaRepository.findByUsername(username);
  }

  @GetMapping("/accounts")
  public List<AuthenticationUser> showAllAccounts() {
    return accountsJpaRepository.findAll();
  }

  @GetMapping("/checkUsername/{username}")
	public boolean checkUsername(@PathVariable("username") String username) {
		try {
			if (accountsJpaRepository.findByUsername(username).getUsername().equals(username)) {
				System.out.println(accountsJpaRepository.findByUsername(username).getUsername());
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			return false;
		}
	}

  @GetMapping("/getID/{username}")
  public AuthenticationUser findByUsername(@PathVariable("username") String username) {
    AuthenticationUser account = accountsJpaRepository.findByUsername(username);
    return account;
  }

  // --------------------- PostMapping ---------------------

  @PostMapping("/register")
  public String register (@RequestParam("username") String username,
  @RequestParam("password") String password,
  @RequestParam("faculty") Optional<String> faculty) {
    String encodedPassword = passwordEncoder.encode(password);
    if (!checkUsername(username)) {
      System.out.println("Pass Check Username");
      AuthenticationUser newUser = new AuthenticationUser();
      newUser.setUsername(username);
      newUser.setPassword(encodedPassword);
      newUser.setAccountFaculty(faculty.orElse(null));
      accountsJpaRepository.save(newUser);
      return "Register Complete";
    }
    return "";
  }

  @PostMapping("/login")
	public JwtResponse getlogin(@RequestBody JwtRequest authenticationRequest) throws Exception {
		AuthenticationUser user = accountsJpaRepository.findByUsername(authenticationRequest.getUsername());
		if (user == null) {
			throw new Exception();
		}
		if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
			throw new Exception();
		}
		UserDetails userdetail = new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    // System.out.println("userDetails: " + userdetail);
    String role = "";
    if (user.getAdmins() != null && user.getCreators() == null) {
      role = "ADMIN";
    } else if (user.getCreators() != null && user.getAdmins() == null) {
      role = "CREATOR";
    }
		String tk = jwtTokenService.generateToken(userdetail, role);
    // System.out.println(tk);
		return new JwtResponse(tk);
	}

  @DeleteMapping("/delAccount/{accountID}")
  public void delAccount (@PathVariable int accountID) {
    accountsJpaRepository.deleteById(accountID);
  }
}
