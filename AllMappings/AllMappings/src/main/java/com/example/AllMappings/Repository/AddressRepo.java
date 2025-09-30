package com.example.AllMappings.Repository;

import com.example.AllMappings.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
    Address findByCity(String city);
}
