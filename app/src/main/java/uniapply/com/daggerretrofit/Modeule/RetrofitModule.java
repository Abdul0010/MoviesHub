package uniapply.com.daggerretrofit.Modeule;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uniapply.com.daggerretrofit.Network.NetworkConnectionInterceptor;
import uniapply.com.daggerretrofit.Retrofit.ApiInterface;
import uniapply.com.daggerretrofit.Scopes.ApplicationScope;

@Module
public class RetrofitModule {
    @Provides
    @ApplicationScope
    ApiInterface getApiInterfece(Retrofit retrofit){
        return  retrofit.create(ApiInterface.class);
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
//                .baseUrl("https://newsapi.org/v2/")
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkhttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return  new OkHttpClient.Builder()
//                .addInterceptor(new NetworkConnectionInterceptor() {
//                    @Override
//                    public boolean isInternetAvailable() {
//                        return App.this.is
//                    }
//
//                    @Override
//                    public void onInternetUnavaliable() {
//
//                    }
//                })
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    HttpLoggingInterceptor provideHttplogginInterceptor(){

        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}
