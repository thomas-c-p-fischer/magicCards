package com.diginamic.magic.repository;

import com.diginamic.magic.domain.Deck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
    Deck findByName(String name);
}