package com.quapt.myf4h.product.service;

import java.util.List;

import javax.inject.Inject;

import com.quapt.myf4h.product.domain.Status;
import com.quapt.myf4h.product.domain.UserStatus;
import com.quapt.myf4h.product.repository.StatusRepository;
import com.quapt.myf4h.product.repository.UserStatusRepository;

public class StatusService {
	
	@Inject
	private UserStatusRepository userStatusRepository;

	@Inject
	private StatusRepository statusRepository;
	
	public List<Status> findAll() {
		List<Status> userStatus = statusRepository.findAll();
		return userStatus;
	}

	public UserStatus save(UserStatus userStatus) {
		
		UserStatus result = userStatusRepository.save(userStatus);
		
		return result;
	}

}
