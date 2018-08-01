package com.github.hasanmirzae.briefcasedesktop.repositories;

import com.github.hasanmirzae.briefcasedesktop.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {



    Post findByPosterUuidAndRemoteId(@Param("posterUuid") String posterUuid, @Param("remoteId") Long remoteId);
}
