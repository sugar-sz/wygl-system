package com.sugar.wyglsystem.dto;

import com.sugar.wyglsystem.mbg.model.Role;
import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/19 19:03
 * @description：
 */
@Data
public class AdminUserDetails implements UserDetails {

    private WyglAdmin wyglAdmin;

    private List<Role> roleList;

    private String token;

    public AdminUserDetails(WyglAdmin wyglAdmin, List<Role> roleList) {
        this.wyglAdmin = wyglAdmin;
        this.roleList = roleList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleList.stream()
                .filter((role) -> role.getName() != null)
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    public void setPassword(String s) {
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
