package com.bog.internshipmanagementbackend.repository;

import com.bog.internshipmanagementbackend.domain.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promo, Integer> {
}
