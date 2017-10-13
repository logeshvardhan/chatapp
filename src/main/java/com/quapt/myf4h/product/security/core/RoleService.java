package com.quapt.myf4h.product.security.core;

import java.util.Collection;

public interface RoleService {

    Collection<String> getRoles(String userId);
}
