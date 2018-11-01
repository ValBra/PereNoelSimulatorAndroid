package brable.perenoelsimulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static brable.perenoelsimulator.Menu.snow;
import static brable.perenoelsimulator.Menu.startMusic;
import static brable.perenoelsimulator.Menu.stopMusic;
import static brable.perenoelsimulator.Partie.PREFS1;
import static brable.perenoelsimulator.Partie.PREFS10;
import static brable.perenoelsimulator.Partie.PREFS11;
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
import static brable.perenoelsimulator.Partie.PREFS9;
import static brable.perenoelsimulator.Partie.atelier;
import static brable.perenoelsimulator.Partie.budg;
import static brable.perenoelsimulator.Partie.cadeau;
import static brable.perenoelsimulator.Partie.compteJours;
import static brable.perenoelsimulator.Partie.contenance;
import static brable.perenoelsimulator.Partie.day;
import static brable.perenoelsimulator.Partie.design;
import static brable.perenoelsimulator.Partie.livreurs;
import static brable.perenoelsimulator.Partie.lutins;
import static brable.perenoelsimulator.Partie.motiv;
import static brable.perenoelsimulator.Partie.people;
import static brable.perenoelsimulator.Partie.rd;
import static brable.perenoelsimulator.Partie.rennes;
import static brable.perenoelsimulator.Partie.reputation;
import static brable.perenoelsimulator.Partie.salaires;
import static brable.perenoelsimulator.Partie.traineau;
import static brable.perenoelsimulator.Partie.vitesse;

/**
 * Created by BRABLE on 7/28/2017.
 */

