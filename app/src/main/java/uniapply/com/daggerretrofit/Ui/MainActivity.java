package uniapply.com.daggerretrofit.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;
import uniapply.com.daggerretrofit.Component.ApplicationComponent;
import uniapply.com.daggerretrofit.Component.DaggerMainActiviyComponent;
import uniapply.com.daggerretrofit.Component.MainActiviyComponent;
import uniapply.com.daggerretrofit.Modeule.MainActivityContextModule;
import uniapply.com.daggerretrofit.MyApplication;
import uniapply.com.daggerretrofit.Pojo.Articles;
import uniapply.com.daggerretrofit.Pojo.MoviesResponse;
import uniapply.com.daggerretrofit.Pojo.Posts;
import uniapply.com.daggerretrofit.Pojo.Results;
import uniapply.com.daggerretrofit.Pojo.news;
import uniapply.com.daggerretrofit.Qualifires.ActivityContext;
import uniapply.com.daggerretrofit.Qualifires.ApplicationContext;
import uniapply.com.daggerretrofit.R;
import uniapply.com.daggerretrofit.RecyclerViewAdapter;
import uniapply.com.daggerretrofit.Retrofit.ApiInterface;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    MainActiviyComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;
    @Inject
    public ApiInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context applicationContext;
    @Inject
    @ActivityContext
    public Context activityContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        ApplicationComponent applicationComponent= MyApplication.get(this).getApplicationComponent();
        mainActivityComponent= DaggerMainActiviyComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        Observable<MoviesResponse> observable=apiInterface.getUpCommingMovies();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<MoviesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Timber.i("on subscribe");

                    }

                    @Override
                    public void onNext(MoviesResponse response) {
                        populateRecyclerView(response);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.i("error !");

                    }

                    @Override
                    public void onComplete() {
                        Timber.i("on complete");

                    }
                });


    }

    private void populateRecyclerView(MoviesResponse body) {
        List<Results>results= Arrays.asList(body.getResults());
        recyclerViewAdapter.setData(results);
    }

    @Override
    public void LaunchIntent(String filmName) {

    }
}
