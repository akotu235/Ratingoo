package io.github.akotu235.Ratingoo.controller;


import io.github.akotu235.Ratingoo.logic.VoteService;
import io.github.akotu235.Ratingoo.model.projection.ItemWriteModel;
import io.github.akotu235.Ratingoo.model.projection.VoteResultModel;
import io.github.akotu235.Ratingoo.model.projection.VoteWriteModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
class VoteController {
    private final VoteService voteService;

    VoteController(final VoteService voteService) {
        this.voteService = voteService;
    }

    @Transactional
    @PostMapping("/vote")
    ResponseEntity<VoteResultModel> addVote(@RequestBody @Valid VoteWriteModel vote) {
        VoteResultModel result = voteService.addVote(vote.getItemId(), vote.getSecretCode());
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
