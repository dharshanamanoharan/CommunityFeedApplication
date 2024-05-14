package Task2FeedApplication.Model;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PostsModel {
    private Long postId;
    private Long userId;
    private String postDate;
    private String postCreator;
    private String postDesc;
    private String postStatus;
}
