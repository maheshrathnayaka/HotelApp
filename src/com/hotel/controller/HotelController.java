package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.model.Hotel;
import com.hotel.model.Location;
import com.hotel.service.HotelService;
import com.hotel.service.LocationService;

@Controller
@RequestMapping("/")
public class HotelController {
	@Autowired
	HotelService hotelService;
	@Autowired
	LocationService locationService;

	// --------------------load location form---------
	@RequestMapping(value = { "/hotelForm" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Hotel hotel = new Hotel();
		List<Location> list = locationService.getActiveLocation();
		model.addAttribute("locations", list);
		model.addAttribute("hotel", hotel);
		model.addAttribute("edit", false);
		return "hotelForm";
	}

	@RequestMapping(value = { "/hotelForm" }, method = RequestMethod.POST)
	public String save(Hotel hotel, ModelMap model) {
		hotel.setStatus(1);
		hotelService.save(hotel);

		return "redirect:hotelList";
	}

	// -------------------Retrieve All Hotels------------------------
	@RequestMapping(value = { "/", "/hotelList" }, method = RequestMethod.GET)
	public String listHotel(ModelMap model) {
		List<Hotel> hotels = hotelService.findAllHotels();
		model.addAttribute("hotels", hotels);
		return "hotelList";
	}

	// -----------Load Edit Form-------------------
	@RequestMapping(value = { "/edit-{id}-hotel" }, method = RequestMethod.GET)
	public String editHotel(@PathVariable String id, ModelMap model) {
		Hotel hotel = hotelService.findById(id);
		List<Location> list = locationService.getActiveLocation();
		model.addAttribute("locations", list);
		model.addAttribute("hotel", hotel);
		model.addAttribute("edit", true);
		return "hotelForm";
	}

	// ----- Update location data---------
	@RequestMapping(value = { "/edit-{id}-hotel" }, method = RequestMethod.POST)
	public String updateHotel(Hotel hotel, ModelMap model, @PathVariable String id) {
		Hotel currentHotel = hotelService.findById(id);
		currentHotel.setName(hotel.getName());
		currentHotel.setAddress(hotel.getAddress());
		currentHotel.setLocation(hotel.getLocation());
		currentHotel.setPhone_number(hotel.getPhone_number());
		hotelService.update(currentHotel);
		return "redirect:/hotelList";
	}

	// -------------------Status Update Hotels------------------------
	@RequestMapping(value = "/hotel/{id}/{status}", method = RequestMethod.GET)
	public String statusUpdate(@PathVariable("id") String id, @PathVariable("status") int status) {
		Hotel currentHotel = hotelService.findById(id);
		currentHotel.setHotel_id(id);
		currentHotel.setStatus(status);
		hotelService.statusUpdate(currentHotel);
		return "redirect:/hotelList";
	}
}
