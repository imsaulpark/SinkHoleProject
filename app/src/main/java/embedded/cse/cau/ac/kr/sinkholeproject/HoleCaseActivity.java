package embedded.cse.cau.ac.kr.sinkholeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HoleCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole_case);

        final String[] data = getResources().getStringArray(R.array.direction);
        ArrayAdapter<String> adapter;
        Spinner spinner;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,data);
        spinner = (Spinner)findViewById(R.id.direction);
        spinner.setAdapter(adapter);
    }


    public void backClicked(View v){

        Intent intent = new Intent(getApplicationContext(),SelectCaseActivity.class);
        startActivity(intent);

    }

    public void nextClicked(View v){

        EditText topigo = (EditText)findViewById(R.id.topigo);
        EditText pojangdu = (EditText)findViewById(R.id.pojangdu);
        EditText pojangcheung = (EditText)findViewById(R.id.pojangcheung);
        EditText gongdongpok = (EditText)findViewById(R.id.gongdongpok);
        EditText gongdonggil = (EditText)findViewById(R.id.gongdonggil);
        EditText gongdongnob = (EditText)findViewById(R.id.gongdongnob);
        EditText jihasu = (EditText)findViewById(R.id.jihasu);
        Spinner direction = (Spinner) findViewById(R.id.direction);

        if (topigo.getText().toString().trim().length() < 1)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "토피고를 입력하세요", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else if(pojangdu.getText().toString().trim().length() < 1)
        {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "포장 두께를 입력하세요", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else if(pojangcheung.getText().toString().trim().length() < 1)
        {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "포장층 균열깊이를 입력하세요", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else if(gongdongpok.getText().toString().trim().length() < 1)
        {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "공동 폭을 입력하세요", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else if(gongdonggil.getText().toString().trim().length() < 1)
        {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "공동 길이를 입력하세요", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else if(jihasu.getText().toString().trim().length() < 1)
        {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "지하수 위치를 입력하세요", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else {



            Intent intent = new Intent(getApplicationContext(), RankActivity.class);
            intent.putExtra("case", "hole");
            intent.putExtra("topigo", topigo.getText().toString());
            intent.putExtra("pojangdu", pojangdu.getText().toString());
            intent.putExtra("pojangcheung", pojangcheung.getText().toString());
            intent.putExtra("gongdongpok", gongdongpok.getText().toString());
            intent.putExtra("gongdonggil", gongdonggil.getText().toString());
            intent.putExtra("gongdongnob", gongdongnob.getText().toString());
            intent.putExtra("jihasu", jihasu.getText().toString());
            intent.putExtra("direction", direction.getSelectedItem().toString());
            startActivity(intent);
        }
    }
}
