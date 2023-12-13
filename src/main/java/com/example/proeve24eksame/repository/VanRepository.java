package com.example.proeve24eksame.repository;

import com.example.proeve24eksame.model.Van;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VanRepository extends JpaRepository<Van, Integer> {

}
