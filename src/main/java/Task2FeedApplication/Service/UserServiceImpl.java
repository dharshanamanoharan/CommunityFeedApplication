package Task2FeedApplication.Service;
import Task2FeedApplication.Entity.Posts;
import Task2FeedApplication.Entity.User;
import Task2FeedApplication.Model.LoginModel;
import Task2FeedApplication.Model.UserModel;
import Task2FeedApplication.NoResourceException;
import Task2FeedApplication.Repository.PostsRepository;
import Task2FeedApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostsRepository postsRepository;
    //Register
    @Override
    public String register(UserModel userModel) {
        //Checking if userEmail exists already
        String mail = userModel.getEmail();
        if (userRepository.findByUserName(userModel.getUserName())!=null)
        {
            throw new NoResourceException("UserName exists already", HttpStatus.CONFLICT);
        }
        else
        {
            User user = new User();
            user.setEmail(userModel.getEmail());
            user.setUserName(userModel.getUserName());
            user.setPhoneNumber(userModel.getPhoneNumber());
            user.setPassword(userModel.getPassword());
            user.setRole(userModel.getRole());
            userRepository.save(user);
            Posts posts=new Posts(user);
            postsRepository.save(posts);
            return "Registered";
        }
    }
    //Login
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
    //Fetch User Data
    @Override
    public User fetchUser(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
    @Override
    public Posts fetchMyPost(Long userId) {
       // User user=userRepository.findById(userId).orElseThrow(()-> new NoResourceException("No User Exists",HttpStatus.NOT_FOUND));
        Posts myPost=postsRepository.findByUserId(userId);
        return myPost;
    }

    //Fetch User Posts

}
