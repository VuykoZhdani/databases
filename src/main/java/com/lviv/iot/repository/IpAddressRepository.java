package com.lviv.iot.repository;

import com.lviv.iot.domain.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface IpAddressRepository extends JpaRepository<IpAddress, Integer> {
    @Procedure("insert_ten_rows_into_ip_address")
    void insertTenRowsInIpAddress();
    @Procedure("insert_into_ip_address")
    String insertIntoIpAddress(Integer id, String ip_address);
}