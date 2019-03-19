package uniapply.com.daggerretrofit.Ui;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import uniapply.com.daggerretrofit.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.rating)
    TextView rating;
    @BindView(R.id.language)
    TextView lang;
    @BindView(R.id.release_date)
    TextView release_date;
    @BindView(R.id.overview)
    TextView overview;
    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        rating.setText(intent.getStringExtra("rating"));
        lang.setText(intent.getStringExtra("lang"));
        release_date.setText(intent.getStringExtra("releaseDate"));
        overview.setText(intent.getStringExtra("overview"));
        Picasso.get().load("http://image.tmdb.org/t/p/w780//"+intent.getStringExtra("img")).into(img);



    }
}
