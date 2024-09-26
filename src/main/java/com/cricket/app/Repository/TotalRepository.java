package com.cricket.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.app.Model.Total;

@Repository
public interface TotalRepository extends JpaRepository<Total, Long> {
}
