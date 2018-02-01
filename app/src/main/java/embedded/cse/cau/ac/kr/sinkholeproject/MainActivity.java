package embedded.cse.cau.ac.kr.sinkholeproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.screen);
        btn.setBackgroundColor(Color.TRANSPARENT);
    }

    public void screenClicked(View v){

        Intent intent = new Intent(getApplicationContext(),SelectCaseActivity.class);
        startActivity(intent);

    }
}
