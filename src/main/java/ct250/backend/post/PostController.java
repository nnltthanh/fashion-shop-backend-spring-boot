package ct250.backend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping({ "/", "" })
    public String getAllPost() {
        postService.findAllPosts();
        String postList = "";
        for (Post post : postService.getPosts()) {
            postList += "\n" + post.toString();
        }
        return "Call find all posts function " + postList;
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable Long id) {
        if (postService.findPostById(id) == null) {
            return "Call find post by ID " + id + " function\nCan not found post has id " + id;
        }
        return "Call find post by ID " + id + " function\n" + postService.findPostById(id).toString();
    }

    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable Long id) {
        if (postService.deletePost(id)) {
            return "Call delete user by ID " + id + " function\n" + "id " + id + " User has been deleted!";
        } else if (postService.findPostById(id) == null) {
            return "Call delete post by ID " + id + " function\n" + "Can not found post has id " + id;
        }
        return "Call delete post by ID " + id + " function\n" + "Can not delete post has id " + id;
    }

    @PutMapping("/{id}")
    public String updatePostById(@PathVariable Long id, @RequestBody Post post) {
        if (postService.updatePost(id, post) != null) {
            return "Call update post by ID " + id + " function\n" + postService.updatePost(id, post).toString();
        }
        return "Call update post by ID " + id + " function\n" + "Failed Update!!!";
    }

    @PostMapping("/add")
    public String addPost(@RequestBody Post post) {
        post = postService.addPost(post);
        if (post == null) {
            return "Call add post function \n" + "Add post failed";
        }
        return "Call add post function \n" + post.toString();
    }

}
