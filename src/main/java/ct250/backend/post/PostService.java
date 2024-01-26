package ct250.backend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.ArrayList;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private ArrayList<Post> posts;

    public PostService(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public PostService() {
        this.posts = new ArrayList<>();
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> findAllPosts() {
        System.out.println("Call find all posts function");
        this.posts = (ArrayList<Post>) postRepository.findAll();
        for (Post a : posts) {
            System.out.println(a.toString());
        }
        return posts;
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Transactional
    public Post addPost(Post post) {
        System.out.println(post);
        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(Long id, Post post) {
        Post existingPost = findPostById(id);
        if (existingPost != null) {
            // Update fields based on your requirements
            existingPost.setTitle(post.getTitle());
            existingPost.setType(post.getType());
            existingPost.setAuthor(post.getAuthor());
            existingPost.setContent(post.getContent());
            existingPost.setImagesURL(post.getImagesURL());
            existingPost.setPublicAt(post.getPublicAt());

            postRepository.save(existingPost);
            return existingPost;
        }
        return null;
    }

    @Transactional
    public boolean deletePost(Long id) {
        Post resultFindPost = findPostById(id);
        if (resultFindPost != null) {
            postRepository.delete(resultFindPost);
            return true;
        } else {
            return false;
        }
    }
}
