package com.diginamic.magic.webRest;

import com.diginamic.magic.domain.Card;
import com.diginamic.magic.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardResource {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        cardService.insertCard(card);
        return ResponseEntity.status(HttpStatus.OK).body(card);
    }

    @GetMapping("/{name}/{edition}")
    public ResponseEntity<Card> getCardByNameAndEdition(@PathVariable("name") String name, @PathVariable("edition") String edition) {
        Card card = cardService.findCardByNameAndEdition(name, edition);
        return ResponseEntity.status(HttpStatus.OK).body(card);
    }
}