package com.company.vendor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.vendor.entities.Vendor;
import com.company.vendor.repository.VendorRepository;

@Service
public class VendorServicesImplimentation implements VendorService {

	@Autowired
	private VendorRepository vendorRepo;
	
	@Override
	public Vendor saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorRepo.save(vendor);
	
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		
		return vendorRepo.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		// TODO Auto-generated method stub
        vendorRepo.delete(vendor);
	}

	@Override
	public Vendor getVendorId(int id) {
		// TODO Auto-generated method stub
		return vendorRepo.findById(id).get();
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		
		return vendorRepo.findAll();
	}
	
	

}
