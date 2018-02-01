package embedded.cse.cau.ac.kr.sinkholeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_case);
    }


    public void sinkCaseClicked(View v){

        Intent intent = new Intent(getApplicationContext(),SinkCaseActivity.class);
        startActivity(intent);

    }

    public void holeCaseClicked(View v){

        Intent intent = new Intent(getApplicationContext(),HoleCaseActivity.class);
        startActivity(intent);

    }
}
