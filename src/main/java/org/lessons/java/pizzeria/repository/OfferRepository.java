package org.lessons.java.pizzeria.repository;

import org.lessons.java.pizzeria.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
