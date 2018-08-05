package com.github.hasanmirzae.briefcasedesktop.repositories;

import com.github.hasanmirzae.briefcasedesktop.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {

    Optional<Post> findByUuid(@Param("uuid") String uuid);

    Optional<Post> findByPosterUuidAndUuid(@Param("posterUuid") String posterUuid, @Param("uuid") String uuid);
}
