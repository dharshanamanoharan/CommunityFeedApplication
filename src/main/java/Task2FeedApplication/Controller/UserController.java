package Task2FeedApplication.Controller;
import Task2FeedApplication.Entity.Posts;
import Task2FeedApplication.Entity.User;
import Task2FeedApplication.Model.LoginModel;
import Task2FeedApplication.Model.PostsModel;
import Task2FeedApplication.Model.UserModel;
import Task2FeedApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/feed")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserModel userModel)
    {
        String createCheck=userService.register(userModel);
        if(createCheck.equalsIgnoreCase("registered"))
        {
            return new ResponseEntity<>("Registered Successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Registration Failed", HttpStatus.CONFLICT);
        }
    }
    //Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginModel loginModel)
    {
        String loginCheck=userService.login(loginModel);
        if(loginCheck.equalsIgnoreCase("valid"))
        {
            return new ResponseEntity<>("Logged in Successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Login Failed", HttpStatus.BAD_REQUEST);
        }
    }
    //Fetch User
    @GetMapping("/user/{userName}")
    public ResponseEntity<User> fetchUser(@PathVariable String userName)
    {
        User user=userService.fetchUser(userName);
        if(user!=null)
        {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    //Fetch MyPost
    @GetMapping("user/myPosts/{userId}")
    public ResponseEntity<Posts> fetchMyPost(@PathVariable Long userId)
    {
        Posts myPost=userService.fetchMyPost(userId);
        return new ResponseEntity<>(myPost,HttpStatus.OK);
    }
    //Create Post
    @PostMapping("user/createPost/{userId}")
    public ResponseEntity<String> createPost(@RequestBody PostsModel postsModel,@PathVariable Long userId)
    {
        String result=userService.createPost(postsModel,userId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    //Update MyPost
    @PutMapping("user/updatePost/{userId}")
    public ResponseEntity<String> updatePost(@RequestBody PostsModel postsModel,@PathVariable Long userId)
    {
        String result=userService.updatePost1(postsModel,userId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    //Delete MyPost
    @DeleteMapping("user/deletePost/{userId}")
    public ResponseEntity<String> deletePost(@PathVariable Long userId,@RequestBody PostsModel postsModel)
    {
        String result=userService.deletePost1(postsModel, userId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //Fetching All Posts
    @GetMapping("/allApprovedPosts")
    public ResponseEntity<List> getAllPosts()
    {
        List allPosts=userService.getAllPosts();
        return new ResponseEntity<>(allPosts,HttpStatus.OK);
    }
}
