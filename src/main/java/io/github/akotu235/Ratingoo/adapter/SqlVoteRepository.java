package io.github.akotu235.Ratingoo.adapter;

import io.github.akotu235.Ratingoo.model.Vote;
import io.github.akotu235.Ratingoo.model.VoteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlVoteRepository extends VoteRepository, JpaRepository<Vote, Integer> {
}
