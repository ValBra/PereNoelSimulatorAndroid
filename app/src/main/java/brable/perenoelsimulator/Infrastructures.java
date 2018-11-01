package brable.perenoelsimulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static brable.perenoelsimulator.Menu.snow;
import static brable.perenoelsimulator.Menu.startMusic;
import static brable.perenoelsimulator.Partie.PREFS1;
import static brable.perenoelsimulator.Partie.PREFS11;
import static brable.perenoelsimulator.Partie.PREFS12;
import static brable.perenoelsimulator.Partie.PREFS13;
import static brable.perenoelsimulator.Partie.PREFS14;
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
import static brable.perenoelsimulator.Partie.day;
import static brable.perenoelsimulator.Partie.livreurs;
import static brable.perenoelsimulator.Partie.lutins;
import static brable.perenoelsimulator.Partie.rd;
import static brable.perenoelsimulator.Partie.rennes;
import static brable.perenoelsimulator.Partie.reputation;
import static brable.perenoelsimulator.Partie.salaires;
import static brable.perenoelsimulator.Partie.siege;

/**
 * Created by BRABLE on 7/27/2017.
 */

public class Infrastructures extends AppCompatActivity {

    int ate,sie,rec,cost1,cost2,cost3,bud,jou,lut,sal,com,cad,liv,ren,rep;
    MediaPlayer up,bu;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infrastructures);

        startMusic();

        atelier = getBaseContext().getSharedPreferences(PREFS11,MODE_PRIVATE);
        siege = getBaseContext().getSharedPreferences(PREFS12,MODE_PRIVATE);
        rd = getBaseContext().getSharedPreferences(PREFS13,MODE_PRIVATE);
        budg = getBaseContext().getSharedPreferences(PREFS1,MODE_PRIVATE);
        day = getBaseContext().getSharedPreferences(PREFS3,MODE_PRIVATE);
        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        salaires = getBaseContext().getSharedPreferences(PREFS6,MODE_PRIVATE);
        compteJours = getBaseContext().getSharedPreferences(PREFS9,MODE_PRIVATE);
        cadeau = getBaseContext().getSharedPreferences(PREFS2,MODE_PRIVATE);
        livreurs = getBaseContext().getSharedPreferences(PREFS14,MODE_PRIVATE);
        rennes = getBaseContext().getSharedPreferences(PREFS20,MODE_PRIVATE);
        reputation = getBaseContext().getSharedPreferences(PREFS4,MODE_PRIVATE);

        bud = budg.getInt(PREFS1,MODE_PRIVATE);
        ate = atelier.getInt(PREFS11,MODE_PRIVATE);
        sie = siege.getInt(PREFS12,MODE_PRIVATE);
        rec = rd.getInt(PREFS13,MODE_PRIVATE);
        com = compteJours.getInt(PREFS9,MODE_PRIVATE);
        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        sal = salaires.getInt(PREFS6,MODE_PRIVATE);
        cad = cadeau.getInt(PREFS2,MODE_PRIVATE);
        liv = livreurs.getInt(PREFS14,MODE_PRIVATE);
        ren = rennes.getInt(PREFS20,MODE_PRIVATE);
        rep = reputation.getInt(PREFS4,MODE_PRIVATE);

        cost1 = 100000*ate+100000;
        cost2 = 100000*sie+100000;
        cost3 = 100000*rec+100000;

        Button but1 = (Button) findViewById(R.id.but1);
        Button but2 = (Button) findViewById(R.id.but2);
        Button but3 = (Button) findViewById(R.id.but3);
        Button but4 = (Button) findViewById(R.id.but4);

        TextView tv10 = (TextView) findViewById(R.id.tv10);
        TextView tv11 = (TextView) findViewById(R.id.tv11);
        TextView tv12 = (TextView) findViewById(R.id.tv12);
        TextView tv13 = (TextView) findViewById(R.id.tv13);
        TextView tv14 = (TextView) findViewById(R.id.tv14);
        TextView tv15 = (TextView) findViewById(R.id.tv15);
        TextView tv16 = (TextView) findViewById(R.id.tv16);
        TextView tv17 = (TextView) findViewById(R.id.tv17);
        TextView tv18 = (TextView) findViewById(R.id.tv18);

        ImageView im1 = (ImageView) findViewById(R.id.workshop);
        ImageView im2 = (ImageView) findViewById(R.id.headq);
        ImageView im3 = (ImageView) findViewById(R.id.rd);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(String.valueOf(ate));

        up = MediaPlayer.create(this,R.raw.caisse);
        bu = MediaPlayer.create(this,R.raw.bouton);

        TextView tv2 = (TextView) findViewById(R.id.tv2);
        if(ate==0){
            tv2.setText(R.string.ydh1);
            but1.setText(R.string.build);
        }else if(ate<10){
            tv2.setText(R.string.at1);
            im1.setImageResource(R.drawable.cabanelap);
        }else if(ate>9 && ate<20){
            tv2.setText(R.string.at2);
            im1.setImageResource(R.drawable.chalet);
        }else if(ate>19 && ate<30){
            tv2.setText(R.string.at3);
            im1.setImageResource(R.drawable.boathouse);
        }else if(ate>29 && ate<40){
            tv2.setText(R.string.at4);
            im1.setImageResource(R.drawable.entrep);
        }else if(ate>39 && ate<50){
            tv2.setText(R.string.at5);
            im1.setImageResource(R.drawable.batindustriel);
        }else if(ate>49 && ate<60){
            tv2.setText(R.string.at6);
            im1.setImageResource(R.drawable.usine);
        }else if(ate>59 && ate<70){
            tv2.setText(R.string.at7);
            im1.setImageResource(R.drawable.usine);
        }else if(ate>69 && ate<80){
            tv2.setText(R.string.at8);
            im1.setImageResource(R.drawable.constusine);
        }else if(ate>79 && ate<90){
            tv2.setText(R.string.at9);
            im1.setImageResource(R.drawable.delochine);
        }else{
            tv2.setText(R.string.at10);
            im1.setImageResource(R.drawable.empire);
        }

        TextView tv3 = (TextView) findViewById(R.id.tv3);
        tv3.setText(String.valueOf(cost1));

        TextView tv4 = (TextView) findViewById(R.id.tv4);
        tv4.setText(String.valueOf(sie));

        TextView tv5 = (TextView) findViewById(R.id.tv5);
        if(sie==0){
            tv5.setText(R.string.ydh3);
            but2.setText(R.string.build);
        }else if(sie<10){
            tv5.setText(R.string.s1);
            im2.setImageResource(R.drawable.cloisons);
        }else if(sie>9 && sie<20){
            tv5.setText(R.string.s2);
            im2.setImageResource(R.drawable.cabanechantier);
        }else if(sie>19 && sie<30){
            tv5.setText(R.string.s3);
            im2.setImageResource(R.drawable.bureau);
        }else if(sie>29 && sie<40){
            tv5.setText(R.string.s4);
            im2.setImageResource(R.drawable.hantee);
        }else if(sie>39 && sie<50){
            tv5.setText(R.string.s5);
            im2.setImageResource(R.drawable.incubator);
        }else if(sie>49 && sie<60){
            tv5.setText(R.string.s6);
            im2.setImageResource(R.drawable.batiment);
        }else if(sie>59 && sie<70){
            tv5.setText(R.string.s7);
            im2.setImageResource(R.drawable.batiment);
        }else if(sie>69 && sie<80){
            tv5.setText(R.string.s8);
            im2.setImageResource(R.drawable.batimentpisci);
        }else if(sie>79 && sie<90){
            tv5.setText(R.string.s9);
            im2.setImageResource(R.drawable.palace);
        }else{
            tv5.setText(R.string.s10);
            im2.setImageResource(R.drawable.lunar);
        }

        TextView tv6 = (TextView) findViewById(R.id.tv6);
        tv6.setText(String.valueOf(cost2));

        TextView tv7 = (TextView) findViewById(R.id.tv7);
        tv7.setText(String.valueOf(rec));

        TextView tv8 = (TextView) findViewById(R.id.tv8);
        if(rec==0){
            tv8.setText(R.string.ydh2);
            but3.setText(R.string.build);
        }else if(rec<10){
            tv8.setText(R.string.r1);
            im3.setImageResource(R.drawable.lutin);
        }else if(rec>9 && rec<20){
            tv8.setText(R.string.r2);
            im3.setImageResource(R.drawable.etagere);
        }else if(rec>19 && rec<30){
            tv8.setText(R.string.r3);
            im3.setImageResource(R.drawable.windows);
        }else if(rec>29 && rec<40){
            tv8.setText(R.string.r4);
            im3.setImageResource(R.drawable.biblio);
        }else if(rec>39 && rec<50){
            tv8.setText(R.string.r5);
            im3.setImageResource(R.drawable.salleinfo);
        }else if(rec>49 && rec<60){
            tv8.setText(R.string.r6);
            im3.setImageResource(R.drawable.centrerd);
        }else if(rec>59 && rec<70){
            tv8.setText(R.string.r7);
            im3.setImageResource(R.drawable.centrerd);
        }else if(rec>69 && rec<80){
            tv8.setText(R.string.r8);
            im3.setImageResource(R.drawable.labo);
        }else if(rec>79 && rec<90){
            tv8.setText(R.string.r9);
            im3.setImageResource(R.drawable.rd);
        }else{
            tv8.setText(R.string.r10);
            im3.setImageResource(R.drawable.rd);
        }

        TextView tv9 = (TextView) findViewById(R.id.tv9);
        tv9.setText(String.valueOf(cost3));

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
        setFont(tv15,"ChiselMark.ttf");
        setFont(tv16,"ChiselMark.ttf");
        setFont(tv17,"ChiselMark.ttf");
        setFont(tv18,"ChiselMark.ttf");

        if(cost1>bud){
            but1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Toast.makeText(v.getContext(),
                            R.string.budgetInsu, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }else{
            but1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    ate+=1;
                    up.start();
                    SharedPreferences.Editor editor1 = atelier.edit();
                    editor1.putInt("atelier",ate);
                    editor1.apply();

                    SharedPreferences.Editor editor2 = budg.edit();
                    editor2.putInt("budget",bud-cost1);
                    editor2.apply();

                    Toast.makeText(v.getContext(),
                            R.string.ateP, Toast.LENGTH_SHORT)
                            .show();

                    Intent intent1 = new Intent(Infrastructures.this,MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
            });
        }

        if(cost2>bud){
            but2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Toast.makeText(v.getContext(),
                            R.string.budgetInsu, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }else{
            but2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    sie+=1;
                    up.start();
                    SharedPreferences.Editor editor1 = siege.edit();
                    editor1.putInt("siege",sie);
                    editor1.apply();

                    SharedPreferences.Editor editor3 = reputation.edit();
                    editor3.putInt("reput",rep+2);
                    editor3.apply();

                    SharedPreferences.Editor editor2 = budg.edit();
                    editor2.putInt("budget",bud-cost2);
                    editor2.apply();

                    Toast.makeText(v.getContext(),
                            R.string.siegeP, Toast.LENGTH_SHORT)
                            .show();

                    Intent intent1 = new Intent(Infrastructures.this,MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
            });
        }

        if(cost3>bud){
            but3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Toast.makeText(v.getContext(),
                            R.string.budgetInsu, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }else{
            but3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    rec+=1;
                    up.start();
                    SharedPreferences.Editor editor1 = rd.edit();
                    editor1.putInt("rd",rec);
                    editor1.apply();

                    SharedPreferences.Editor editor2 = budg.edit();
                    editor2.putInt("budget",bud-cost3);
                    editor2.apply();

                    Toast.makeText(v.getContext(),
                            R.string.rdP, Toast.LENGTH_SHORT)
                            .show();

                    Intent intent1 = new Intent(Infrastructures.this,MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
            });
        }

        but4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                bu.start();
                Intent truc = new Intent(Infrastructures.this,MainActivity.class);
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
