package Task2FeedApplication.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class PostsModel {
    private Long postId;
    private Long userId;
    private String postDesc;
    private String postStatus="pending";
}
