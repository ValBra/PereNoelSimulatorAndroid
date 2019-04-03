package brable.perenoelsimulator;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.Locale;

import static brable.perenoelsimulator.Partie.PREFS25;
import static brable.perenoelsimulator.Partie.langue;

/**
 * Created by BRABLE on 7/18/2017.
 */

public class Splash extends AppCompatActivity {

    int bam;
    boolean mbActive;
    private static int SPLASH_TIME_OUT = 3000;
    MediaPlayer splash;
    protected ProgressBar pg1;
    protected static final int TIMER_RUNTIME = 10000;
    String defaultLang;
    Locale locale;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        langue=getBaseContext().getSharedPreferences("langue",MODE_PRIVATE);

        defaultLang=Locale.getDefault().getLanguage();

        if(defaultLang.equals("en") || defaultLang.equals("fr") || defaultLang.equals("es") || defaultLang.equals("de") || defaultLang.equals("it")
                || defaultLang.equals("pt") || defaultLang.equals("da") || defaultLang.equals("sv") || defaultLang.equals("nb") || defaultLang.equals("fi")){
            locale=new Locale(langue.getString(PREFS25,defaultLang));
        }else{
            locale=new Locale(langue.getString(PREFS25,"en"));
        }
        Locale.setDefault(locale);
        Configuration conf = getBaseContext().getResources().getConfiguration();
        conf.locale= locale;
        getBaseContext().getResources().updateConfiguration(conf, getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.splash);
        splash = MediaPlayer.create(this,R.raw.brabley_jingle);

        SecureRandom random = new SecureRandom();
        bam = random.nextInt(5)+1;
        TextView tv = (TextView) findViewById(R.id.textView1);
        if(bam==1){
            tv.setText(R.string.sp1);
        }else if (bam==2){
            tv.setText(R.string.sp2);
        }else if(bam==3){
            tv.setText(R.string.sp3);
        }else if(bam==4){
            tv.setText(R.string.sp4);
        }else{
            tv.setText(R.string.sp5);
        }
        setFont(tv,"ChiselMark.ttf");

        pg1 = (ProgressBar) findViewById(R.id.progressBar);

        final Thread timerThread = new Thread(){
            public void run(){
                mbActive = true;
                try{
                    int waited = 0;
                    while(mbActive && (waited<TIMER_RUNTIME)){
                        sleep(200);
                        if(mbActive){
                            waited+=1000;
                            updateProgress(waited);
                        }
                    }
                } catch (InterruptedException e){
                    //JSP
                }
            }
        };
        timerThread.start();

        splash.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Menu.class);
                startActivity(intent);
                splash.stop();
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    public void updateProgress(final int TimePassed){
        if(null!=pg1){
            final int progress = pg1.getMax() * TimePassed/TIMER_RUNTIME;
            pg1.setProgress(progress);
        }
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
}
