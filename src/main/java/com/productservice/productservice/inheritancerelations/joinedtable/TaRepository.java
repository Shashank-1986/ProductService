package com.productservice.productservice.inheritancerelations.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("j_tarepository")
public interface TaRepository extends JpaRepository<Ta, Long> {
    @Override
    Ta save(Ta ta);
}
