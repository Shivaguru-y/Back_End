package com.cricket.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.app.Model.Extras;

@Repository
public interface ExtrasRepository extends JpaRepository<Extras, Long> {
}
