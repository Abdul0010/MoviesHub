package uniapply.com.daggerretrofit.Retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import uniapply.com.daggerretrofit.Pojo.MoviesResponse;
import uniapply.com.daggerretrofit.Pojo.Posts;
import uniapply.com.daggerretrofit.Pojo.news;

public interface ApiInterface {
    @GET("everything?sources=al-jazeera-english&apiKey=6647e84d0ceb435ca6a932d6afb92143")
    Observable<news> getPost();
    @GET("upcoming?api_key=f5c851a72648f0c96c4c2996c3883c2c&language=en-US&page=1")
    Observable<MoviesResponse> getUpCommingMovies();

}
