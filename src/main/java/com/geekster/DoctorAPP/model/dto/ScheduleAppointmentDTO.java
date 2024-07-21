package com.geekster.DoctorAPP.model.dto;

import com.geekster.DoctorAPP.model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScheduleAppointmentDTO {
    AuthenticationInputDto authInfo;
    Appointment appointment;

}
