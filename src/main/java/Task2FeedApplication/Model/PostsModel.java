package Task2FeedApplication.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class PostsModel {
    private Long id;
    private ArrayList<HashMap<String,String>> feedList;
}
