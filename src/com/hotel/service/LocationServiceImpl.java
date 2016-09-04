package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.LocationDao;
import com.hotel.model.Location;

@Service("locationService")
@Transactional
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationDao locationDao;

	@Override
	public void save(Location location) {
		locationDao.save(location);
	}

	@Override
	public List<Location> findAllLocations() {
		return locationDao.findAllLocations();
	}

	@Override
	public void update(Location location) {
		Location entity = locationDao.findById(location.getLocation_id());
		if (entity != null) {
			entity.setName(location.getName());
		}
	}

	@Override
	public Location findById(String id) {
		return locationDao.findById(id);
	}

	public void statusUpdate(Location location) {
		Location entity = locationDao.findById(location.getLocation_id());
		if (entity != null) {
			entity.setStatus(location.getStatus());
		}
	}

	@Override
	public List<Location> getActiveLocation() {
		return locationDao.getActiveLocation();
	}
}
