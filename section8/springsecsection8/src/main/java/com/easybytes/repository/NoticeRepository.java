package com.easybytes.repository;

import com.easybytes.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Integer> {

    @Query(value = "from Notice n where CURRENT_DATE BETWEEN n.noticBegDt AND n.noticEndDt")
    List<Notice> findAllActiveNotices();

}
