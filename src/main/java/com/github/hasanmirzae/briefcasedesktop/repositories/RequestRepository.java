package com.github.hasanmirzae.briefcasedesktop.repositories;

import com.github.hasanmirzae.briefcasedesktop.entities.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository  <Request,Long> {


    void deleteByUuidAndIsMine(@Param("uuid") String uuid, @Param("isMine") Boolean isMine);
}
