package Task2FeedApplication.Repository;

import Task2FeedApplication.Entity.Posts;
import Task2FeedApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {

    Posts findByUserId(User userId);

}

