package com.github.hasanmirzae.briefcasedesktop.repositories;

import com.github.hasanmirzae.briefcasedesktop.entities.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends CrudRepository<Friend,Long> {

    Friend findByUuid(@Param("uuid") String uuid);

    @Query("select count(p) from Friend p")
    Long findCount();

}
