package uniapply.com.daggerretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import uniapply.com.daggerretrofit.Pojo.Posts;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Posts> data;

    public RecyclerViewAdapter() {
        data=new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtId.setText(data.get(position).id);
        holder.txtTitle.setText(data.get(position).title);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtId;
        private TextView txtTitle;
        public ViewHolder(View inflate) {
            super(inflate);
            txtId=inflate.findViewById(R.id.id);
            txtTitle=inflate.findViewById(R.id.title);
        }
    }
}
