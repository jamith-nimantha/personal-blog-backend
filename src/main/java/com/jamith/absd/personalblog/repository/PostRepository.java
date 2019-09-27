package com.jamith.absd.personalblog.repository;

import com.jamith.absd.personalblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query(value = "SELECT * FROM T_POST ORDER BY CREATED_DATE DESC",nativeQuery = true)
    List<Post> getAllByCreatedDate();

    Post findTopById(Integer id);

    Post findTopByPermalink(String permalink);

    @Modifying
    @Transactional
    @Query(value = "UPDATE T_POST SET STATUS=?1 WHERE ID=?2",nativeQuery = true)
    Integer updateStatus(boolean status, Integer id);

    @Query(value = "SELECT * FROM T_POST WHERE STATUS=1 ORDER BY CREATED_DATE DESC", nativeQuery = true)
    List<Post> getAllByStatus();

    @Query(value = "SELECT SUM(VIEWS) FROM T_POST", nativeQuery = true)
    Integer getTotalPostViews();

    @Query(value = "SELECT COUNT(*) FROM T_POST", nativeQuery = true)
    Integer getTotalPostsCount();
}
