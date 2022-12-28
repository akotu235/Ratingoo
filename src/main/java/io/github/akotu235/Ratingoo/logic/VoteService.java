package io.github.akotu235.Ratingoo.logic;

import io.github.akotu235.Ratingoo.model.*;
import io.github.akotu235.Ratingoo.model.projection.VoteReadModel;
import io.github.akotu235.Ratingoo.model.projection.VoteStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final ItemRepository itemRepository;
    private final SecretCodeRepository secretCodeRepository;

    VoteService(final VoteRepository voteRepository, final ItemRepository itemRepository, final SecretCodeRepository secretCodeRepository) {
        this.voteRepository = voteRepository;
        this.itemRepository = itemRepository;
        this.secretCodeRepository = secretCodeRepository;
    }

    @Transactional
    public VoteReadModel addVote(int itemId, String secretCode) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item with given id not found."));
        item.addVote();
        voteRepository.save(new Vote(item, secretCode));
        secretCodeRepository.findBySecretCode(secretCode).ifPresent(code -> code.setActive(false));
        return new VoteReadModel(VoteStatus.SUCCESS);
    }
}

