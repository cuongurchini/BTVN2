package nguyen.zylin.btvn_tuan3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

import nguyen.zylin.btvn_tuan3.Model.ItemClickListener;
import nguyen.zylin.btvn_tuan3.Model.MovieModel;
import nguyen.zylin.btvn_tuan3.Model.ResultModel;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    Gson gson = new Gson();
    List<ResultModel> resultModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        MovieModel movieModel = (MovieModel) gson.fromJson(MyApp.msgMovie, MovieModel.class);
        resultModelList = movieModel.getResults();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, resultModelList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View v, int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("result", resultModelList.get(position));
        startActivity(intent);
    }
}
