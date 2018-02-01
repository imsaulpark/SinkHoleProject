package embedded.cse.cau.ac.kr.sinkholeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView pouch = (TextView) findViewById(R.id.pouch);
        TextView location = (TextView)findViewById(R.id.location);
        TextView numInput = (TextView)findViewById(R.id.numInput);
        TextView speed = (TextView)findViewById(R.id.speed);
        TextView time = (TextView)findViewById(R.id.time);
        ImageView image = (ImageView) findViewById(R.id.image);

        Double volume;
        int numPouch;
        int totalSeconds;
        String totalTime="";
        String direction="없음";


        Intent intent = getIntent();
        String whichCase = intent.getExtras().getString("case");

        Log.d("GG",whichCase);

        Float gongdongpok =  Float.parseFloat(intent.getExtras().getString("gongdongpok"));
        Float gongdonggil =  Float.parseFloat(intent.getExtras().getString("gongdonggil"));




        Float gongdongnob;

        Log.d("FF",intent.getExtras().getString("gongdongnob"));

        if (intent.getExtras().getString("gongdongnob").trim().length() > 0)
        {
            gongdongnob=Float.parseFloat(intent.getExtras().getString("gongdongnob"));
            volume = Math.PI  * gongdonggil * gongdongnob * gongdongpok * 4 / 3;
        }
        else
        {
            volume = Math.PI * gongdonggil * Math.pow(gongdongpok,2) * 4 / 3;
        }


        if(whichCase.equals("hole"))
        {
            direction = (intent.getExtras().getString("direction"));
        }
        else
        {
            volume/=2;
        }

        numPouch = (int) (volume * 5950 / 0.1);
        pouch.setText(String.valueOf(numPouch));


        if(direction.equals("없음"))
        {
            totalSeconds = (int) (volume*600/0.1)/2;
            location.setText("중앙");
            numInput.setText("4");
            speed.setText("19.82");
            image.setImageResource(R.drawable.center);
        }
        else
        {
            totalSeconds = (int) (volume*600/0.1);
            location.setText("가장자리");
            numInput.setText("2");
            speed.setText("9.91");
            image.setImageResource(R.drawable.edge);
        }

        totalTime = totalTime+String.valueOf(totalSeconds/3600);
        totalTime+="H ";
        totalSeconds= totalSeconds%3600;
        totalTime+=(String.valueOf(totalSeconds/60));
        totalTime+="M";
        time.setText(totalTime);



    }

    public void backClicked(View v){

        onBackPressed();

    }
}
