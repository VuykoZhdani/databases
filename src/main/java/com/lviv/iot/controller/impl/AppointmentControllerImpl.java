package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.AppointmentController;
import com.lviv.iot.domain.Appointment;
import com.lviv.iot.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AppointmentControllerImpl implements AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @Override
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @Override
    public Optional<Appointment> findById(Integer appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    @Override
    public int create(Appointment appointment) {
        return appointmentService.create(appointment);
    }

    @Override
    public int update(Integer appointmentId, Appointment appointment) {
        return appointmentService.update(appointmentId, appointment);
    }

    @Override
    public int delete(Integer appointmentId) {
        return appointmentService.delete(appointmentId);
    }

}
