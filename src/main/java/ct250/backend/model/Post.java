package ct250.backend.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long postId;

    @Column(name = "POST_Title")
    private String postTitle;

    @Column(name = "POST_Type")
    private String postType;

    @Column(name = "POST_Author")
    private String postAuthor;

    @Column(name = "POST_Content", columnDefinition = "TEXT")
    private String postContent;

    @Column(name = "POST_ImagesURL")
    private String postImagesURL;

    


    public Post(Post post){
        this.postId = post.getPostId();
        this.postTitle = post.getPostTitle();
        this.postType = post.getPostType();
        this.postAuthor = post.getPostAuthor();
        this.postContent = post.getPostContent();
        this.postImagesURL = post.getPostImagesURL();
        
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(String postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostImagesURL() {
        return postImagesURL;
    }

    public void setPostImagesURL(String postImagesURL) {
        this.postImagesURL = postImagesURL;
    }


}
