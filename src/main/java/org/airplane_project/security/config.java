package org.airplane_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class config {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager udm =  new JdbcUserDetailsManager(dataSource);
        udm.setUsersByUsernameQuery("select * from members where user_id = ?");
        udm.setAuthoritiesByUsernameQuery("select * from roles where user_id = ?");
        return udm;
    }

    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
    {
     http.authorizeHttpRequests(config ->
            config
                    .requestMatchers(HttpMethod.GET, "/api/flights").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/api/flights/**").hasRole("USER")
                    .requestMatchers(HttpMethod.POST, "/api/flights").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/api/flights").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/flights/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/flights/date/**").hasRole("USER")
                    .requestMatchers(HttpMethod.GET,"/api/flights/**/**").hasRole("USER")
//                    .requestMatchers(HttpMethod.GET, "/api/airplane").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.GET, "/api/airplane/**").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.POST, "/api/airplane").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.PUT, "/api/airplane").hasRole("ADMIN")
//                    .requestMatchers(HttpMethod.DELETE, "/api/airplane/**").hasRole("ADMIN")


     );

     http.httpBasic(Customizer.withDefaults());
     http.csrf(csrf -> csrf.disable() );

     return http.build();
    }

}
