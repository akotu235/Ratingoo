package io.github.akotu235.Ratingoo.controller;

import io.github.akotu235.Ratingoo.logic.VoteService;
import io.github.akotu235.Ratingoo.model.projection.VoteReadModel;
import io.github.akotu235.Ratingoo.model.projection.VoteWriteModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
class VoteController {
    private final VoteService voteService;

    VoteController(final VoteService voteService) {
        this.voteService = voteService;
    }

    @Transactional
    @PostMapping("/vote")
    ResponseEntity<VoteReadModel> addVote(@RequestBody @Valid VoteWriteModel vote) {
        VoteReadModel result = voteService.addVote(vote.getItemId(), vote.getSecretCode());
        return ResponseEntity.ok(result);
    }
}
