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
        User user = userRepository.findByUserName(loginModel.getUserName());
        if (user != null)
        {
            if (user.getPassword().equals(loginModel.getPassword()))
            {
                return "valid";
            }
            else
            {
                return "Invalid";
            }
        }
        else
        {
            return "Invalid";
        }
    }

    @Override
    public User fetchUser(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
}
