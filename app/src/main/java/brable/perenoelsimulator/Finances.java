package brable.perenoelsimulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.security.SecureRandom;

import static brable.perenoelsimulator.Menu.snow;
import static brable.perenoelsimulator.Menu.startMusic;
import static brable.perenoelsimulator.Partie.PREFS1;
import static brable.perenoelsimulator.Partie.PREFS11;
import static brable.perenoelsimulator.Partie.PREFS14;
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
import static brable.perenoelsimulator.Partie.day;
import static brable.perenoelsimulator.Partie.dettes;
import static brable.perenoelsimulator.Partie.livreurs;
import static brable.perenoelsimulator.Partie.lutins;
import static brable.perenoelsimulator.Partie.pretEnCours;
import static brable.perenoelsimulator.Partie.rennes;
import static brable.perenoelsimulator.Partie.reputation;
import static brable.perenoelsimulator.Partie.salaires;

/**
 * Created by BRABLE on 7/21/2017.
 */

public class Finances extends AppCompatActivity {

    int bud,rep,jou,det,pre,lut,sal,com,cad,ate,liv,ren;
    private AdView adv;
    MediaPlayer ba,bu;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finances);
        MobileAds.initialize(this,"ca-app-pub-8018946824008626/4792111897");

        adv = (AdView) findViewById(R.id.adV1);
        AdRequest adr = new AdRequest.Builder().build();
        adv.loadAd(adr);

        startMusic();

        budg = getBaseContext().getSharedPreferences(PREFS1,MODE_PRIVATE);
        cadeau = getBaseContext().getSharedPreferences(PREFS2,MODE_PRIVATE);
        day = getBaseContext().getSharedPreferences(PREFS3,MODE_PRIVATE);
        reputation = getBaseContext().getSharedPreferences(PREFS4,MODE_PRIVATE);
        dettes = getBaseContext().getSharedPreferences(PREFS8,MODE_PRIVATE);
        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        salaires = getBaseContext().getSharedPreferences(PREFS6,MODE_PRIVATE);
        compteJours = getBaseContext().getSharedPreferences(PREFS9,MODE_PRIVATE);
        atelier = getBaseContext().getSharedPreferences(PREFS11,MODE_PRIVATE);
        livreurs = getBaseContext().getSharedPreferences(PREFS14,MODE_PRIVATE);
        rennes = getBaseContext().getSharedPreferences(PREFS20,MODE_PRIVATE);

        bud = budg.getInt(PREFS1,MODE_PRIVATE);
        jou = day.getInt(PREFS3,MODE_PRIVATE);
        rep = reputation.getInt(PREFS4,MODE_PRIVATE);
        det = dettes.getInt(PREFS8,MODE_PRIVATE);
        pre = pretEnCours.getInt(PREFS7,MODE_PRIVATE);
        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        sal = salaires.getInt(PREFS6,MODE_PRIVATE);
        com = compteJours.getInt(PREFS9,MODE_PRIVATE);
        cad = cadeau.getInt(PREFS2,MODE_PRIVATE);
        ate = atelier.getInt(PREFS11,MODE_PRIVATE);
        liv = livreurs.getInt(PREFS14,MODE_PRIVATE);
        ren = rennes.getInt(PREFS20,MODE_PRIVATE);

        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView textView = (TextView) findViewById(R.id.textBud);
        textView.setText(String.valueOf(bud));
        setFont(text1,"ChiselMark.ttf");
        setFont(textView,"ChiselMark.ttf");

        Button button1 = (Button) findViewById(R.id.but1);
        Button button3 = (Button) findViewById(R.id.but3);
        Button button4 = (Button) findViewById(R.id.but4);
        Button button5 = (Button) findViewById(R.id.but5);

        ba = MediaPlayer.create(this,R.raw.money);
        bu = MediaPlayer.create(this,R.raw.bouton);
        if(pre!=1){
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    setContentView(R.layout.banque);

                    adv = (AdView) findViewById(R.id.adV1);
                    AdRequest adr = new AdRequest.Builder().build();
                    adv.loadAd(adr);

                    TextView loan = (TextView) findViewById(R.id.loan);
                    TextView repay = (TextView) findViewById(R.id.repay);
                    setFont(loan,"ChiselMark.ttf");
                    setFont(repay,"ChiselMark.ttf");

                    ba.start();

                    int remb = banque();
                    det+=remb;
                    TextView textv2 = (TextView) findViewById(R.id.tv12);
                    textv2.setText(String.valueOf(rep*1000000));
                    TextView textv = (TextView) findViewById(R.id.tv11);
                    textv.setText(String.valueOf(det));
                    bud+=rep*1000000;
                    setFont(textv2,"ChiselMark.ttf");
                    setFont(textv,"ChiselMark.ttf");

                    SharedPreferences.Editor editor = dettes.edit();
                    editor.putInt("dettes",det);
                    editor.apply();

                    SharedPreferences.Editor editor1 = budg.edit();
                    editor1.putInt("budget",bud);
                    editor1.apply();

                    SharedPreferences.Editor editor2 = pretEnCours.edit();
                    editor2.putInt("pretEnCours",1);
                    editor2.apply();

                    TextView ann3 = (TextView) findViewById(R.id.tv3);
                    ann3.setText(R.string.budget);
                    setFont(ann3,"ChiselMark.ttf");

                    TextView ann4 = (TextView) findViewById(R.id.tv4);
                    int newBudget = budg.getInt(PREFS1,MODE_PRIVATE);
                    ann4.setText(String.valueOf(newBudget));
                    setFont(ann4,"ChiselMark.ttf");

                    Button button21 = (Button) findViewById(R.id.butt11);
                    button21.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v){
                            ba.stop();
                            Intent intent1 = new Intent(Finances.this, MainActivity.class);
                            startActivity(intent1);
                            finish();
                        }
                    });
                }
            });
        }else{
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    new AlertDialog.Builder(Finances.this)
                            .setTitle(R.string.actImp)
                            .setMessage(R.string.dejaPret)
                            .setNegativeButton(R.string.dac, null)
                            .show();
                }
            });
        }

        SecureRandom rando = new SecureRandom();
        if (rep>rando.nextInt(100)+1){
            button3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    final ViewFlipper vf = (ViewFlipper) findViewById(R.id.flipp);
                    vf.showNext();

                    adv = (AdView) findViewById(R.id.adV2);
                    AdRequest adr = new AdRequest.Builder().build();
                    adv.loadAd(adr);

                    TextView tvi1 = (TextView) findViewById(R.id.tvi1);
                    TextView tvi3 = (TextView) findViewById(R.id.tvi3);

                    ba.start();
                    int res = investisseurs();
                    TextView tvi2 = (TextView) findViewById(R.id.tvi2);
                    tvi2.setText(String.valueOf(res));

                    bud += res;
                    TextView tvi4 = (TextView) findViewById(R.id.tvi4);
                    tvi4.setText(String.valueOf(bud));

                    setFont(tvi1,"ChiselMark.ttf");
                    setFont(tvi2,"ChiselMark.ttf");
                    setFont(tvi3,"ChiselMark.ttf");
                    setFont(tvi4,"ChiselMark.ttf");

                    SharedPreferences.Editor editor2 = reputation.edit();
                    editor2.putInt("reput",rep-5);
                    editor2.apply();

                    SharedPreferences.Editor editor1 = budg.edit();
                    editor1.putInt("budget", bud);
                    editor1.apply();
                }
            });
        }else{
            button3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    bu.start();
                    setContentView(R.layout.investors);

                    adv = (AdView) findViewById(R.id.adV1);
                    AdRequest adr = new AdRequest.Builder().build();
                    adv.loadAd(adr);

                    TextView tv31 = (TextView) findViewById(R.id.tv31);
                    setFont(tv31,"ChiselMark.ttf");
                    Button button31 = (Button) findViewById(R.id.but31);
                    button31.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent jspc = new Intent(Finances.this, MainActivity.class);
                            startActivity(jspc);
                            finish();
                        }
                    });
                }
            });
        }

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                bu.start();
                Intent truc = new Intent(Finances.this,MainActivity.class);
                startActivity(truc);
                finish();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                bu.start();
                Intent truc = new Intent(Finances.this,MainActivity.class);
                jou = day.getInt(PREFS3,MODE_PRIVATE);

                SharedPreferences.Editor editor1 = day.edit();
                editor1.putInt("days", jou+1);
                editor1.apply();

                bud+=(lut*sal+liv*60);
                bud+=(ren*10);
                SharedPreferences.Editor editor2 = budg.edit();
                editor2.putInt("budget",bud);
                editor2.apply();

                SharedPreferences.Editor editor = compteJours.edit();
                editor.putInt("compteJours",com-1);
                editor.apply();

                SharedPreferences.Editor editorjspc = cadeau.edit();
                editorjspc.putInt("cadeaux",cad-lut*ate);
                editorjspc.apply();

                startActivity(truc);
                finish();
            }
        });
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

    public int banque(){
        int interet = 100-rep;
        return rep*10000*interet + 1000000*rep;
    }

    public int investisseurs(){
        SecureRandom random = new SecureRandom();
        return rep*random.nextInt(1000000) + 1;
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
