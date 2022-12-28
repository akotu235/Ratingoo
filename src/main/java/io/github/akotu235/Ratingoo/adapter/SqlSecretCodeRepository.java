package io.github.akotu235.Ratingoo.adapter;


import io.github.akotu235.Ratingoo.model.SecretCode;
import io.github.akotu235.Ratingoo.model.SecretCodeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlSecretCodeRepository extends SecretCodeRepository, JpaRepository<SecretCode, String> {

}
