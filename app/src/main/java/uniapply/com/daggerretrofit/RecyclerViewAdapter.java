package uniapply.com.daggerretrofit;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import uniapply.com.daggerretrofit.Pojo.Results;

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
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(data.get(position).getOverview());
        LayerDrawable stars = (LayerDrawable) holder.ratingBar.getProgressDrawable();

        holder.ratingBar.setRating(Float.parseFloat(data.get(position).getVote_average())/2);

        Picasso.get().load("http://image.tmdb.org/t/p/w780//"+data.get(position).getPoster_path()).into(holder.img);
      //  final Pair pairs1=Pair.create(holder.img, ViewCompat.getTransitionName(holder.img));

//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(v.getContext(), DetailsActivity.class);
//                intent.putExtra("rating",data.get(position).getVote_average());
//                intent.putExtra("lang",data.get(position).getOriginal_language());
//                intent.putExtra("releaseDate",data.get(position).getRelease_date());
//                intent.putExtra("overview",data.get(position).getOverview());
//                intent.putExtra("img",data.get(position).getPoster_path());
//
//               // ActivityOptions transitionActivityOption=ActivityOptions.makeSceneTransitionAnimation((Activity)mContext,pairs1);
//
//                v.getContext().startActivity(intent);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId;
        TextView txtTitle;
        ImageView img;
        RatingBar ratingBar;

        Button button;
        ViewHolder(View inflate) {
            super(inflate);
            txtTitle=(TextView)inflate.findViewById(R.id.title);
            img=(ImageView) inflate.findViewById(R.id.details_image);
            ratingBar=(RatingBar) inflate.findViewById(R.id.rating);
           // button=(Button) inflate.findViewById(R.id.more);
//            txtId=(TextView)inflate.findViewById(R.id.id);
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
