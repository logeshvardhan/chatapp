package com.quapt.myf4h.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.quapt.myf4h.product.domain.Item;
@Repository
public interface ItemRepository extends MongoRepository<Item, String>{

	/*public interface ItemRepositoryCustom extends ItemRepository{
		int findByDescription();
	}*/
	
}
