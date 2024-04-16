package com.diginamic.magic.controller;

import com.diginamic.magic.domain.Card;
import com.diginamic.magic.domain.Deck;
import com.diginamic.magic.domain.enums.CardType;
import com.diginamic.magic.domain.enums.Mana;
import com.diginamic.magic.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/decks")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @GetMapping("/add")
    public ModelAndView showAddDeckForm() {
        Map<String, Object> model = new HashMap<>();
        model.put("deck", new Deck());
        return new ModelAndView("addCardAndDeck/deck", model);
    }

    @PostMapping
    public String addDeck(@RequestParam("name") String name,
                          @RequestParam("cardNames") List<String> cardNames,
                          @RequestParam("cardEditions") List<String> cardEditions,
                          @RequestParam("cardTypes") List<CardType> cardTypes,
                          @RequestParam("cardManas") List<Mana> cardManas) {

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < cardNames.size(); i++) {
            Card addedCard = new Card();
            addedCard.setName(cardNames.get(i));
            addedCard.setEdition(cardEditions.get(i));
            addedCard.setCardType(cardTypes.get(i));
            addedCard.setMana(cardManas.get(i));
            cards.add(addedCard);
        }
        deckService.insertDeckWithCard(name, cards);
        return "redirect:/decks/add";
    }
}