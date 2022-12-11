package online.niuma.xiaocubao.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.niuma.xiaocubao.pojo.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@code @date} 2022/12/8
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Getter
@Setter
@ToString
public class UserDetail extends BaseEntity implements UserDetails {

    private String username;

    private String nickname;

    private String password;

    private String email;

    private String asUsername;

    private Boolean locked;

    private Boolean enabled;

    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
