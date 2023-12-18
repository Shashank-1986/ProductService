package com.productservice.productservice.inheritancerelations.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("st_mentorrepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    Mentor save(Mentor mentor);
}
