package Task2FeedApplication.Model;
import Task2FeedApplication.Entity.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PostsModel {
    private Long postId;
    private User userId;
    private String postDate;
    private String postCreator;
    private String postDesc;
    private String postStatus;
}
