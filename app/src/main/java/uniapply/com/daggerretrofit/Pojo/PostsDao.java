package uniapply.com.daggerretrofit.Pojo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Flowable;

@Dao
public interface PostsDao {
    @Insert
    void insertPostsIntoDatabase(Posts posts);
    @Query("SELECT * FROM POSTS")
    Flowable<List<Posts>>getPosts();
}
