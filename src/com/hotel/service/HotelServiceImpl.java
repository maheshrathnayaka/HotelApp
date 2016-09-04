package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.HotelDao;
import com.hotel.model.Hotel;

@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelDao hotelDao;

	@Override
	public void save(Hotel hotel) {
		hotelDao.save(hotel);
	}

	@Override
	public void update(Hotel hotel) {
		Hotel entity = hotelDao.findById(hotel.getHotel_id());
		if (entity != null) {
			entity.setName(hotel.getName());
			entity.setAddress(hotel.getAddress());
			entity.setLocation(hotel.getLocation());
			entity.setPhone_number(hotel.getPhone_number());
		}
	}

	@Override
	public List<Hotel> findAllHotels() {
		return hotelDao.findAllHotels();
	}

	@Override
	public Hotel findById(String id) {
		return hotelDao.findById(id);
	}

	@Override
	public void statusUpdate(Hotel hotel) {
		Hotel entity = hotelDao.findById(hotel.getHotel_id());
		if (entity != null) {
			entity.setStatus(hotel.getStatus());
		}
	}
}
