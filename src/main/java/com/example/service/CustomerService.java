package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.config.multitenant.database.DataSourceBasedMultiTenantConnectionProviderImpl;
import com.example.config.multitenant.database.DataSourceConfigRepository;
import com.example.config.multitenant.database.TenantDataSource;
import com.example.entity.Customer;
import com.example.entity.DataSourceConfig;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TenantDataSource tenantdataSource;
//    
    @Autowired
    private DataSourceConfigRepository configRepository;
    
    @Autowired
    private DataSourceBasedMultiTenantConnectionProviderImpl dimpl;
    
  
//    
//    @Autowired
//    private DataSourceConfig DataSourceConfig;

    //@Autowired
    //private TenantDataSource tenantDataSource;

    public void save(Customer customer){

    	customerRepository.save(customer);
    	DataSourceConfig dataSourceConfig = new DataSourceConfig();
    	dataSourceConfig.setDriverClassName(customer.getDriverClassName());
    	dataSourceConfig.setName(customer.getName());
    	dataSourceConfig.setPassword(customer.getPassword());
    	dataSourceConfig.setUrl(customer.getUrl());
    	dataSourceConfig.setUsername(customer.getUsername());
    	dataSourceConfig.setInitialize(customer.getInitialize());
    	configRepository.save(dataSourceConfig);
    	dimpl.init=false;
    	tenantdataSource.getAll();
    }

//    public List<Customer> getAll() throws SQLException {
//        return customerRepository.findAll();
//        /*
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(tenantDataSource.getDataSource(TenantContext.getCurrentTenant()));
//        String sql = "SELECT * FROM city";
//        List<City> cities = jdbcTemplate.query(sql,
//                new BeanPropertyRowMapper(City.class));
//        return cities;
//        */
//
//    }
//
//    public Customer get(Long id){
//        return customerRepository.findById(id);
//    }
//
//    public Customer getByName(String name){
//        return customerRepository.findByName(name);
//    }
//
//    public void delete(String name){
//    	customerRepository.deleteByName(name);
//    }
}
