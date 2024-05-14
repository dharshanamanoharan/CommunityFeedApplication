package Task2FeedApplication.Service;
import Task2FeedApplication.Entity.User;
import Task2FeedApplication.Model.LoginModel;
import Task2FeedApplication.Model.PostsModel;
import Task2FeedApplication.Model.UserModel;
import java.util.List;
public interface UserService {
    String register(UserModel userModel);
    String login(LoginModel loginModel);
    User fetchUser(String userName);
    List fetchMyPost(Long userId);
    String createPost(PostsModel postsModel);
    String updatePost(PostsModel postsModel);
    String deletePost(PostsModel postsModel);
}
