package com.bizblog.hotelmenu.service;

import com.bizblog.hotelmenu.model.Hotel;
import com.bizblog.hotelmenu.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImplementation implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel get(Integer id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        hotelRepository.deleteById(id);
    }

    @Override
        public Hotel getByID(Integer id) {
            return hotelRepository.findById(id).get();
        }

}
