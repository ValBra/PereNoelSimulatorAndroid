package brable.perenoelsimulator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.security.SecureRandom;

import static brable.perenoelsimulator.Menu.snow;
import static brable.perenoelsimulator.Menu.startMusic;
import static brable.perenoelsimulator.Menu.stopMusic;
import static brable.perenoelsimulator.Partie.PREFS1;
import static brable.perenoelsimulator.Partie.PREFS10;
import static brable.perenoelsimulator.Partie.PREFS11;
import static brable.perenoelsimulator.Partie.PREFS12;
import static brable.perenoelsimulator.Partie.PREFS13;
import static brable.perenoelsimulator.Partie.PREFS14;
import static brable.perenoelsimulator.Partie.PREFS15;
import static brable.perenoelsimulator.Partie.PREFS16;
import static brable.perenoelsimulator.Partie.PREFS2;
import static brable.perenoelsimulator.Partie.PREFS20;
import static brable.perenoelsimulator.Partie.PREFS21;
import static brable.perenoelsimulator.Partie.PREFS22;
import static brable.perenoelsimulator.Partie.PREFS23;
import static brable.perenoelsimulator.Partie.PREFS24;
import static brable.perenoelsimulator.Partie.PREFS3;
import static brable.perenoelsimulator.Partie.PREFS4;
import static brable.perenoelsimulator.Partie.PREFS5;
import static brable.perenoelsimulator.Partie.PREFS6;
import static brable.perenoelsimulator.Partie.PREFS7;
import static brable.perenoelsimulator.Partie.PREFS9;
import static brable.perenoelsimulator.Partie.atelier;
import static brable.perenoelsimulator.Partie.budg;
import static brable.perenoelsimulator.Partie.cadeau;
import static brable.perenoelsimulator.Partie.compteJours;
import static brable.perenoelsimulator.Partie.contenance;
import static brable.perenoelsimulator.Partie.day;
import static brable.perenoelsimulator.Partie.design;
import static brable.perenoelsimulator.Partie.dettes;
import static brable.perenoelsimulator.Partie.exist;
import static brable.perenoelsimulator.Partie.greve;
import static brable.perenoelsimulator.Partie.livreurs;
import static brable.perenoelsimulator.Partie.lutins;
import static brable.perenoelsimulator.Partie.motiv;
import static brable.perenoelsimulator.Partie.note;
import static brable.perenoelsimulator.Partie.people;
import static brable.perenoelsimulator.Partie.pretEnCours;
import static brable.perenoelsimulator.Partie.rd;
import static brable.perenoelsimulator.Partie.rennes;
import static brable.perenoelsimulator.Partie.reputation;
import static brable.perenoelsimulator.Partie.salaires;
import static brable.perenoelsimulator.Partie.siege;
import static brable.perenoelsimulator.Partie.toShow;
import static brable.perenoelsimulator.Partie.traineau;
import static brable.perenoelsimulator.Partie.vitesse;

public class MainActivity extends AppCompatActivity {

