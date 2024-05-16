package Task2FeedApplication.Service;
import Task2FeedApplication.Entity.Posts;
import Task2FeedApplication.Entity.User;
import Task2FeedApplication.Model.LoginModel;
import Task2FeedApplication.Model.PostsModel;
import Task2FeedApplication.Model.UserModel;
import Task2FeedApplication.NoResourceException;
import Task2FeedApplication.Repository.PostsRepository;
import Task2FeedApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    //Fetch my post
    @Override
    public Posts fetchMyPost(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new NoResourceException("No User Exists",HttpStatus.NOT_FOUND));
        Posts myPost=postsRepository.findByUserId(user);
        return myPost;
    }
    //Create new post
    @Override
    public String createPost(PostsModel postsModel,Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new NoResourceException("No User Exists",HttpStatus.NOT_FOUND));
        Posts myPost=postsRepository.findByUserId(user);
        ArrayList<HashMap<String,String>> list1=new ArrayList<>();
        HashMap<String,String> map1=new HashMap<>();
        map1.put("userId", postsModel.getUserId());
        map1.put("postId", String.valueOf(postsModel.getPostId()));
        map1.put("postDate",postsModel.getPostDate());
        map1.put("postCreator",postsModel.getPostCreator());
        map1.put("postDesc",postsModel.getPostDesc());
        map1.put("postStatus",postsModel.getPostStatus());
        list1=myPost.getFeedList();
        list1.add(map1);
        myPost.setFeedList(list1);
        myPost.setPostCount(myPost.getPostCount()+1);
        postsRepository.save(myPost);
        return "Post created Successfully!";
    }
    /*//Update post
    @Override
    public String updatePost(PostsModel postsModel,Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new NoResourceException("No User Exists",HttpStatus.NOT_FOUND));
        Posts myPost=postsRepository.findByUserId(user);
        ArrayList<HashMap<String,String>> list1=new ArrayList<>();
        int index1= postsModel.getPostId();
        list1=myPost.getFeedList();
        list1.get(index1).put("postDesc",postsModel.getPostDesc());
        list1.get(index1).put("postStatus",postsModel.getPostStatus());
        myPost.setFeedList(list1);
        postsRepository.save(myPost);
        return "Post updated Successfully!";
    }
    //Delete post
    @Override
    public String deletePost(PostsModel postsModel,Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new NoResourceException("No User Exists",HttpStatus.NOT_FOUND));
        Posts myPost=postsRepository.findByUserId(user);
        ArrayList<HashMap<String,String>> list1=new ArrayList<>();
        int index1= postsModel.getPostId();
        list1=myPost.getFeedList();
        list1.get(index1).put("postStatus","declined");
        myPost.setFeedList(list1);
        postsRepository.save(myPost);
        return "Post deleted Successfully!";
    }*/

    //Fetching all posts
    @Override
    public List getAllPosts() {
        ArrayList list1=new ArrayList<>();
        List post1=postsRepository.findAll();
        return post1;
    }

    //Update post Alternate
    @Override
    public String updatePost1(PostsModel postsModel,Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new NoResourceException("No User Exists",HttpStatus.NOT_FOUND));
        Posts myPost=postsRepository.findByUserId(user);
        ArrayList<HashMap<String,String>> list1=new ArrayList<>();
        list1=myPost.getFeedList();
        for(int i=0;i< list1.size();i++)
        {
            int index1= Integer.parseInt(list1.get(i).get("postId"));
            if(index1 == postsModel.getPostId())
            {
                list1.get(i).put("postDesc",postsModel.getPostDesc());
                list1.get(i).put("postStatus",postsModel.getPostStatus());
            }
        }
        myPost.setFeedList(list1);
        postsRepository.save(myPost);
        return "Post updated Successfully!";
    }

    @Override
    public String deletePost1(PostsModel postsModel,Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()-> new NoResourceException("No User Exists",HttpStatus.NOT_FOUND));
        Posts myPost=postsRepository.findByUserId(user);
        ArrayList<HashMap<String,String>> list1=new ArrayList<>();
        list1=myPost.getFeedList();
        for(int i=0;i< list1.size();i++)
        {
            int index1 = Integer.parseInt(list1.get(i).get("postId"));
            if(index1 == postsModel.getPostId())
            {
                list1.remove(i);
            }
        }
        myPost.setFeedList(list1);
        postsRepository.save(myPost);
        return "Post deleted Successfully!";
    }
}
