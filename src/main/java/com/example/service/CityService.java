package com.example.service;

import com.example.config.multitenant.database.TenantDataSource;
import com.example.entity.City;
import com.example.entity.Customer;
import com.example.repository.CityRepository;
import com.example.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private TenantDataSource tenantdataSource;
  

    //@Autowired
    //private TenantDataSource tenantDataSource;

    public void save(City city){
        cityRepository.save(city);
    }
    
    public void save(Customer customer){

    	customerRepository.save(customer);
    	
//    	configRepository.save(dataSourceConfig);
    	tenantdataSource.getAll();
    }

    public List<City> getAll() throws SQLException {
        return cityRepository.findAll();
        /*
        JdbcTemplate jdbcTemplate = new JdbcTemplate(tenantDataSource.getDataSource(TenantContext.getCurrentTenant()));
        String sql = "SELECT * FROM city";
        List<City> cities = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(City.class));
        return cities;
        */

    }

    public City get(Long id){
        return cityRepository.findById(id);
    }

    public City getByName(String name){
        return cityRepository.findByName(name);
    }

    public void delete(String name){
        cityRepository.deleteByName(name);
    }
}
