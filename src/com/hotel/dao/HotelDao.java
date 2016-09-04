package com.hotel.dao;

import java.util.List;

import com.hotel.model.Hotel;

public interface HotelDao {
	Hotel findById(String id);

	void save(Hotel hotel);

	List<Hotel> findAllHotels();
}
