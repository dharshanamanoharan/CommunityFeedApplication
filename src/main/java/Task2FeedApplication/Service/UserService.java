package Task2FeedApplication.Service;
import Task2FeedApplication.Entity.Posts;
import Task2FeedApplication.Entity.User;
import Task2FeedApplication.Model.LoginModel;
import Task2FeedApplication.Model.PostsModel;
import Task2FeedApplication.Model.UserModel;

import java.util.ArrayList;
import java.util.List;
public interface UserService {
    String register(UserModel userModel);
    String login(LoginModel loginModel);
    User fetchUser(String userName);
    Posts fetchMyPost(Long userId);
    String createPost(PostsModel postsModel,Long userId);
    String updatePost(PostsModel postsModel,Long userId);
    String deletePost(PostsModel postsModel,Long userId);

    List getAllPosts();
}
