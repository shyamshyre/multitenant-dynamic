package com.example.config.multitenant.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.DataSourceConfig;


public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {
    DataSourceConfig findByName(String name);
}
