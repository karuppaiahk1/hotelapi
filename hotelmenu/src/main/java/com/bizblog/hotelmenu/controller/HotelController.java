package com.bizblog.hotelmenu.controller;


import com.bizblog.hotelmenu.model.Hotel;
import com.bizblog.hotelmenu.repository.HotelRepository;
import com.bizblog.hotelmenu.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping("/add")
    public String add(@RequestBody Hotel hotel){
        hotelService.saveHotel(hotel);
        return "New iteam is added";
    }
    @GetMapping("/getAll")
    public List<Hotel> getallhotel(){
        return hotelService.getAllHotel();
    }
    @GetMapping("/gethotel/{id}")
    public Hotel gethotel(@PathVariable("id") Integer id){

        return hotelService.getByID(id);}
    @PutMapping("/hotelname/{id}")
    public String update(@PathVariable ("id")Integer id, @RequestBody Hotel student) {
        Hotel student1 = hotelService.getByID(id);
        student1.setName(student.getName());
        student1.setLocation(student.getLocation());
        hotelService.saveHotel(student1);
        return "Hotel is updated";
    }
    @DeleteMapping("/hoteldelete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        hotelService.deleteById(id);
        return "hotel is deleted"+id;

}}





