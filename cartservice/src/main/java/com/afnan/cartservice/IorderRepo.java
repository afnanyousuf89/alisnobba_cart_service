package com.afnan.cartservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IorderRepo extends JpaRepository<order, Long> {
    
}
