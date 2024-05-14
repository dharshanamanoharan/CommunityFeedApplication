package Task2FeedApplication.Model;
import Task2FeedApplication.Entity.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PostsModel {
    private String postId;
    private String userId;
    private String postDate;
    private String postCreator;
    private String postDesc;
    private String postStatus;
}
