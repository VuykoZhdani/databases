package com.lviv.iot.service.impl;

import com.lviv.iot.dao.ClientDao;
import com.lviv.iot.domain.Client;
import com.lviv.iot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Optional<Client> findById(Integer clientId) {
        return clientDao.findById(clientId);
    }

    @Override
    public int create(Client client) {
        return clientDao.create(client);
    }

    @Override
    public int update(Integer clientId, Client client) {
        return clientDao.update(clientId, client);
    }

    @Override
    public int delete(Integer clientId) {
        return clientDao.delete(clientId);
    }
}
