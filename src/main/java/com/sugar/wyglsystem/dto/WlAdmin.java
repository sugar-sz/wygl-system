package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/19 19:03
 * @description：
 */
@Data
public class WlAdmin implements UserDetails {

    private WyglAdmin wyglAdmin;

    private String token;

    public WlAdmin(WyglAdmin wyglAdmin) {
        this.wyglAdmin = wyglAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public void setPassword(String s){
        this.wyglAdmin.setPassword(s);
    }
    @Override
    public String getPassword() {
        return wyglAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return wyglAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
