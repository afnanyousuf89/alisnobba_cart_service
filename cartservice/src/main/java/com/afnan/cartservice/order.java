package com.afnan.cartservice;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tblorder")
public class order {  
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long pid;
    private long pqty;
    private long ptotoalprice;
    private long oid;
}


