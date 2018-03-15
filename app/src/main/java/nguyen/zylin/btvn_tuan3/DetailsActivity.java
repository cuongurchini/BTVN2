package nguyen.zylin.btvn_tuan3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nguyen.zylin.btvn_tuan3.Model.ResultModel;

public class DetailsActivity extends AppCompatActivity {

    ResultModel resultModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null) {
            resultModel = (ResultModel) intent.getSerializableExtra("result");
        }
    }
}