public class Tour extends AppCompatActivity {
    int liv,lut,sal,mot,bud,cad,ate,com,jou,tra,peo,cost1,cost2,cost3,vit,cont,des,ren,rep,rec;
    MediaPlayer up,bu;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour);
        MobileAds.initialize(this,"ca-app-pub-8018946824008626/4792111897");

        startMusic();

        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        motiv = getBaseContext().getSharedPreferences(PREFS10,MODE_PRIVATE);
        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        salaires = getBaseContext().getSharedPreferences(PREFS6,MODE_PRIVATE);
        budg = getBaseContext().getSharedPreferences(PREFS1,MODE_PRIVATE);
        compteJours = getBaseContext().getSharedPreferences(PREFS9,MODE_PRIVATE);
        cadeau = getBaseContext().getSharedPreferences(PREFS2,MODE_PRIVATE);
        atelier = getBaseContext().getSharedPreferences(PREFS11,MODE_PRIVATE);
        traineau = getBaseContext().getSharedPreferences(PREFS15,MODE_PRIVATE);
        people = getBaseContext().getSharedPreferences(PREFS16,MODE_PRIVATE);
        vitesse = getBaseContext().getSharedPreferences(PREFS17,MODE_PRIVATE);
        contenance = getBaseContext().getSharedPreferences(PREFS18,MODE_PRIVATE);
        design = getBaseContext().getSharedPreferences(PREFS19,MODE_PRIVATE);
        rennes = getBaseContext().getSharedPreferences(PREFS20,MODE_PRIVATE);
        reputation = getBaseContext().getSharedPreferences(PREFS4,MODE_PRIVATE);
        rd = getBaseContext().getSharedPreferences(PREFS13,MODE_PRIVATE);

        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        sal = salaires.getInt(PREFS6,MODE_PRIVATE);
        mot = motiv.getInt(PREFS10,MODE_PRIVATE);
        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        bud = budg.getInt(PREFS1,MODE_PRIVATE);
        com = compteJours.getInt(PREFS9,MODE_PRIVATE);
        cad = cadeau.getInt(PREFS2,MODE_PRIVATE);
        ate = atelier.getInt(PREFS11,MODE_PRIVATE);
        tra = traineau.getInt(PREFS15,MODE_PRIVATE);
        peo = people.getInt(PREFS16,MODE_PRIVATE);
        vit = vitesse.getInt(PREFS17,MODE_PRIVATE);
        cont = contenance.getInt(PREFS18,MODE_PRIVATE);
        des = design.getInt(PREFS19,MODE_PRIVATE);
        ren = rennes.getInt(PREFS20,MODE_PRIVATE);
        livreurs = getBaseContext().getSharedPreferences(PREFS14,MODE_PRIVATE);
        liv = livreurs.getInt(PREFS14,MODE_PRIVATE);
        rep = reputation.getInt(PREFS4,MODE_PRIVATE);
        rec = rd.getInt(PREFS13,MODE_PRIVATE);

        cost1 = vit*2000;
        cost2 = cont*2000;
        cost3 = des*2000;

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(String.valueOf(peo));
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText(String.valueOf(liv));
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setText(String.valueOf(tra));
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        tv4.setText(String.valueOf(ren));
        TextView t1 = (TextView) findViewById(R.id.t1);
        TextView t2 = (TextView) findViewById(R.id.t2);
        TextView t3 = (TextView) findViewById(R.id.t3);
        TextView t4 = (TextView) findViewById(R.id.t4);

        setFont(tv1,"ChiselMark.ttf");
        setFont(tv2,"ChiselMark.ttf");
        setFont(tv3,"ChiselMark.ttf");
        setFont(tv4,"ChiselMark.ttf");
        setFont(t1,"ChiselMark.ttf");
        setFont(t2,"ChiselMark.ttf");
        setFont(t3,"ChiselMark.ttf");
        setFont(t4,"ChiselMark.ttf");

        up = MediaPlayer.create(this,R.raw.caisse);
        bu = MediaPlayer.create(this,R.raw.bouton);

        final Button but1 = (Button) findViewById(R.id.but1);
        if(cost1>bud && cost2>bud && cost3>bud){
            but1.setEnabled(false);
        }

        but1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (tra == 0) {
                    Toast.makeText(v.getContext(),
                            "Buy sledges to access", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    bu.start();
                    setContentView(R.layout.traineaux);
                    TextView tv = (TextView) findViewById(R.id.tv1);
                    tv.setText(String.valueOf(bud));
                    TextView tv1 = (TextView) findViewById(R.id.tv2);
                    tv1.setText(String.valueOf(cost1));
                    TextView tv2 = (TextView) findViewById(R.id.tv3);
                    tv2.setText(String.valueOf(cost2));
                    TextView tv3 = (TextView) findViewById(R.id.tv4);
                    tv3.setText(String.valueOf(cost3));
                    TextView tv4 = (TextView) findViewById(R.id.tv5);
                    tv4.setText(String.valueOf(vit));
                    TextView tv5 = (TextView) findViewById(R.id.tv6);
                    tv5.setText(String.valueOf(cont + 9));
                    TextView tv6 = (TextView) findViewById(R.id.tv7);
                    tv6.setText(String.valueOf(des));
                    TextView t1 = (TextView) findViewById(R.id.t1);
                    TextView t2 = (TextView) findViewById(R.id.t2);
                    TextView t3 = (TextView) findViewById(R.id.t3);
                    TextView t4 = (TextView) findViewById(R.id.t4);
                    TextView t5 = (TextView) findViewById(R.id.t5);
                    TextView t6 = (TextView) findViewById(R.id.t6);
                    TextView t7 = (TextView) findViewById(R.id.t7);
                    TextView t8 = (TextView) findViewById(R.id.t8);
                    TextView t9 = (TextView) findViewById(R.id.t9);
                    TextView t10 = (TextView) findViewById(R.id.t10);
                    TextView t11 = (TextView) findViewById(R.id.t11);

                    setFont(t1, "ChiselMark.ttf");
                    setFont(t2, "ChiselMark.ttf");
                    setFont(t3, "ChiselMark.ttf");
                    setFont(t4, "ChiselMark.ttf");
                    setFont(t5, "ChiselMark.ttf");
                    setFont(t6, "ChiselMark.ttf");
                    setFont(t7, "ChiselMark.ttf");
                    setFont(t8, "ChiselMark.ttf");
                    setFont(t9, "ChiselMark.ttf");
                    setFont(t10, "ChiselMark.ttf");
                    setFont(t11, "ChiselMark.ttf");
                    setFont(tv1, "ChiselMark.ttf");
                    setFont(tv2, "ChiselMark.ttf");
                    setFont(tv3, "ChiselMark.ttf");
                    setFont(tv4, "ChiselMark.ttf");
                    setFont(tv5, "ChiselMark.ttf");
                    setFont(tv6, "ChiselMark.ttf");
                    setFont(tv, "ChiselMark.ttf");

                    Button but11 = (Button) findViewById(R.id.but11);
                    if (cost1 > bud) {
                        but11.setEnabled(false);
                    }
                    but11.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (rec + 1 == vit) {
                                Toast.makeText(v.getContext(),
                                        "Upgrade your R&D Center", Toast.LENGTH_SHORT)
                                        .show();
                            } else {
                                vit += 1;
                                up.start();
                                SharedPreferences.Editor editor1 = vitesse.edit();
                                editor1.putInt("vitesse", vit);
                                editor1.apply();

                                SharedPreferences.Editor editor2 = budg.edit();
                                editor2.putInt("budget", bud - cost1);
                                editor2.apply();

                                Toast.makeText(v.getContext(),
                                        R.string.vitAug, Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent1 = new Intent(Tour.this, MainActivity.class);
                                startActivity(intent1);
                                finish();
                            }
                        }
                    });

                    Button but12 = (Button) findViewById(R.id.but12);
                    if (cost2 > bud) {
                        but12.setEnabled(false);
                    }
                    but12.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (rec + 1 == cont) {
                                Toast.makeText(v.getContext(),
                                        "Upgrade your R&D Center", Toast.LENGTH_SHORT)
                                        .show();
                            } else {
                                cont += 1;
                                up.start();
                                SharedPreferences.Editor editor1 = contenance.edit();
                                editor1.putInt("contenance", cont);
                                editor1.apply();

                                SharedPreferences.Editor editor2 = budg.edit();
                                editor2.putInt("budget", bud - cost2);
                                editor2.apply();

                                Toast.makeText(v.getContext(),
                                        R.string.contAug, Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent1 = new Intent(Tour.this, MainActivity.class);
                                startActivity(intent1);
                                finish();
                            }
                        }
                    });


                    Button but13 = (Button) findViewById(R.id.but13);
                    if (cost3 > bud) {
                        but13.setEnabled(false);
                    }
                    but13.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (rec + 1 == des) {
                                Toast.makeText(v.getContext(),
                                        "Upgrade your R&D Center", Toast.LENGTH_SHORT)
                                        .show();
                            } else {
                                des += 1;
                                up.start();
                                SharedPreferences.Editor editor1 = design.edit();
                                editor1.putInt("design", des);
                                editor1.apply();

                                SharedPreferences.Editor editor3 = reputation.edit();
                                editor3.putInt("reput", rep + 2);
                                editor3.apply();

                                SharedPreferences.Editor editor2 = budg.edit();
                                editor2.putInt("budget", bud - cost3);
                                editor2.apply();

                                Toast.makeText(v.getContext(),
                                        R.string.appaAug, Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent1 = new Intent(Tour.this, MainActivity.class);
                                startActivity(intent1);
                                finish();
                            }
                        }
                    });

                    Button but4 = (Button) findViewById(R.id.but14);
                    but4.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            bu.start();
                            Intent truc = new Intent(Tour.this, Tour.class);
                            startActivity(truc);
                            finish();
                        }
                    });
                }
            }
        });

        Button but2 = (Button) findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.hire);
                bu.start();
                TextView tv = (TextView) findViewById(R.id.tv);
                tv.setBackgroundColor(getResources().getColor(R.color.sweetBlue));
                tv.setText(R.string.expLiv);
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                tv1.setBackgroundColor(getResources().getColor(R.color.sweetBlue));
                tv1.setText(R.string.com1);
                setFont(tv1,"ChiselMark.ttf");
                setFont(tv,"ChiselMark.ttf");

                EditText et1 = (EditText) findViewById(R.id.editText);
                et1.setText("0");

                Button button4 = (Button) findViewById(R.id.but4);
                button4.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        bu.start();
                        EditText et1 = (EditText) findViewById(R.id.editText);
                        if(et1.getText().toString().isEmpty()){
                            Toast.makeText(v.getContext(),
                                    R.string.invalide, Toast.LENGTH_SHORT)
                                    .show();
                        }else{
                            int adL = Integer.parseInt(et1.getText().toString());
                            liv+=adL;

                            SharedPreferences.Editor editor = livreurs.edit();
                            editor.putInt("livreurs",liv);
                            editor.apply();

                            Toast.makeText(v.getContext(),
                                    R.string.embL, Toast.LENGTH_SHORT)
                                    .show();

                            Intent intent1 = new Intent(Tour.this,MainActivity.class);
                            startActivity(intent1);
                            finish();
                        }
                    }
                });
            }
        });

        Button but3 = (Button) findViewById(R.id.but3);
        if(bud<10000){
            but3.setEnabled(false);
        }
        but3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                setContentView(R.layout.hire);
                ScrollView sv3=(ScrollView) findViewById(R.id.sv3);
                sv3.setBackgroundResource(R.drawable.traineau);
                TextView tv = (TextView) findViewById(R.id.tv);
                tv.setBackgroundColor(getResources().getColor(R.color.green));
                tv.setText(R.string.expTr);
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                tv1.setBackgroundColor(getResources().getColor(R.color.green));
                tv1.setText(R.string.com2);
                setFont(tv1,"ChiselMark.ttf");
                setFont(tv,"ChiselMark.ttf");

                EditText et1 = (EditText) findViewById(R.id.editText);
                et1.setText("0");

                Button button4 = (Button) findViewById(R.id.but4);
                button4.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        bu.start();
                        EditText et1 = (EditText) findViewById(R.id.editText);
                        int adL = Integer.parseInt(et1.getText().toString());
                        if(et1.getText().toString().isEmpty()){
                            Toast.makeText(v.getContext(),
                                    R.string.invalide, Toast.LENGTH_SHORT)
                                    .show();
                        }else if(adL*10000>bud){
                            Toast.makeText(v.getContext(),
                                    R.string.budgetInsu, Toast.LENGTH_SHORT)
                                    .show();
                        }else{
                            //int adL = Integer.parseInt(et1.getText().toString());
                            up.start();
                            tra+=adL;

                            SharedPreferences.Editor editor = traineau.edit();
                            editor.putInt("traineau",tra);
                            editor.apply();

                            SharedPreferences.Editor editor6 = budg.edit();
                            editor6.putInt("budget",bud-adL*10000);
                            editor6.apply();

                            Toast.makeText(v.getContext(),
                                    R.string.achT, Toast.LENGTH_SHORT)
                                    .show();

                            Intent intent1 = new Intent(Tour.this,MainActivity.class);
                            startActivity(intent1);
                            finish();
                        }
                    }
                });
            }
        });

        Button but5 = (Button) findViewById(R.id.but5);
        if(bud<5000){
            but5.setEnabled(false);
        }
        but5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                setContentView(R.layout.hire);
                ScrollView sv3 = (ScrollView) findViewById(R.id.sv3);
                sv3.setBackgroundResource(R.drawable.backgpn);
                TextView tv= (TextView) findViewById(R.id.tv);
                tv.setBackgroundColor(Color.RED);
                tv.setText(R.string.costR);
                setFont(tv,"ChiselMark.ttf");

                EditText et1 = (EditText) findViewById(R.id.editText);
                et1.setText("0");

                Button button4 = (Button) findViewById(R.id.but4);
                button4.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        bu.start();
                        EditText et1 = (EditText) findViewById(R.id.editText);
                        int adL = Integer.parseInt(et1.getText().toString());
                        if(et1.getText().toString().isEmpty()){
                            Toast.makeText(v.getContext(),
                                    R.string.invalide, Toast.LENGTH_SHORT)
                                    .show();
                        }else if(adL*5000>bud){
                            Toast.makeText(v.getContext(),
                                    R.string.budgetInsu, Toast.LENGTH_SHORT)
                                    .show();
                        }else{
                            up.start();
                            ren+=adL;

                            SharedPreferences.Editor editor = rennes.edit();
                            editor.putInt("rennes",ren);
                            editor.apply();

                            SharedPreferences.Editor editor1 = budg.edit();
                            editor1.putInt("budget",bud-(adL*5000));
                            editor1.apply();

                            Toast.makeText(v.getContext(),
                                    R.string.renA, Toast.LENGTH_SHORT)
                                    .show();

                            Intent intent1 = new Intent(Tour.this,MainActivity.class);
                            startActivity(intent1);
                            finish();
                        }
                    }
                });
            }
        });

        Button but4 = (Button) findViewById(R.id.but4);
        but4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                Intent intent1 = new Intent(Tour.this,MainActivity.class);

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

                startActivity(intent1);
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
