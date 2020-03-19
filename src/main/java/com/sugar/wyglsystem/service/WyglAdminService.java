package com.sugar.wyglsystem.service;

import com.sugar.wyglsystem.mbg.model.WyglAdmin;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/2 11:10
 * @description： admin service
 */
public interface WyglAdminService extends UserDetailsService {
    WyglAdmin login(String username, String password);
    WyglAdmin register(WyglAdmin wyglAdmin);
    WyglAdmin getAdminById(Long id);
}
