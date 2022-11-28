package com.lviv.iot.repository;

import com.lviv.iot.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Procedure("create_tables_by_country_names")
    void createTablesByCountryNames();
    
    @Procedure("insert_into_cash_withdrawal")
    Integer insertIntoCashWithdrawal(String serviceMemberName, String serviceMemberLastName,
            String vendingMachineModelName, Integer amount);

}