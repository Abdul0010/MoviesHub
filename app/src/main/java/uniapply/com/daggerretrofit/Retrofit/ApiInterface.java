package uniapply.com.daggerretrofit.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import uniapply.com.daggerretrofit.Pojo.Posts;

public interface ApiInterface {
    @GET("Posts")
    Call<Posts> getPost();
}
