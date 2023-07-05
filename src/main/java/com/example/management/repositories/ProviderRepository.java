package com.example.management.repositories;

import com.example.management.entities.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProviderRepository extends CrudRepository<Provider,Long> {


}
