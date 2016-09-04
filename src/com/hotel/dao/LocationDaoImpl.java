package com.hotel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hotel.model.Location;

@Repository("locationDao")
public class LocationDaoImpl extends AbstractDao<String, Location> implements LocationDao {
	@Override
	public void save(Location location) {
		location.setLocation_id(generateID("L", "location_id"));
		persist(location);
	}

	@Override
	public List<Location> findAllLocations() {
		Criteria criteria = createEntityCriteria();
		return (List<Location>) criteria.list();
	}

	@Override
	public Location findById(String id) {
		return getByKey(id);
	}

	@Override
	public List<Location> getActiveLocation() {
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("status", 1));
		return (List<Location>) criteria.list();
	}
}