package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.service.PostService;
import kr.re.kitri.springposts.service.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> allPosts() {
        return postService.viewAllPosts();
    }

    // localhost:8080/posts/2
    @GetMapping("/posts/{postId}")
    public Post viewPostById(@PathVariable long postId) {
        return postService.viewPostById(postId);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.registerPost(post);
    }

    @PatchMapping("/posts/{postId}/likes")
    public Post doLike(@PathVariable long postId) {
        return postService.updateLikesPlusOne(postId);
    }

}
