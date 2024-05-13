package Task2FeedApplication.Service;

import Task2FeedApplication.Entity.User;
import Task2FeedApplication.Model.LoginModel;
import Task2FeedApplication.Model.UserModel;
import Task2FeedApplication.Repository.PostsRepository;
import Task2FeedApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostsRepository postsRepository;

    @Override
    public String register(UserModel userModel) {
        return null;
    }

    @Override
    public String login(LoginModel loginModel) {
        return null;
    }

    @Override
    public User fetchUser(String userName) {
        return null;
    }
}
