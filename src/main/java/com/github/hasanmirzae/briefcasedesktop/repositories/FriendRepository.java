package com.github.hasanmirzae.briefcasedesktop.repositories;

import com.github.hasanmirzae.briefcasedesktop.entities.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface FriendRepository extends CrudRepository<Friend,Long> {

    Optional<Friend> findByUuid(@Param("uuid") String uuid);

    @Query("select count(p) from Friend p")
    Long findCount();

    @Query("update  Friend p set p.avatar=:uri where uuid=:uuid")
    void updateAvatarByUuid(@Param("uuid") String uuid, @Param("uri") String uri);
}
