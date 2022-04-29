package com.barclays.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barclays.entity.Store;
import com.barclays.entity.StoreId;

@Repository
public interface StoreRepository extends JpaRepository<Store, StoreId> {
	@Query(value = "select * from store where expired=:expiry", nativeQuery = true)
	List<Store> findByExpiry(String expiry);
}
