package online.niuma.xiaocubao.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import online.niuma.xiaocubao.cofig.SecurityConfig;
import online.niuma.xiaocubao.service.IUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * {@code @date} 2022/12/8
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final IUserService userService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, IUserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {
        String header = request.getHeader(SecurityConfig.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConfig.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(header);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        if (header == null) {
            return null;
        }
        String username = JWT.require(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()))
                .build()
                .verify(header.replace(SecurityConfig.TOKEN_PREFIX, ""))
                .getSubject();
        if (username != null) {
            UserDetails userDetails = userService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
        }
        return null;
    }
}

