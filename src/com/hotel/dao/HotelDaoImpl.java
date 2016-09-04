package com.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.hotel.model.Hotel;

@Repository("hotelDao")
public class HotelDaoImpl extends AbstractDao<String, Hotel> implements HotelDao {
	@Override
	public Hotel findById(String id) {
		return getByKey(id);
	}

	@Override
	public void save(Hotel hotel) {
		hotel.setHotel_id(generateID("H", "hotel_id"));
		persist(hotel);
	}

	@Override
	public List<Hotel> findAllHotels() {
		Criteria criteria = createEntityCriteria();
		return (List<Hotel>) criteria.list();
	}
}
