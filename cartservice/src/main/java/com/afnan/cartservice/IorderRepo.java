package com.afnan.cartservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IorderRepo extends JpaRepository<order, Long> {
    // // @Query("SELECT 1")
    // @Query("SELECT case when max(oid) is null then 1 when max(oid) is not null then max(oid) end FROM tblorder")
    // long getMaxOId();
}
