package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.model.Location;
import com.hotel.service.LocationService;

@Controller
@RequestMapping("/")
public class LocationController {
	@Autowired
	LocationService locationService;

	// --------------------load location form---------
	@RequestMapping(value = { "/locationForm" }, method = RequestMethod.GET)
	public String newLocation(ModelMap model) {
		Location location = new Location();
		model.addAttribute("location", location);
		model.addAttribute("edit", false);
		return "locationForm";
	}

	// -------------------Create a Location-----------------------------
	@RequestMapping(value = { "/locationForm" }, method = RequestMethod.POST)
	public String save(Location location, ModelMap model) {
		location.setStatus(1);
		locationService.save(location);
		return "redirect:locationList";
	}

	// -------------------Retrieve All Locations------------------------
	@RequestMapping(value = { "/", "/locationList" }, method = RequestMethod.GET)
	public String listLocation(ModelMap model) {
		List<Location> locations = locationService.findAllLocations();
		model.addAttribute("locations", locations);
		return "locationList";
	}

	// -----------Load Edit Form-------------------
	@RequestMapping(value = { "/edit-{id}-location" }, method = RequestMethod.GET)
	public String editLocation(@PathVariable String id, ModelMap model) {
		Location location = locationService.findById(id);
		model.addAttribute("location", location);
		model.addAttribute("edit", true);
		return "locationForm";
	}

	// ----- Update location data---------
	@RequestMapping(value = { "/edit-{id}-location" }, method = RequestMethod.POST)
	public String updateLocation(Location location, ModelMap model, @PathVariable String id) {
		Location currentLocation = locationService.findById(id);
		currentLocation.setName(location.getName());
		locationService.update(currentLocation);
		return "redirect:/locationList";
	}

	// -------------------Status Update Locations------------------------
	@RequestMapping(value = "/location/{id}/{status}", method = RequestMethod.GET)
	public String statusUpdate(@PathVariable("id") String id, @PathVariable("status") int status) {
		Location currentLocation = locationService.findById(id);
		currentLocation.setLocation_id(id);
		currentLocation.setStatus(status);
		locationService.statusUpdate(currentLocation);
		return "redirect:/locationList";
	}
}
