package ct250.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ct250.backend.model.Post;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import ct250.backend.repository.PostRepository;

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

    public void setPosts(ArrayList<Post> p) {
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
        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(Long id, Post post) {
        Post existingPost = findPostById(id);
        if (existingPost != null) {
            // Update fields based on your requirements
            existingPost.setPostTitle(post.getPostTitle());
            existingPost.setPostType(post.getPostType());
            existingPost.setPostAuthor(post.getPostAuthor());
            existingPost.setPostContent(post.getPostContent());
            existingPost.setPostImagesURL(post.getPostImagesURL());

            postRepository.save(existingPost);
            return existingPost;
        }
        return null;
    }

    @Transactional
    public String deletePost(Long id) {
        Post post = findPostById(id);
        if (post != null) {
            postRepository.delete(post);
            return "Post with ID " + id + " deleted successfully!";
        } else {
            return "Post with ID " + id + " not found.";
        }
    }
}
