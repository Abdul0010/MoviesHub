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
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.language)
    TextView lang;
    @BindView(R.id.releaseDate)
    TextView release_date;
    @BindView(R.id.overview)
    TextView overview;
    @BindView(R.id.imgPoster)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        rating.setText(intent.getStringExtra("rating"));
        title.setText(intent.getStringExtra("title"));
        lang.setText(intent.getStringExtra("lang"));
        release_date.setText(intent.getStringExtra("releaseDate"));
        overview.setText(intent.getStringExtra("overview"));
        Picasso.get().load("http://image.tmdb.org/t/p/w780//" + intent.getStringExtra("img"))
               .fit()
                .into(img);

    }
}
