package Task2FeedApplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class
Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "longblob")
    private ArrayList<HashMap<String,String>> feedList;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id",foreignKey = @ForeignKey (name="FK_USER_ID"))
    private User userId;

    public Posts(User userId)
    {
        this.userId=userId;
        ArrayList<HashMap<String,String>> feed_list=new ArrayList<>();
        this.feedList=feed_list;
    }
}
