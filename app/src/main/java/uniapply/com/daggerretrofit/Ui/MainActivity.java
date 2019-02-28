package uniapply.com.daggerretrofit.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import uniapply.com.daggerretrofit.Modeule.MainActivityContextModule;
import uniapply.com.daggerretrofit.R;
import uniapply.com.daggerretrofit.RecyclerViewAdapter;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    MainActivityContextModule mainActivityContextModule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void LaunchIntent(String filmName) {

    }
}
