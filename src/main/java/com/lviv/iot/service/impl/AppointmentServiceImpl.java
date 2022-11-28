package com.lviv.iot.service.impl;

import com.lviv.iot.dao.AppointmentDao;
import com.lviv.iot.domain.Appointment;
import com.lviv.iot.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    @Override
    public Optional<Appointment> findById(Integer appointmentId) {
        return appointmentDao.findById(appointmentId);
    }

    @Override
    public int create(Appointment appointment) {
        return appointmentDao.create(appointment);
    }

    @Override
    public int update(Integer appointmentId, Appointment appointment) {
        return appointmentDao.update(appointmentId, appointment);
    }

    @Override
    public int delete(Integer appointmentId) {
        return appointmentDao.delete(appointmentId);
    }
}
