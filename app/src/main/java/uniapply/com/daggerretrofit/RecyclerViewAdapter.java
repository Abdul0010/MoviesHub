package uniapply.com.daggerretrofit;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import uniapply.com.daggerretrofit.Pojo.Articles;
import uniapply.com.daggerretrofit.Pojo.Posts;
import uniapply.com.daggerretrofit.Pojo.Results;
import uniapply.com.daggerretrofit.Ui.DetailsActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Results> data;
    private RecyclerViewAdapter.ClickListener clickListener;
    Context mContext;

    public RecyclerViewAdapter(ClickListener clickListener) {
        this.clickListener=clickListener;
        data=new ArrayList<>();

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.txtId.setText(data.get(position).getTitle());
//        holder.txtTitle.setText(data.get(position).getOverview());

        Picasso.get().load("http://image.tmdb.org/t/p/w780//"+data.get(position).getPoster_path()).into(holder.img);
        final Pair pairs1=Pair.create(holder.img, ViewCompat.getTransitionName(holder.img));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("rating",data.get(position).getVote_average());
                intent.putExtra("lang",data.get(position).getOriginal_language());
                intent.putExtra("releaseDate",data.get(position).getRelease_date());
                intent.putExtra("overview",data.get(position).getOverview());
                intent.putExtra("img",data.get(position).getPoster_path());

               // ActivityOptions transitionActivityOption=ActivityOptions.makeSceneTransitionAnimation((Activity)mContext,pairs1);

                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         @BindView(R.id.img) ImageView img;
         @BindView(R.id.more) Button button;
        public ViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(inflate);

        }
    }
    public interface ClickListener {
        public void LaunchIntent(String filmName);

    }
    public void setData(List<Results> data, Context applicationContext){
        this.mContext=applicationContext;
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