    int bud, cad, jou, rep,lut,sal,com,ate,liv,ren,noting,bom,mot,tra,peo,gre,sie,rec,tos;
    SecureRandom aleatoire = new SecureRandom();
    int ale = aleatoire.nextInt(100)+1;
    private AdView adv;
    private InterstitialAd ia;
    MediaPlayer bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.transition.fadein, R.transition.fadeout);

        startMusic();

        budg = getBaseContext().getSharedPreferences(PREFS1,MODE_PRIVATE);
        cadeau = getBaseContext().getSharedPreferences(PREFS2,MODE_PRIVATE);
        day = getBaseContext().getSharedPreferences(PREFS3,MODE_PRIVATE);
        reputation = getBaseContext().getSharedPreferences(PREFS4,MODE_PRIVATE);
        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        salaires = getBaseContext().getSharedPreferences(PREFS6,MODE_PRIVATE);
        compteJours = getBaseContext().getSharedPreferences(PREFS9,MODE_PRIVATE);
        atelier = getBaseContext().getSharedPreferences(PREFS11,MODE_PRIVATE);
        livreurs = getBaseContext().getSharedPreferences(PREFS14,MODE_PRIVATE);
        rennes = getBaseContext().getSharedPreferences(PREFS20,MODE_PRIVATE);
        exist = getBaseContext().getSharedPreferences(PREFS21,MODE_PRIVATE);
        note = getBaseContext().getSharedPreferences(PREFS22,MODE_PRIVATE);
        motiv = getBaseContext().getSharedPreferences(PREFS10,MODE_PRIVATE);
        traineau = getBaseContext().getSharedPreferences(PREFS15,MODE_PRIVATE);
        people = getBaseContext().getSharedPreferences(PREFS16,MODE_PRIVATE);
        greve = getBaseContext().getSharedPreferences(PREFS23,MODE_PRIVATE);
        siege = getBaseContext().getSharedPreferences(PREFS12,MODE_PRIVATE);
        rd = getBaseContext().getSharedPreferences(PREFS13,MODE_PRIVATE);
        toShow = getBaseContext().getSharedPreferences(PREFS24,MODE_PRIVATE);

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
        noting = note.getInt(PREFS22,MODE_PRIVATE);
        mot = motiv.getInt(PREFS10,MODE_PRIVATE);
        tra = traineau.getInt(PREFS15,MODE_PRIVATE);
        peo = people.getInt(PREFS16,MODE_PRIVATE);
        gre = greve.getInt(PREFS23,MODE_PRIVATE);
        sie = siege.getInt(PREFS12,MODE_PRIVATE);
        rec = rd.getInt(PREFS13,MODE_PRIVATE);
        tos = toShow.getInt(PREFS24,MODE_PRIVATE);
        if (noting!=1){
            noting=0;
        }

        bud-=(lut*sal+liv*60);
        bud-=(ren*10);

        TextView ch1 = (TextView) findViewById(R.id.christ1);
        TextView ch2 = (TextView) findViewById(R.id.christ2);
        setFont(ch1,"ChiselMark.ttf");
        setFont(ch2,"ChiselMark.ttf");

        bu = MediaPlayer.create(this,R.raw.bouton);

        SecureRandom rand = new SecureRandom();
        int random = rand.nextInt(150) + 1;
        if(random==150 && noting!=1 && mot>30){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.vousaimez)
                    .setMessage(R.string.noubliepas)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=brable.perenoelsimulator");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            SharedPreferences.Editor editorjesaispluscombien = note.edit();
                            editorjesaispluscombien.putInt("note",1);
                            editorjesaispluscombien.apply();
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton(R.string.later, null)
                    .show();
        }

        if(tos==1 && mot<30){
            SharedPreferences.Editor edi = greve.edit();
            edi.putInt("greve",1);
            edi.apply();
            MediaPlayer gr = MediaPlayer.create(this,R.raw.colere);
            gr.start();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.warning)
                    .setMessage(R.string.greve)
                    .setPositiveButton(R.string.ok,null)
                    .show();
            SharedPreferences.Editor to = toShow.edit();
            to.putInt("toShow",0);
            to.apply();
        }

        if(tos==1 && mot>30){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle(R.string.grevend)
                    .setMessage(R.string.grevend2)
                    .setPositiveButton(R.string.ok,null)
                    .show();
            SharedPreferences.Editor to = toShow.edit();
            to.putInt("toShow",0);
            to.apply();
        }

        if(bud<0 || rep==0){
            gameOver();
        }else if(jou==0){
            Intent intent1 = new Intent(MainActivity.this,Noel.class);
            startActivity(intent1);
            stopMusic();
            finish();
        //}else if (ale<8 && jou!=364){
            //alea();
        }else{
            setContentView(R.layout.activity_main);

            SharedPreferences.Editor editor1 = day.edit();
            editor1.putInt("days", jou-1);
            editor1.apply();

            SharedPreferences.Editor editor = compteJours.edit();
            editor.putInt("compteJours",com+1);
            editor.apply();

            if(sal<60 || mot<60){
                bom=1;
            }else if(sal<70){
                bom = 2;
            }else if(sal<80){
                bom=3;
            }
            else if(sal<90){
                bom=4;
            }else if(sal<100){
                bom=5;
            }else{
                if(mot>80){
                    bom = (sal/20)*2;
                }else{
                    bom=sal/20;
                }
            }
            if (gre!=1){
                SharedPreferences.Editor editorjspc = cadeau.edit();
                editorjspc.putInt("cadeaux",cad+lut*ate*bom);
                editorjspc.apply();
            }

            SharedPreferences.Editor editor2 = budg.edit();
            editor2.putInt("budget",bud);
            editor2.apply();

            TextView budT = (TextView) findViewById(R.id.budT);
            TextView repT = (TextView) findViewById(R.id.repT);
            TextView gifT = (TextView) findViewById(R.id.gifT);
            TextView dayT = (TextView) findViewById(R.id.dayT);
            setFont(budT,"ChiselMark.ttf");
            setFont(repT,"ChiselMark.ttf");
            setFont(dayT,"ChiselMark.ttf");
            setFont(gifT,"ChiselMark.ttf");

            TextView budget = (TextView) findViewById(R.id.textBud);
            budget.setText(String.valueOf(bud));

            TextView cadeau = (TextView) findViewById(R.id.textCad);
            cadeau.setText(String.valueOf(cad));

            TextView days = (TextView) findViewById(R.id.textJours);
            days.setText(String.valueOf(jou));

            TextView reput = (TextView) findViewById(R.id.textReput);
            reput.setText(String.valueOf(rep));

            setFont(reput,"ChiselMark.ttf");
            setFont(budget,"ChiselMark.ttf");
            setFont(cadeau,"ChiselMark.ttf");
            setFont(days,"ChiselMark.ttf");

            Button button1 = (Button) findViewById(R.id.but1);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    bu.start();
                    Intent intent1 = new Intent(MainActivity.this,Finances.class);
                    startActivity(intent1);
                    finish();
                }
            });

            Button button3 = (Button) findViewById(R.id.but3);
            button3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    bu.start();
                    Intent intent3 = new Intent(MainActivity.this,Lutins.class);
                    startActivity(intent3);
                    finish();
                }
            });

            Button button4 = (Button) findViewById(R.id.but4);
            button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    bu.start();
                    Intent intent1 = new Intent(MainActivity.this,Infrastructures.class);
                    startActivity(intent1);
                    finish();
                }
            });

            Button button5 = (Button) findViewById(R.id.but5);
            button5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    bu.start();
                    Intent intent1 = new Intent(MainActivity.this,Tour.class);
                    startActivity(intent1);
                    finish();
                }
            });
        }
    }

    public void gameOver(){
        setContentView(R.layout.sponsors);
        ScrollView sv2 = (ScrollView) findViewById(R.id.sv2);
        sv2.setBackgroundResource(R.drawable.sadlutins);
        stopMusic();
        MediaPlayer go = MediaPlayer.create(this,R.raw.disque);
        go.start();

        adv = (AdView) findViewById(R.id.adV1);
        AdRequest adr = new AdRequest.Builder().build();
        adv.loadAd(adr);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setTextSize(50);
        tv1.setText(R.string.gameOver);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setText(R.string.survive);
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        tv4.setText(String.valueOf(com));
        TextView tv5 = (TextView) findViewById(R.id.tv5);
        tv5.setText(R.string.joursGO);

        setFont(tv1,"ChiselMark.ttf");
        setFont(tv2,"ChiselMark.ttf");
        setFont(tv3,"ChiselMark.ttf");
        setFont(tv4,"ChiselMark.ttf");
        setFont(tv5,"ChiselMark.ttf");

        if(bud<0){
            tv2.setText(R.string.faillite);
        }else if(rep==0){
            tv2.setText(R.string.pasPop);
        }

        Button butt = (Button) findViewById(R.id.butt1);
        butt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                initialisation();
                Intent intent1 = new Intent(MainActivity.this,Menu.class);
                startActivity(intent1);

                AdRequest adr = new AdRequest.Builder().build();
                ia = new InterstitialAd(MainActivity.this);
                ia.setAdUnitId("ca-app-pub-8018946824008626/2142909581");
                ia.loadAd(adr);
                ia.setAdListener(new AdListener(){
                    public void onAdLoaded(){
                        displayInter();
                    }
                });

                finish();
            }
        });
    }

    public void displayInter(){
        if(ia.isLoaded()){
            ia.show();
        }
    }

    public void initialisation(){
        SharedPreferences.Editor editor5 = exist.edit();
        editor5.putInt("exist",0);
        editor5.apply();
    }

    /*public void alea(){
        setContentView(R.layout.alea);
        TextView tv1 = (TextView) findViewById(R.id.tvxx1);
        TextView tv2 = (TextView) findViewById(R.id.tvxx2);
        TextView tv3 = (TextView) findViewById(R.id.tvxx3);
        TextView tv4 = (TextView) findViewById(R.id.tvxx4);
        TextView tv5 = (TextView) findViewById(R.id.tvxx5);

        ScrollView sv3=(ScrollView) findViewById(R.id.sv3);
        MobileAds.initialize(this,"ca-app-pub-8018946824008626/4792111897");

        adv = (AdView) findViewById(R.id.adV1);
        AdRequest adr = new AdRequest.Builder().build();
        adv.loadAd(adr);

        setFont(tv1,"ChiselMark.ttf");
        setFont(tv2,"ChiselMark.ttf");
        setFont(tv3,"ChiselMark.ttf");
        setFont(tv4,"ChiselMark.ttf");
        setFont(tv5,"ChiselMark.ttf");

        if (ale==1){
            if(ren>0){
                SecureRandom ran = new SecureRandom();
                int ran2 = ran.nextInt(ren)+1;
                tv1.setText(R.string.epid);
                tv2.setText(R.string.rennesTue);
                tv3.setText(String.valueOf(ran2));
                tv4.setText(R.string.rennesRes);
                tv5.setText(String.valueOf(ren-ran2));
                SharedPreferences.Editor edi = rennes.edit();
                edi.putInt("rennes",ren-ran2);
                edi.apply();
            }else{
                tv5.setText(R.string.mamie);
            }
        }else if(ale==2){
            if(tra>0){
                sv3.setBackgroundResource(R.drawable.traineau);
                SecureRandom ran = new SecureRandom();
                int ran2 = ran.nextInt(tra)+1;
                tv1.setText(R.string.traineau1);
                tv2.setText(R.string.traineau2);
                tv3.setText(String.valueOf(ran2));
                tv4.setText(R.string.traineau3);
                tv5.setText(String.valueOf(tra-ran2));
                SharedPreferences.Editor edi = traineau.edit();
                edi.putInt("traineau",tra-ran2);
                edi.apply();
            }else{
                tv5.setText(R.string.mamie);
            }
        }else if(ale==3){
            sv3.setBackgroundResource(R.drawable.sadlutins);
            int ran2 = peo-(peo/10);
            tv3.setText(R.string.interdit);
            tv4.setText(R.string.interdit2);
            tv5.setText(String.valueOf(ran2));
            SharedPreferences.Editor edi = people.edit();
            edi.putInt("people",peo-ran2);
            edi.apply();
        }else if(ale==4){
            sv3.setBackgroundResource(R.drawable.luge);
            SecureRandom ran = new SecureRandom();
            int ran2 = ran.nextInt(bud)+1;
            tv2.setText(R.string.scandale1);
            tv3.setText(String.valueOf(ran2));
            tv4.setText(R.string.scandale2);
            tv5.setText(String.valueOf(bud-ran2));
            SharedPreferences.Editor edi = budg.edit();
            edi.putInt("budget",bud-ran2);
            edi.apply();
        }else if(ale==5){
            if(ate>1){
                tv5.setText(R.string.destruct1);
                SharedPreferences.Editor edi = atelier.edit();
                edi.putInt("atelier",0);
                edi.apply();
            }else{
                tv5.setText(R.string.mamie);
            }
        }else if(ale==6){
            if(rec>1){
                tv5.setText(R.string.destruct2);
                SharedPreferences.Editor edi = rd.edit();
                edi.putInt("rd",0);
                edi.apply();
            }else{
                tv5.setText(R.string.mamie);
            }
        }else if(ale==7){
            if(sie>1){
                tv5.setText(R.string.destruct3);
                SharedPreferences.Editor edi = siege.edit();
                edi.putInt("siege",0);
                edi.apply();
            }else{
                tv5.setText(R.string.mamie);
            }
        }else if(ale==8){
            if(bud>=220000000){
                tv3.setText(R.string.neymar);
                tv4.setText(R.string.scandale2);
                tv5.setText(String.valueOf(bud-220000000));
                SharedPreferences.Editor edi = budg.edit();
                edi.putInt("budget",bud-220000000);
                edi.apply();
            }else{
                tv5.setText(R.string.mamie);
            }
        }else{
            if(mot<40){
                tv5.setText(R.string.greve);
                SharedPreferences.Editor edi = greve.edit();
                edi.putInt("greve",1);
                edi.apply();
            }else{
                tv5.setText(R.string.mamie);
            }
        }

        Button butxx1 = (Button) findViewById(R.id.butxx1);
        butxx1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                initialisation();
                Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }*/

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
        snow.pause();
    }

    public void onResume(){
        super.onResume();
        snow.start();
        snow.setLooping(true);
    }
}
