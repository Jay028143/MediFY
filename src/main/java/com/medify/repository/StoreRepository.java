package com.medify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medify.entity.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	List<Store> findByAdminId(Long adminId);
	
	@Query(value="select st.store_id from stores st where admin_id=(select admin_id from stores s where s.store_id= :storeid )",nativeQuery = true)
	List<Long> getAllStoreIds(@Param("storeid") Long storeId);
	
	@Query(value="select * from stores st where admin_id=(select admin_id from stores s where s.store_id= :storeid )",nativeQuery = true)
	List<Store> getAllStore(@Param("storeid") Long storeId);
}
