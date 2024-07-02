package it.apuliadigital.service.impl;

import it.apuliadigital.entity.LogEntity;
import it.apuliadigital.entity.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogEntityImpl {

    @Autowired
    private LogRepository logRepository;

    LogEntity logEntity = new LogEntity("A1", "path", "messaggio");
}
