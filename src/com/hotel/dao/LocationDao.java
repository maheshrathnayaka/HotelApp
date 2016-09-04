package com.hotel.dao;

import java.util.List;

import com.hotel.model.Location;

public interface LocationDao {
	void save(Location location);

	public List<Location> findAllLocations();

	public List<Location> getActiveLocation();

	public Location findById(String id);
}
