package com.lviv.iot.controller.impl;

import com.lviv.iot.controller.DiagnosisController;
import com.lviv.iot.domain.Diagnosis;
import com.lviv.iot.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisControllerImpl implements DiagnosisController {
    @Autowired
    DiagnosisService diagnosisService;

    @Override
    public List<Diagnosis> findAll() {
        return diagnosisService.findAll();
    }

    @Override
    public Optional<Diagnosis> findById(String diagnosisName) {
        return diagnosisService.findById(diagnosisName);
    }

    @Override
    public int create(Diagnosis diagnosis) {
        return diagnosisService.create(diagnosis);
    }

    @Override
    public int update(String diagnosisName, Diagnosis diagnosis) {
        return diagnosisService.update(diagnosisName, diagnosis);
    }

    @Override
    public int delete(String diagnosisName) {
        return diagnosisService.delete(diagnosisName);
    }
}
