package com.diginamic.magic.repository;

import com.diginamic.magic.domain.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    Card findByNameAndEdition(String name, String edition);
}