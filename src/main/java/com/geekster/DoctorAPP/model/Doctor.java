package com.geekster.DoctorAPP.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geekster.DoctorAPP.model.enums.Qualification;
import com.geekster.DoctorAPP.model.enums.Specialization;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Doctor.class,property="doctorId")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String doctorName;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @Pattern(regexp = "^[0-9]{10}$")
    private String doctorContactNumber;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getDoctorContactNumber() {
        return doctorContactNumber;
    }

    public void setDoctorContactNumber(String doctorContactNumber) {
        this.doctorContactNumber = doctorContactNumber;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Enumerated(EnumType.STRING)
    private Qualification qualification;
    @Min(value = 200)
    @Max(value = 2000)
    private Double doctorConsultationFee;

    @OneToMany(mappedBy = "doctor")
    List<Appointment> appointments;

    public String getDocName() {
        return this.doctorName;
    }
}
