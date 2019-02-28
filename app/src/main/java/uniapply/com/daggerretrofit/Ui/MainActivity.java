package uniapply.com.daggerretrofit.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uniapply.com.daggerretrofit.Component.ApplicationComponent;
import uniapply.com.daggerretrofit.Component.DaggerMainActiviyComponent;
import uniapply.com.daggerretrofit.Component.MainActiviyComponent;
import uniapply.com.daggerretrofit.Modeule.MainActivityContextModule;
import uniapply.com.daggerretrofit.MyApplication;
import uniapply.com.daggerretrofit.Pojo.Posts;
import uniapply.com.daggerretrofit.Qualifires.ActivityContext;
import uniapply.com.daggerretrofit.Qualifires.ApplicationContext;
import uniapply.com.daggerretrofit.R;
import uniapply.com.daggerretrofit.RecyclerViewAdapter;
import uniapply.com.daggerretrofit.Retrofit.ApiInterface;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

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
        apiInterface.getPost().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                populateRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });

    }

    private void populateRecyclerView(List<Posts> body) {
        recyclerViewAdapter.setData(body);
    }

    @Override
    public void LaunchIntent(String filmName) {

    }
}
