package int371.project.EventMod.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@CrossOrigin
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

	@Value("#{'${project.origin.method}'.split(',')}")
	private String[] methodList;
	@Value("#{'${project.origin.host}'.split(',')}")
	private String[] hostList;
	@Value("#{'${project.origin.header}'.split(',')}")
	private String[] headerList;

	@Autowired
	JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())/*.httpBasic((withDefaults()))*/;
		// http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		// .authorizeRequests().antMatchers("/*").permitAll()
		// .antMatchers("").hasAnyAuthority("")
		// .antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated();

		http.cors(
			config -> {
				CorsConfiguration cors = new CorsConfiguration();
				cors.setAllowCredentials(true);
				cors.setAllowedOrigins(Arrays.asList(hostList));
				cors.setAllowedMethods(Arrays.asList(methodList));
				cors.setAllowedHeaders(Arrays.asList(headerList));

				UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
				source.registerCorsConfiguration("/**", cors);

				config.configurationSource(source);}
		).csrf()
		.disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers("/").hasRole("ADMIN")
		.antMatchers("/").hasRole("CREATOR")
		.antMatchers("/**").anonymous().anyRequest().authenticated().and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	/*private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
		return null;
	}*/

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/**");
	}

}