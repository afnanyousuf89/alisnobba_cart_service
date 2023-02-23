package com.afnan.cartservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("order")
public class orderController {

	@Autowired
	private IorderRepo repo;

	@PostMapping("")
	public String saveOrder(@RequestBody List<order> orders) {
		// for (order order : orders) {
		// 	order.setOid(repo.getMaxOId());
		// }
		repo.saveAll(orders);
		return "Order Saved";
	}

}
