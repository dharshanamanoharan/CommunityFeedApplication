package Task2FeedApplication.Repository;

import Task2FeedApplication.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {

}
