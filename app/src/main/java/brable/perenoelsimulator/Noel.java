package brable.perenoelsimulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static brable.perenoelsimulator.Partie.PREFS1;
import static brable.perenoelsimulator.Partie.PREFS10;
import static brable.perenoelsimulator.Partie.PREFS11;
import static brable.perenoelsimulator.Partie.PREFS12;
import static brable.perenoelsimulator.Partie.PREFS13;
import static brable.perenoelsimulator.Partie.PREFS14;
import static brable.perenoelsimulator.Partie.PREFS15;
import static brable.perenoelsimulator.Partie.PREFS16;
import static brable.perenoelsimulator.Partie.PREFS17;
import static brable.perenoelsimulator.Partie.PREFS18;
import static brable.perenoelsimulator.Partie.PREFS19;
import static brable.perenoelsimulator.Partie.PREFS2;
import static brable.perenoelsimulator.Partie.PREFS20;
import static brable.perenoelsimulator.Partie.PREFS3;
import static brable.perenoelsimulator.Partie.PREFS4;
import static brable.perenoelsimulator.Partie.PREFS5;
import static brable.perenoelsimulator.Partie.PREFS6;
import static brable.perenoelsimulator.Partie.PREFS7;
import static brable.perenoelsimulator.Partie.PREFS8;
import static brable.perenoelsimulator.Partie.PREFS9;
import static brable.perenoelsimulator.Partie.atelier;
import static brable.perenoelsimulator.Partie.budg;
import static brable.perenoelsimulator.Partie.cadeau;
import static brable.perenoelsimulator.Partie.compteJours;
import static brable.perenoelsimulator.Partie.contenance;
import static brable.perenoelsimulator.Partie.day;
import static brable.perenoelsimulator.Partie.design;
import static brable.perenoelsimulator.Partie.dettes;
import static brable.perenoelsimulator.Partie.livreurs;
import static brable.perenoelsimulator.Partie.lutins;
import static brable.perenoelsimulator.Partie.motiv;
import static brable.perenoelsimulator.Partie.people;
import static brable.perenoelsimulator.Partie.pretEnCours;
import static brable.perenoelsimulator.Partie.rd;
import static brable.perenoelsimulator.Partie.rennes;
import static brable.perenoelsimulator.Partie.reputation;
import static brable.perenoelsimulator.Partie.salaires;
import static brable.perenoelsimulator.Partie.siege;
import static brable.perenoelsimulator.Partie.traineau;
import static brable.perenoelsimulator.Partie.vitesse;

/**
 * Created by BRABLE on 7/30/2017.
 */

public class Noel extends AppCompatActivity {

