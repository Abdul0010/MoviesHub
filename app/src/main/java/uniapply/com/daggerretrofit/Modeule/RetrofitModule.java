package uniapply.com.daggerretrofit.Modeule;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
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
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkhttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return  new OkHttpClient.Builder()
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
