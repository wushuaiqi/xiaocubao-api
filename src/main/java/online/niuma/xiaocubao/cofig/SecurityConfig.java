package online.niuma.xiaocubao.cofig;

import online.niuma.xiaocubao.exception.RestAuthenticationEntryPoint;
import online.niuma.xiaocubao.filter.JwtAuthorizationFilter;
import online.niuma.xiaocubao.service.IUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

/**
 * {@code @date} 2022/12/8
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String SECRET = "NiumaMusic";
    public static final long EXPIRATION_TIME = 864000000;  // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CREATE_TOKEN_URL = "/tokens";

    @Resource
    private IUserService userService;
    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(CREATE_TOKEN_URL).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userService))
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger**/**")
                .antMatchers("/webjars/**")
                .antMatchers("/v3/**")
                .antMatchers("/doc.html");
    }
}
