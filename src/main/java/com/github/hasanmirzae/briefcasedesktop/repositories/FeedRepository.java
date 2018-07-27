package com.github.hasanmirzae.briefcasedesktop.repositories;

import com.github.hasanmirzae.briefcasedesktop.entities.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends CrudRepository<Feed,Long> {



}
