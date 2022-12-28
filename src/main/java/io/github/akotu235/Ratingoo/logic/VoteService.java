package io.github.akotu235.Ratingoo.logic;

import io.github.akotu235.Ratingoo.model.*;
import io.github.akotu235.Ratingoo.model.projection.VoteResultModel;
import io.github.akotu235.Ratingoo.model.projection.VoteStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final ItemRepository itemRepository;

    VoteService(final VoteRepository voteRepository, final ItemRepository itemRepository) {
        this.voteRepository = voteRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public VoteResultModel addVote(int itemId, String secretCode) {
        if(checkSecretCode(secretCode)){
            Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item with given id not found."));
            Category category = item.getCategory();
            item.addVote();
            voteRepository.save(new Vote(item, secretCode));
            return new VoteResultModel(VoteStatus.SUCCESS);
        }
        else{
            return new VoteResultModel(VoteStatus.FAIL);
        }
    }

    boolean checkSecretCode (String secretCode) {
        return true;
    }
}
