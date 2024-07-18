package kr.re.kitri.springposts.repository;

import kr.re.kitri.springposts.model.Post;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Modifying
    @Query("update  post_ set likes = likes + 1 where id = :postId")
    void increaseLikes(@Param("postId") long postId);
}
