package com.quapt.myf4h.product.rest.resources;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quapt.myf4h.product.domain.Item;
import com.quapt.myf4h.product.repository.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Inject
	private ItemRepository repo;

	int i = 0;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List query() {
		List<Item> item = repo.findAll();
		return repo.findAll();
	}

	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAggregation() {
		String value = "welcome";

		return value;

	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item addItem(@RequestBody Item item) {
		/* System.out.println("Inside Add Item"); */
		return repo.save(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Item updateItem(@RequestBody Item updatedItem, @PathVariable String id) {
		System.out.println("Inside...Update Item method"); 
		System.out.println("Item id"+id); 
		System.out.println(updatedItem); 
		Item res = repo.findOne(id);
		res.setChecked(updatedItem.getChecked());
		res.setCreatedDate(new Date()); 
		res.setDescription(updatedItem.getDescription());
		return repo.save(res);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteItem(@PathVariable String id) {
		 System.out.println("Inside...Delete Item method"); 
		 System.out.println("Item id"+id); 
		repo.delete(id);
	}
}