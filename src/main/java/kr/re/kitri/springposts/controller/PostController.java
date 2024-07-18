package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 게시물 컨트롤러 클래스
 * 게시물 관련 API를 처리합니다.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    /**
     * 모든 게시물을 조회합니다.
     *
     * @return 모든 게시물 목록
     */
    @GetMapping("/posts")
    public Iterable<Post> allPosts() {
        log.debug("모든 게시물을 조회합니다.");
        return postService.viewAllPosts();
    }

    /**
     * ID로 게시물을 조회합니다.
     *
     * @param postId 조회할 게시물의 ID
     * @return 조회된 게시물
     */
    @GetMapping("/posts/{postId}")
    public Post viewPostById(@PathVariable long postId) {
        log.debug("ID로 게시물을 조회합니다. ID: " + postId);
        return postService.viewPostById(postId);
    }

    /**
     * 새로운 게시물을 등록합니다.
     *
     * @param post 등록할 게시물의 정보
     * @return 등록된 게시물
     */
    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        log.debug("새로운 게시물을 등록합니다. 제목: " + post.getTitle());
        return postService.registerPost(post);
    }

    /**
     * 게시물에 좋아요를 추가합니다.
     *
     * @param postId 좋아요를 추가할 게시물의 ID
     */
    @PatchMapping("/posts/{postId}/likes")
    public void doLike(@PathVariable long postId) {
        log.debug("게시물에 좋아요를 추가합니다. ID: " + postId);
        postService.updateLikesPlusOne(postId);
    }
}
