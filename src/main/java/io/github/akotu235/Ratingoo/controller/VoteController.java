package io.github.akotu235.Ratingoo.controller;


import io.github.akotu235.Ratingoo.logic.VoteService;
import io.github.akotu235.Ratingoo.model.projection.VoteResultModel;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
class VoteController {
    private final VoteService voteService;

    VoteController(final VoteService voteService) {
        this.voteService = voteService;
    }

    @Transactional
    @PostMapping("/vote/{itemId}/{secreteCode}")
    ResponseEntity<VoteResultModel> addVote(@PathVariable int itemId, @PathVariable String secreteCode) {
        VoteResultModel result = voteService.addVote(itemId, secreteCode);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
