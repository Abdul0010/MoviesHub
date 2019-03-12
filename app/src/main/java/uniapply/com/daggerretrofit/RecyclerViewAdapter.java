package uniapply.com.daggerretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import uniapply.com.daggerretrofit.Pojo.Articles;
import uniapply.com.daggerretrofit.Pojo.Posts;
import uniapply.com.daggerretrofit.Pojo.Results;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Results> data;
    private RecyclerViewAdapter.ClickListener clickListener;

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


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId;
         TextView txtTitle;
         ImageView img;
        public ViewHolder(View inflate) {
            super(inflate);
//            txtTitle=(TextView)inflate.findViewById(R.id.title);
            img=(ImageView) inflate.findViewById(R.id.img);
//            txtId=(TextView)inflate.findViewById(R.id.id);
        }
    }
    public interface ClickListener {
        public void LaunchIntent(String filmName);

    }
    public void setData(List<Results>data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
