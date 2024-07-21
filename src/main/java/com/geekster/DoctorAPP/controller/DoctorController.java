package com.geekster.DoctorAPP.controller;


import com.geekster.DoctorAPP.model.Doctor;
import com.geekster.DoctorAPP.model.dto.AuthenticationInputDto;
import com.geekster.DoctorAPP.service.DoctorService;
import com.geekster.DoctorAPP.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("doctors")
    public List<Doctor> getAllDoctors(@Valid @RequestBody AuthenticationInputDto authInfo)
    {
        return doctorService.getAllDoctors(authInfo);
    }


    @GetMapping("doctor/{id}")
    public Doctor getDoctorById(@PathVariable Long id)
    {
        return doctorService.getDoctorById(id);
    }





}
