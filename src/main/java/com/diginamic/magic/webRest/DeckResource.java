package com.diginamic.magic.webRest;

import com.diginamic.magic.domain.Deck;
import com.diginamic.magic.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Decks")
public class DeckResource {

    @Autowired
    private DeckService deckService;

    @PostMapping
    public ResponseEntity<Deck> createDeck(@RequestBody Deck deck) {
        deckService.insertDeck(deck);
        return ResponseEntity.status(HttpStatus.OK).body(deck);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Deck> getDeckByName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(deckService.findDeckWithName(name));
    }
}