package com.diginamic.magic.service;

import com.diginamic.magic.domain.Card;
import com.diginamic.magic.domain.Deck;
import com.diginamic.magic.repository.CardRepository;
import com.diginamic.magic.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    public void insertDeck(Deck deck) {
        deckRepository.save(deck);
    }

    public Deck findDeckWithName(String name) {
        return deckRepository.findByName(name);
    }

    public void insertDeckWithCard(String name, List<Card> cards) {
        Deck deck = new Deck();
        List<Card> cardsAdd = new ArrayList<>();
        for (Card card : cards) {
            Card existingCard = cardRepository.findByNameAndEdition(card.getName(), card.getEdition());
            if (existingCard != null) {
                cardsAdd.add(existingCard);
            } else {
                Card newCard = new Card();
                newCard.setName(card.getName());
                newCard.setEdition(card.getEdition());
                newCard.setMana(card.getMana());
                newCard.setCardType(card.getCardType());
                cardsAdd.add(newCard);
                cardRepository.save(newCard);
            }
        }
        deck.setName(name);
        deck.setCards(cardsAdd);
        deckRepository.save(deck);
    }
}