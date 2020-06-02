package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.charity.seciurytyUser.CustomUserDetailsService;
//import pl.coderslab.charity.userSeciurity.SpringDataUserDetailsService;
//import pl.coderslab.charity.seciurityUser.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    private CustomUserDetailsService customUserDetailsService;
////
////    @Autowired
////    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
////        this.customUserDetailsService = customUserDetailsService;
////    }
////
////    @Override
////    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////
////        auth.userDetailsService(customUserDetailsService)
////                .passwordEncoder(passwordEncoder());
////    }
//

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password("{noop}user123").roles("USER")
//                .and()
//                .withUser("admin1").password("{noop}admin123").roles("ADMIN");
//    }
//
////    @Bean
////    public SpringDataUserDetailsService customUserDetailsService() {
////        return new SpringDataUserDetailsService();
////    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/user/**", "/").permitAll()
////                .antMatchers("/donation/**").authenticated()
//                .antMatchers("/donation/**").hasRole("USER")
//                .and().formLogin().permitAll()
//                .and().logout().logoutSuccessUrl("/login");
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/login")
//                .permitAll()
//                .antMatchers("/donation/**")
//                .hasAnyRole("ADMIN", "USER")
//                .and()
//                .formLogin()
//                .loginPage("/login")
////                .defaultSuccessUrl("/home")
////                .failureUrl("/login?error=true")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/")
////                .invalidateHttpSession(true);
////                .permitAll()
//                .and()
//                .csrf()
//                .disable();
//    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    private CustomUserDetailsService customUserDetailsService;


    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/user/**", "/").permitAll()
//                .antMatchers("/donation/**").hasAnyAuthority("USER", "ADMIN")
////                .antMatchers("/authorForm/**").hasRole("USER")
//                .and().formLogin()
//                .and().logout().logoutSuccessUrl("/login");
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login")
                .permitAll()
                .antMatchers("/hi/").hasAuthority("ADMIN")
                .antMatchers("/donation/**")
                .hasAnyAuthority("USER")
                .and()
                .formLogin()
                .loginPage("/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true);
//                .permitAll()
                .and()
                .csrf()
                .disable();
    }



    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
