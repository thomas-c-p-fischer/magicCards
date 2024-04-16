package com.diginamic.magic.service;

import com.diginamic.magic.domain.Card;
import com.diginamic.magic.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public void insertCard(Card card) {
        cardRepository.save(card);
    }

    public Card findCardByNameAndEdition(String name, String edition) {
        Card card = cardRepository.findByNameAndEdition(name, edition);
        return card;
    }
}