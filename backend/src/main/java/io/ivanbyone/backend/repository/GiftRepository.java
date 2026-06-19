package io.ivanbyone.backend.repository;

import io.ivanbyone.backend.model.Gift;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends MongoRepository<Gift, String> {

    // Find all gifts by descending supply
    List<Gift> findAllByOrderBySupplyDesc();

    // Find all gifts by ascending supply
    List<Gift> findAllByOrderBySupplyAsc();
}
