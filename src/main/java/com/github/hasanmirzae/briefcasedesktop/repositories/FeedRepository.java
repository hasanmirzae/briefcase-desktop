package com.github.hasanmirzae.briefcasedesktop.repositories;

import com.github.hasanmirzae.briefcasedesktop.entities.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends CrudRepository  <Feed,Long> {


    @Query("update Feed f set f.exclude=:exclude")
    void updateExclude(@Param("exclude") String exclude);


    @Query("update Feed f set f.receivers=:receivers")
    void updateReceivers(String receivers);

    @Query("select f from Feed f where (f.receivers like '%*%' or f.receivers like :uuid) and (f.exclude is null or f.exclude not like :uuid)")
    Iterable<Feed> findFeedsByFriendUuid(@Param("uuid") String uuid);
}
