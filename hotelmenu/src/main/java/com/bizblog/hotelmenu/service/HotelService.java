package com.bizblog.hotelmenu.service;

import com.bizblog.hotelmenu.model.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel saveHotel(Hotel hotel);

    public List<Hotel> getAllHotel();

    public Hotel save(Hotel student);


    public Hotel get(Integer id);

    //public void delete(Integer id);

    public Hotel getByID(Integer id);

    void deleteById(Integer id);
}