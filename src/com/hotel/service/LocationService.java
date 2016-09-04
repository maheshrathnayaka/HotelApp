package com.hotel.service;

import java.util.List;

import com.hotel.model.Location;

public interface LocationService {
	void save(Location location);

	void update(Location location);

	public List<Location> findAllLocations();

	public List<Location> getActiveLocation();

	public Location findById(String id);

	public void statusUpdate(Location location);
}
