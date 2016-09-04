package com.hotel.service;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelService {
	void save(Hotel hotel);

	void update(Hotel hotel);

	public List<Hotel> findAllHotels();

	public Hotel findById(String id);

	public void statusUpdate(Hotel hotel);
}
