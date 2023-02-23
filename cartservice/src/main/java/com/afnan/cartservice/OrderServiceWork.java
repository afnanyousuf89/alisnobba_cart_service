package com.afnan.cartservice;


import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceWork implements OrderService {
	private IorderRepo orderRepository;

	public OrderServiceWork(IorderRepo orderRepository){
		this.orderRepository = orderRepository;
	}

	public order saveorder(order order) {
		return orderRepository.save(order);
	}

	public order getorder(Long id) {
		return orderRepository.getReferenceById(id);
	}

	
	public order updateorder(order order) {
		Optional<order> savedorder = orderRepository.findById(order.getId()); 
		if(savedorder.isEmpty()){
			throw new InvalidConfigurationPropertyValueException("Id", order.getId(), "A order id "+order.getId()+" does not already exist in the database.");
		}
		return orderRepository.save(order);
	}


	public void deleteorder(Long id){
		orderRepository.deleteById(id);
	}

	public List<order> getAllorders(){
		return orderRepository.findAll();
	}

	public Optional<order> fetchSingleorder(order o){
		return orderRepository.findById(o.getId());
	}

	
}