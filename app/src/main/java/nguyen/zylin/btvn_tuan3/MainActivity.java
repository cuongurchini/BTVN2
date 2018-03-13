package nguyen.zylin.btvn_tuan3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import nguyen.zylin.btvn_tuan3.Model.MovieModel;
import nguyen.zylin.btvn_tuan3.Model.ResultModel;

public class MainActivity extends AppCompatActivity {

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
    }
}
