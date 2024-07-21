package com.geekster.DoctorAPP.controller;


import com.geekster.DoctorAPP.model.Doctor;
import com.geekster.DoctorAPP.model.Patient;
import com.geekster.DoctorAPP.model.enums.BloopGroup;
import com.geekster.DoctorAPP.service.DoctorService;
import com.geekster.DoctorAPP.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @GetMapping("patients")
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @PostMapping("doctor")
    public String addDoctor(@RequestBody Doctor newDoctor)
    {
        return doctorService.addDoctor(newDoctor);
    }

    @GetMapping("patients/bloodGroup/{bloodGroup}")
    public List<Patient> getAllPatientsByBloodGroup(@PathVariable BloopGroup bloodGroup)
    {
        return patientService.getAllPatientsByBloodGroup(bloodGroup);
    }
}
