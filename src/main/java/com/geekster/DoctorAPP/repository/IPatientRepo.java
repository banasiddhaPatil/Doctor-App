package com.geekster.DoctorAPP.repository;

import com.geekster.DoctorAPP.model.Admin;
import com.geekster.DoctorAPP.model.Patient;
import com.geekster.DoctorAPP.model.enums.BloopGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientRepo extends JpaRepository<Patient,Long> {

    Patient findFirstByPatientEmail(String newEmail);

    List<Patient> findByPatientBloodGroup(BloopGroup bloodGroup);
}
