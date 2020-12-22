package com.company.vendor.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.vendor.entities.Vendor;
import com.company.vendor.repository.VendorRepository;
import com.company.vendor.services.VendorService;
import com.company.vendor.utilities.EmailUtilityInterface;
import com.company.vendor.utilities.ReportUtility;

import org.springframework.ui.ModelMap;
@Controller
public class VendorController {

	@Autowired
	private VendorRepository vendorRepo;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private EmailUtilityInterface emailUtility;
	
	@Autowired
	ServletContext sc;
	
	@Autowired
	private ReportUtility reportUtil;
	
	@RequestMapping("/showVendor")
	public String createVendor() {
		return "createVendor";
	}
	
	@RequestMapping("/createVendor")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMap) {
		Vendor vendors=vendorService.saveVendor(vendor);
		String message="Vendor created successfully with id "+vendors.getId();
		modelMap.addAttribute("message",message);
		emailUtility.sendEmail("sreelakshmienair615@gmail.com", "New Vendor Added", vendors.toString());
		return "createVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayVendors(ModelMap modelMap) {
		List<Vendor> vendors = vendorService.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id") int id, ModelMap modelMap ) {
		Vendor vendor = new Vendor();
		vendor.setId(id);
		vendorService.deleteVendor(vendor);
		List<Vendor> vendors = vendorService.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap ) {
		Vendor vendor = vendorService.getVendorId(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
    @RequestMapping("/updateVendor")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMap ) {
		vendorService.saveVendor(vendor);
		
		List<Vendor> vendors = vendorService.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
    
    @RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = vendorRepo.findTypeAndTypeCount();
		reportUtil.generatePieChart(path,data);
		
		return "report";
	}
}
