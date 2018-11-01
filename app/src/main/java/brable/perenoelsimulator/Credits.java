package brable.perenoelsimulator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static brable.perenoelsimulator.Menu.snow;
import static brable.perenoelsimulator.Menu.startMusic;

/**
 * Created by BRABLE on 7/19/2017.
 */

public class Credits extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.transition.fadein, R.transition.fadeout);
        setContentView(R.layout.credits);

        startMusic();

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        TextView tv5 = (TextView) findViewById(R.id.tv5);
        TextView tv6 = (TextView) findViewById(R.id.tv6);
        TextView tv7 = (TextView) findViewById(R.id.tv7);
        TextView tv8 = (TextView) findViewById(R.id.tv8);
        TextView tv9 = (TextView) findViewById(R.id.tv9);
        TextView tv10 = (TextView) findViewById(R.id.tv10);
        TextView tv11 = (TextView) findViewById(R.id.tv11);
        TextView tv12 = (TextView) findViewById(R.id.tv12);
        TextView tv13 = (TextView) findViewById(R.id.tv13);
        TextView tv14 = (TextView) findViewById(R.id.tv14);
        setFont(tv1,"ChiselMark.ttf");
        setFont(tv2,"ChiselMark.ttf");
        setFont(tv3,"ChiselMark.ttf");
        setFont(tv4,"ChiselMark.ttf");
        setFont(tv5,"ChiselMark.ttf");
        setFont(tv6,"ChiselMark.ttf");
        setFont(tv7,"ChiselMark.ttf");
        setFont(tv8,"ChiselMark.ttf");
        setFont(tv9,"ChiselMark.ttf");
        setFont(tv10,"ChiselMark.ttf");
        setFont(tv11,"ChiselMark.ttf");
        setFont(tv12,"ChiselMark.ttf");
        setFont(tv13,"ChiselMark.ttf");
        setFont(tv14,"ChiselMark.ttf");
    }

    public void setFont(TextView textView, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }

    protected void onPause(){
        super.onPause();
        snow.pause();
        finish();
    }

    public void onResume(){
        super.onResume();
        snow.start();
        snow.setLooping(true);
    }
}
