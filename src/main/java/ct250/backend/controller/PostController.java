package ct250.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ct250.backend.model.Post;
import ct250.backend.model.User;
import ct250.backend.service.PostService;

@RestController
@RequestMapping("/p")
public class PostController {
    
	@Autowired
    private PostService postService;

    @GetMapping()
    public String getAllPost() {
        postService.findAllPosts();
        String postList = "";
        for (Post post : postService.getPosts()) {
            postList += "\n" + post.toString();
        }
        return "Call find all posts function " + postList;
    }

    @GetMapping("/id={id}")
    public String getUserById(@PathVariable Long id) {
        if (postService.findPostById(id) == null) {
            return "Call find user by ID " + id + " function\nCan not found user has id " + id;
        }
        return "Call find post by ID " + id + " function\n" + postService.findPostById(id).toString();
    }

    
}





