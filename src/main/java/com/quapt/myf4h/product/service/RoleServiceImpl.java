package com.quapt.myf4h.product.service;

import org.springframework.stereotype.Service;

import com.quapt.myf4h.product.security.core.RoleService;

import java.util.Collection;
import java.util.Collections;

@Service
public class RoleServiceImpl implements RoleService {

    public Collection<String> getRoles(String userId) {
        return Collections.emptyList();
    }

}
