package Task2FeedApplication.Service;
import Task2FeedApplication.Entity.Posts;
import Task2FeedApplication.Entity.User;
import Task2FeedApplication.Model.LoginModel;
import Task2FeedApplication.Model.PostsModel;
import Task2FeedApplication.Model.UserModel;
public interface UserService {
    String register(UserModel userModel);
    String login(LoginModel loginModel);
    User fetchUser(String userName);
    Posts fetchMyPost(Long userId);
    String createPost(PostsModel postsModel);
    String updatePost(PostsModel postsModel);
    String deletePost(PostsModel postsModel);
}
