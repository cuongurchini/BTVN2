package nguyen.zylin.btvn_tuan3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import nguyen.zylin.btvn_tuan3.Model.ResultModel;

/**
 * Created by nmdli on 14-Mar-18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<ResultModel> resultModelList;

    public RecyclerViewAdapter(Context context, List<ResultModel> resultModelList) {
        this.context = context;
        this.resultModelList = resultModelList;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View movieView = inflater.inflate(R.layout.recyclerview_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(movieView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ResultModel resultModel = resultModelList.get(position);

        Picasso.with(context).load("https://image.tmdb.org/t/p/w500/"+resultModel.getPosterPath()).into(holder.moviePoster);
        holder.movieName.setText(resultModel.getTitle());
        holder.movieDescription.setText(resultModel.getOverview());
    }

    @Override
    public int getItemCount() {
        return resultModelList == null ? 0 : resultModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView movieName, movieDescription;
        ImageView moviePoster;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.tv_movie_name);
            movieDescription = itemView.findViewById(R.id.tv_movie_description);
            moviePoster = itemView.findViewById(R.id.imgv_movie_poster);
        }
    }
}
