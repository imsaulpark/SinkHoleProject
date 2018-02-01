package embedded.cse.cau.ac.kr.sinkholeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RankActivity extends AppCompatActivity {

    Intent prevIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        prevIntent = getIntent();
        Float topigo = Float.parseFloat(prevIntent.getExtras().getString("topigo"));
        Float thickness = Float.parseFloat(prevIntent.getExtras().getString("pojangdu"));
        Float depth = Float.parseFloat(prevIntent.getExtras().getString("pojangcheung"));
        Float width = Float.parseFloat(prevIntent.getExtras().getString("gongdongpok"));

        TextView rank = (TextView)findViewById(R.id.rank);
        TextView time = (TextView)findViewById(R.id.time);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        ImageView image4 = (ImageView) findViewById(R.id.imageView4);
        ImageView image5 = (ImageView) findViewById(R.id.imageView5);
        if(topigo<=0.2 && thickness<=0.1 && depth >= (thickness/2))
        {
            rank.setText("긴급");
            time.setText("4시간 이내 복구");
            image2.setImageResource(R.drawable.x3);
        }
        else if((topigo<=0.3 && thickness<=0.2 && depth >= (thickness/10)) || ( width>=1.5 &&depth >= (thickness/10))){
            rank.setText("우선");
            time.setText("신속한 조치계획 및 복구");
            image3.setImageResource(R.drawable.x3);
        }
        else if(thickness>=0.3 && width<0.8 && topigo>=0.4 && depth==0){
            rank.setText("관찰");
            time.setText("시작년도 우기 이전 복구");
            image5.setImageResource(R.drawable.x3);
        }
        else
        {
            rank.setText("일반");
            time.setText("우기철 이전 복구");
            image4.setImageResource(R.drawable.x3);
        }

    }
    public void backClicked(View v){

        onBackPressed();

    }

    public void nextClicked(View v){


        Log.d("SS",prevIntent.getExtras().getString("topigo"));


        Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
        intent.putExtra("case","hole");
        intent.putExtra("topigo",prevIntent.getExtras().getString("topigo"));
        intent.putExtra("pojangdu",prevIntent.getExtras().getString("pojangdu"));
        intent.putExtra("pojangcheung",prevIntent.getExtras().getString("pojangcheung"));
        intent.putExtra("gongdongpok",prevIntent.getExtras().getString("gongdongpok"));
        intent.putExtra("gongdonggil",prevIntent.getExtras().getString("gongdonggil"));
        intent.putExtra("gongdongnob",prevIntent.getExtras().getString("gongdongnob"));
        intent.putExtra("jihasu",prevIntent.getExtras().getString("jihasu"));
        intent.putExtra("direction",prevIntent.getExtras().getString("direction"));
        startActivity(intent);
    }
}
