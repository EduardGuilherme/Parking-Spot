package com.api.parking.control.Services;

import com.api.parking.control.Model.ParkingSpotModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parking.control.Repository.ParkinSpotRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

	@Autowired
	final ParkinSpotRepository parkinSpotRepository;

	public ParkingSpotService(ParkinSpotRepository parkinSpotRepository) {
		super();
		this.parkinSpotRepository = parkinSpotRepository;
	}

	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkinSpotRepository.save(parkingSpotModel);
	}

	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return parkinSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}

	public  boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return parkinSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkinSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	public  Page<ParkingSpotModel> findAll(Pageable pageable) {
		return parkinSpotRepository.findAll(pageable);
	}

	public  Optional<ParkingSpotModel> findById(UUID id) {
		return parkinSpotRepository.findById(id);
	}

	@Transactional
	public  void delete(ParkingSpotModel parkingSpotModel) {
		parkinSpotRepository.delete(parkingSpotModel);
	}
}
