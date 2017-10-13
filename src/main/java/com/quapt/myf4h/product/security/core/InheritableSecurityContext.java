package com.quapt.myf4h.product.security.core;

import org.springframework.util.Assert;

import com.quapt.myf4h.product.security.Realm;

/**
 * Context holding security realm for child threads.
 * 
 * @author sabir
 * 
 *         <p>
 *         Note: inspired by Spring {LocaleContext}
 *         </p>
 */
public class InheritableSecurityContext extends InheritableThreadLocal<Realm> {

    @Override
    public void set(Realm value) {
        Assert.notNull(value, "Only non-null value permitted.");
        super.set(value);
    }

}
