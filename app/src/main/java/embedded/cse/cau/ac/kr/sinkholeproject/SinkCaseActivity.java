package embedded.cse.cau.ac.kr.sinkholeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class SinkCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sink_case);
    }

    public void backClicked(View v){

        Intent intent = new Intent(getApplicationContext(),SelectCaseActivity.class);
        startActivity(intent);

    }

    public void nextClicked(View v){


        EditText gongdongnob = (EditText)findViewById(R.id.gongdongnob);
        EditText gongdongpok = (EditText)findViewById(R.id.gongdongpok);
        EditText gongdonggil = (EditText)findViewById(R.id.gongdonggil);


        Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
        intent.putExtra("case","sink");
        intent.putExtra("gongdongnob",gongdongnob.getText().toString());
        intent.putExtra("gongdongpok",gongdongpok.getText().toString());
        intent.putExtra("gongdonggil",gongdonggil.getText().toString());
        startActivity(intent);
    }
}

