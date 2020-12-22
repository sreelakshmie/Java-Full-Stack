package com.company.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.vendor.entities.Vendor;
import java.util.List;
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	@Query("select type, count(type) from vendor group by type ")
	public List<Object[]> findTypeAndTypeCount();
	
}
