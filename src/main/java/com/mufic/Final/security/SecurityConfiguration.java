package com.mufic.Final.security;

import com.mufic.Final.repositories.UserRepository;
import com.mufic.Final.security.jwt.AuthEntryPointJwt;
import com.mufic.Final.security.jwt.AuthTokenFilter;
import com.mufic.Final.security.services.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserPrincipalDetailsService userPrincipalDetailsService;
    private UserRepository userRepository;
    private AuthEntryPointJwt authEntryPointJwt;




    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository, AuthEntryPointJwt authEntryPointJwt) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.userRepository = userRepository;
        this.authEntryPointJwt = authEntryPointJwt;
    }


    /*


//    for Memory Authentication
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("Admin").password(passwordEncoder().encode("admin")).
//                roles("ADMIN").authorities("ACCESS_API","ACCESS_WEB")
//                .and()
//                .withUser("user").password(passwordEncoder().encode("user"))
//                .roles("USER").authorities("ACCESS_WEB");
//    }



//    for MVC Security with jdbc (user, roles, privillage)
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .antMatchers("/index.html").permitAll()
//                .antMatchers("/student/profile").authenticated()
//                .antMatchers("/api/**").hasRole("ADMIN")
//                .antMatchers("/api/**").hasAnyRole("ADMIN","USER")
//                .antMatchers("/api/**").hasAnyAuthority("READ_API")
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .httpBasic() //remove it if u assign login page
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/api");
//                .and().rememberMe().tokenValiditySeconds(2592000);
//    }
*/


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


 //AWT Security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // remove csrf and state in session because in jwt we do not need them
                .cors().and().csrf().disable()
                //for exception handling EntryPoint
                .exceptionHandling().authenticationEntryPoint(authEntryPointJwt)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // configure access rules
                .antMatchers("/api/auth/**","/h2-console/**",
                        "/v2/api-docs/**",
                        "/swagger-ui.html/**",
                        "/swagger-resources/**").permitAll()
//                .antMatchers("/api/students/**").hasRole("USER")
//                .antMatchers("/api/courses/**").hasRole("ADMIN")
//                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
        http
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http
                .headers().frameOptions().sameOrigin() // H2 Console Needs this setting
                .cacheControl(); // disable caching

    }


    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
