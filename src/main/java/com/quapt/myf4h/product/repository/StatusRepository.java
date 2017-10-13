/**
 * 
 */
package com.quapt.myf4h.product.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quapt.myf4h.product.domain.Status;

/**
 * @author user20
 *
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Serializable>{

}