    protected static final int TIMER_RUNTIME = 10000,SPLASH_TIME_OUT=3000;
    protected ProgressBar pg1;
    boolean mbActive;
    int bud,lut,sal,jou,com,cad,ate,liv,ren,rep,det,tra,cont,vit,peo;
    private AdView adv;
    MediaPlayer m,m2,bu;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noel);
        MobileAds.initialize(this,"ca-app-pub-8018946824008626/4792111897");
        m = MediaPlayer.create(this,R.raw.fanfare);
        m2 = MediaPlayer.create(this,R.raw.disapoint);
        bu = MediaPlayer.create(this,R.raw.bouton);
        adv = (AdView) findViewById(R.id.adV1);
        AdRequest adr = new AdRequest.Builder().build();
        adv.loadAd(adr);

        //startMusic();

        budg = getBaseContext().getSharedPreferences(PREFS1,MODE_PRIVATE);
        cadeau = getBaseContext().getSharedPreferences(PREFS2,MODE_PRIVATE);
        day = getBaseContext().getSharedPreferences(PREFS3,MODE_PRIVATE);
        reputation = getBaseContext().getSharedPreferences(PREFS4,MODE_PRIVATE);
        pretEnCours = getBaseContext().getSharedPreferences(PREFS7,MODE_PRIVATE);
        dettes = getBaseContext().getSharedPreferences(PREFS8,MODE_PRIVATE);
        compteJours = getBaseContext().getSharedPreferences(PREFS9,MODE_PRIVATE);
        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        salaires = getBaseContext().getSharedPreferences(PREFS6,MODE_PRIVATE);
        motiv = getBaseContext().getSharedPreferences(PREFS10,MODE_PRIVATE);
        atelier = getBaseContext().getSharedPreferences(PREFS11,MODE_PRIVATE);
        siege = getBaseContext().getSharedPreferences(PREFS12,MODE_PRIVATE);
        rd = getBaseContext().getSharedPreferences(PREFS13,MODE_PRIVATE);
        livreurs = getBaseContext().getSharedPreferences(PREFS14,MODE_PRIVATE);
        traineau = getBaseContext().getSharedPreferences(PREFS15,MODE_PRIVATE);
        people = getBaseContext().getSharedPreferences(PREFS16,MODE_PRIVATE);
        vitesse = getBaseContext().getSharedPreferences(PREFS17,MODE_PRIVATE);
        contenance = getBaseContext().getSharedPreferences(PREFS18,MODE_PRIVATE);
        design = getBaseContext().getSharedPreferences(PREFS19,MODE_PRIVATE);
        rennes = getBaseContext().getSharedPreferences(PREFS20,MODE_PRIVATE);

        bud = budg.getInt(PREFS1,MODE_PRIVATE);
        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        sal = salaires.getInt(PREFS6,MODE_PRIVATE);
        jou = day.getInt(PREFS3,MODE_PRIVATE);
        com = compteJours.getInt(PREFS9,MODE_PRIVATE);
        cad = cadeau.getInt(PREFS2,MODE_PRIVATE);
        ate = atelier.getInt(PREFS11,MODE_PRIVATE);
        liv = livreurs.getInt(PREFS14,MODE_PRIVATE);
        ren = rennes.getInt(PREFS20,MODE_PRIVATE);
        rep = reputation.getInt(PREFS4,MODE_PRIVATE);
        det = dettes.getInt(PREFS8,MODE_PRIVATE);
        tra = traineau.getInt(PREFS15,MODE_PRIVATE);
        cont = contenance.getInt(PREFS18,MODE_PRIVATE);
        vit = vitesse.getInt(PREFS17,MODE_PRIVATE);
        peo = people.getInt(PREFS16,MODE_PRIVATE);

        pg1 = (ProgressBar) findViewById(R.id.progressBar);
        TextView ch1 = (TextView) findViewById(R.id.christ1);
        TextView ch2 = (TextView) findViewById(R.id.christ2);
        setFont(ch1,"ChiselMark.ttf");
        setFont(ch2,"ChiselMark.ttf");

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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                reinistialisation();
                setContentView(R.layout.bilan);
                ScrollView sv=(ScrollView) findViewById(R.id.sv1);

                adv = (AdView) findViewById(R.id.adV1);
                AdRequest adr = new AdRequest.Builder().build();
                adv.loadAd(adr);

                TextView tv1 = (TextView) findViewById(R.id.tv1);
                int dis;
                if(tra>lut){
                    dis=lut*(cont+9)*vit;
                }else{
                    dis=tra*(cont+9)*vit;
                }
                tv1.setText(String.valueOf(dis));

                TextView tv2 = (TextView) findViewById(R.id.tv2);
                tv2.setText(String.valueOf(rep));
                TextView tv3 = (TextView) findViewById(R.id.tv3);
                TextView repo = (TextView) findViewById(R.id.report);
                TextView text2 = (TextView) findViewById(R.id.gifT2);
                TextView text3 = (TextView) findViewById(R.id.repT2);
                if(rep>80){
                    sv.setBackgroundResource(R.drawable.happylutins);
                    m.start();
                    tv3.setText(R.string.bilan2);
                }else if(rep>65){
                    sv.setBackgroundResource(R.drawable.happylutins);
                    m.start();
                    tv3.setText(R.string.bilan3);
                }else if(rep>50){
                    sv.setBackgroundResource(R.drawable.sadlutins);
                    m2.start();
                    tv3.setText(R.string.bilan4);
                }else{
                    sv.setBackgroundResource(R.drawable.sadlutins);
                    m2.start();
                    tv3.setText(R.string.bilan5);
                }
                setFont(tv1,"ChiselMark.ttf");
                setFont(tv2,"ChiselMark.ttf");
                setFont(tv3,"ChiselMark.ttf");
                setFont(repo,"ChiselMark.ttf");
                setFont(text2,"ChiselMark.ttf");
                setFont(text3,"ChiselMark.ttf");

                Button but1 = (Button) findViewById(R.id.but1);
                but1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bu.start();
                        Intent intent = new Intent(Noel.this,MainActivity.class);
                        startActivity(intent);

                        /*AdRequest adr = new AdRequest.Builder().build();
                        ia = new InterstitialAd(Noel.this);
                        ia.setAdUnitId("ca-app-pub-8018946824008626/2142909581");
                        ia.loadAd(adr);
                        ia.setAdListener(new AdListener(){
                            public void onAdLoaded(){
                                displayInter();
                            }
                        });*/

                        finish();
                    }
                });
            }
        },SPLASH_TIME_OUT);
    }

    public void updateProgress(final int TimePassed){
        if(null!=pg1){
            final int progress = pg1.getMax() * TimePassed/TIMER_RUNTIME;
            pg1.setProgress(progress);
        }
    }

    public void reinistialisation(){
        bud-=det;
        bud-=liv*1000;
        SharedPreferences.Editor editor1 = budg.edit();
        editor1.putInt("budget",bud);
        editor1.apply();

        if(tra>lut){
            cad-=lut*(cont+9)*vit;
        }else{
            cad-=tra*(cont+9)*vit;
        }
        if(cad<0){
            cad=0;
        }
        SharedPreferences.Editor editor2 = cadeau.edit();
        editor2.putInt("cadeaux",cad);
        editor2.apply();

        SharedPreferences.Editor editor3 = day.edit();
        editor3.putInt("days",364);
        editor3.apply();

        if(lut*(cont+9)*vit>=peo){
            rep+=30;
        }else if(lut*(cont+9)*vit>=peo-(peo/10)){
            rep+=20;
        }else if(lut*(cont+9)*vit>=peo-(peo/5)){
            rep+=10;
        }else if(lut*(cont+9)*vit>=peo-(peo/2)){
            rep+=5;
        }else{
            rep-=20;
        }
        if (rep>100){
            rep=100;
        }
        if(rep<0){
            rep=0;
        }
        SharedPreferences.Editor editor4 = reputation.edit();
        editor4.putInt("reput",rep);
        editor4.apply();

        SharedPreferences.Editor editor6 = pretEnCours.edit();
        editor6.putInt("pretEnCours",0);
        editor6.apply();

        SharedPreferences.Editor editor7 = dettes.edit();
        editor7.putInt("dettes",0);
        editor7.apply();

        SharedPreferences.Editor editor15 = livreurs.edit();
        editor15.putInt("livreurs",0);
        editor15.apply();

        if(rep==100){
            peo+=(peo/2);
        }else if (rep>=90){
            peo+=(peo/4);
        }else if(rep>=80){
            peo+=(peo/6);
        }else if(rep>=50){
            peo+=(peo/10);
        }else if(rep>=40){
            peo-=(peo/5);
        }else if(rep>=30){
            peo-=(peo/3);
        }else{
            peo-=(peo/2);
        }
        SharedPreferences.Editor editor17 = people.edit();
        editor17.putInt("people",peo);
        editor17.apply();
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

    public void onPause(){
        super.onPause();
        m.stop();
        m2.stop();
    }
}
