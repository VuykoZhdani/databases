package com.lviv.iot.domain.many_to_many;

import com.lviv.iot.domain.Client;
import lombok.*;
import com.lviv.iot.domain.SolarSystem;

import javax.persistence.*;

@Entity
@Table(name = "solar_system_client")
@Data
@RequiredArgsConstructor
public class SolarSystemClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "solar_system_id")
    private SolarSystem solarSystem;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
