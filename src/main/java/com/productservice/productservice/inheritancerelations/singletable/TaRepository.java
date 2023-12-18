package com.productservice.productservice.inheritancerelations.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("st_tarepository")
public interface TaRepository extends JpaRepository<Ta, Long> {

    @Override
    Ta save(Ta ta);
}
