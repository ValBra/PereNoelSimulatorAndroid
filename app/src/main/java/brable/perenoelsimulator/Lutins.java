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
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static brable.perenoelsimulator.Menu.snow;
import static brable.perenoelsimulator.Menu.startMusic;
import static brable.perenoelsimulator.Partie.PREFS1;
import static brable.perenoelsimulator.Partie.PREFS10;
import static brable.perenoelsimulator.Partie.PREFS11;
import static brable.perenoelsimulator.Partie.PREFS14;
import static brable.perenoelsimulator.Partie.PREFS2;
import static brable.perenoelsimulator.Partie.PREFS20;
import static brable.perenoelsimulator.Partie.PREFS23;
import static brable.perenoelsimulator.Partie.PREFS3;
import static brable.perenoelsimulator.Partie.PREFS5;
import static brable.perenoelsimulator.Partie.PREFS6;
import static brable.perenoelsimulator.Partie.PREFS9;
import static brable.perenoelsimulator.Partie.atelier;
import static brable.perenoelsimulator.Partie.budg;
import static brable.perenoelsimulator.Partie.cadeau;
import static brable.perenoelsimulator.Partie.compteJours;
import static brable.perenoelsimulator.Partie.day;
import static brable.perenoelsimulator.Partie.greve;
import static brable.perenoelsimulator.Partie.livreurs;
import static brable.perenoelsimulator.Partie.lutins;
import static brable.perenoelsimulator.Partie.motiv;
import static brable.perenoelsimulator.Partie.rennes;
import static brable.perenoelsimulator.Partie.salaires;
import static brable.perenoelsimulator.Partie.toShow;

/**
 * Created by BRABLE on 7/26/2017.
 */

public class Lutins extends AppCompatActivity {

    int lut,sal,mot,bud,com,cad,ate,liv,ren,gre;
    private AdView adv;
    MediaPlayer bu;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lutins);
        MobileAds.initialize(this,"ca-app-pub-8018946824008626/4792111897");

        startMusic();

        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        salaires = getBaseContext().getSharedPreferences(PREFS6,MODE_PRIVATE);
        motiv = getBaseContext().getSharedPreferences(PREFS10,MODE_PRIVATE);
        lutins = getBaseContext().getSharedPreferences(PREFS5,MODE_PRIVATE);
        budg = getBaseContext().getSharedPreferences(PREFS1,MODE_PRIVATE);
        compteJours = getBaseContext().getSharedPreferences(PREFS9,MODE_PRIVATE);
        cadeau = getBaseContext().getSharedPreferences(PREFS2,MODE_PRIVATE);
        atelier = getBaseContext().getSharedPreferences(PREFS11,MODE_PRIVATE);
        livreurs = getBaseContext().getSharedPreferences(PREFS14,MODE_PRIVATE);
        rennes = getBaseContext().getSharedPreferences(PREFS20,MODE_PRIVATE);
        greve = getBaseContext().getSharedPreferences(PREFS23,MODE_PRIVATE);

        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        mot = motiv.getInt(PREFS10,MODE_PRIVATE);
        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        sal = salaires.getInt(PREFS6,MODE_PRIVATE);
        bud = budg.getInt(PREFS1,MODE_PRIVATE);
        com = compteJours.getInt(PREFS9,MODE_PRIVATE);
        cad = cadeau.getInt(PREFS2,MODE_PRIVATE);
        ate = atelier.getInt(PREFS11,MODE_PRIVATE);
        liv = livreurs.getInt(PREFS14,MODE_PRIVATE);
        ren = rennes.getInt(PREFS20,MODE_PRIVATE);
        gre = greve.getInt(PREFS23,MODE_PRIVATE);

        TextView textView1 = (TextView) findViewById(R.id.textLut1);
        textView1.setText(String.valueOf(lut));
        TextView textView2 = (TextView) findViewById(R.id.textLut2);
        textView2.setText(String.valueOf(sal));
        TextView textView3 = (TextView) findViewById(R.id.textLut3);
        textView3.setText(String.valueOf(mot));
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView gob = (TextView) findViewById(R.id.gob);
        if(lut==0){
            textView2.setText("");
            textView3.setText("");
            tv1.setText("");
            tv2.setText("");
        }
        TextView textView4 = (TextView) findViewById(R.id.textLut4);
        if(gre==1){
            textView4.setText(R.string.lutinsengrev);
        }

        setFont(gob,"ChiselMark.ttf");
        setFont(tv1,"ChiselMark.ttf");
        setFont(tv2,"ChiselMark.ttf");
        setFont(textView1,"ChiselMark.ttf");
        setFont(textView2,"ChiselMark.ttf");
        setFont(textView3,"ChiselMark.ttf");
        setFont(textView4,"ChiselMark.ttf");

        Button button1 = (Button) findViewById(R.id.but1);
        Button button2 = (Button) findViewById(R.id.but2);
        Button button3 = (Button) findViewById(R.id.but3);
        Button button4 = (Button) findViewById(R.id.but4);

        bu = MediaPlayer.create(this,R.raw.bouton);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                setContentView(R.layout.hire);

                adv = (AdView) findViewById(R.id.adV1);
                AdRequest adr = new AdRequest.Builder().build();
                adv.loadAd(adr);

                TextView tv1 = (TextView) findViewById(R.id.tv1);
                tv1.setText(R.string.combien1);
                setFont(tv1,"ChiselMark.ttf");

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
                            lut+=adL;

                            SharedPreferences.Editor editor = lutins.edit();
                            editor.putInt("lutins",lut);
                            editor.apply();

                            Toast.makeText(v.getContext(),
                                    R.string.toastEmb, Toast.LENGTH_SHORT)
                                    .show();

                            Intent intent1 = new Intent(Lutins.this,MainActivity.class);
                            startActivity(intent1);
                            finish();
                        }
                    }
                });
            }
        });

        if(lut==0){
            button2.setEnabled(false);
        }
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                setContentView(R.layout.hire);

                adv = (AdView) findViewById(R.id.adV1);
                AdRequest adr = new AdRequest.Builder().build();
                adv.loadAd(adr);

                TextView tv1 = (TextView) findViewById(R.id.tv1);
                tv1.setText(R.string.combien2);
                setFont(tv1,"ChiselMark.ttf");

                EditText et1 = (EditText) findViewById(R.id.editText);
                et1.setText("0");

                Button button4 = (Button) findViewById(R.id.but4);
                button4.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        bu.start();
                        //TextView tv1 = (TextView) findViewById(R.id.tv1);
                        EditText et1 = (EditText) findViewById(R.id.editText);
                        if(et1.getText().toString().isEmpty()){
                            Toast.makeText(v.getContext(),
                                    R.string.invalide, Toast.LENGTH_SHORT)
                                    .show();
                        }else{
                            String value = et1.getText().toString();
                            int adL = Integer.parseInt(value);
                            if(adL>lut){
                                Toast.makeText(v.getContext(),
                                        R.string.vnpp, Toast.LENGTH_SHORT)
                                        .show();
                            }else{
                                lut-=adL;
                                SharedPreferences.Editor editor = lutins.edit();
                                editor.putInt("lutins",lut);
                                editor.apply();

                                Toast.makeText(v.getContext(),
                                        R.string.toastVir, Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent1 = new Intent(Lutins.this,MainActivity.class);
                                startActivity(intent1);
                                finish();
                            }
                        }
                    }
                });
            }
        });

        if(lut==0){
            button3.setEnabled(false);
        }
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                setContentView(R.layout.hire);
                ScrollView sv3=(ScrollView)findViewById(R.id.sv3);
                sv3.setBackgroundResource(R.drawable.luge);
                TextView tv0=(TextView)findViewById(R.id.tv);
                TextView tv1=(TextView)findViewById(R.id.tv1);
                tv0.setBackgroundColor(getResources().getColor(R.color.sweetBlue));
                tv1.setBackgroundColor(getResources().getColor(R.color.sweetBlue));
                adv = (AdView) findViewById(R.id.adV1);
                AdRequest adr = new AdRequest.Builder().build();
                adv.loadAd(adr);

                tv1.setText(R.string.modifSal);
                setFont(tv1,"ChiselMark.ttf");

                EditText et1 = (EditText) findViewById(R.id.editText);
                et1.setText(String.valueOf(sal));

                Button button4 = (Button) findViewById(R.id.but4);
                button4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        bu.start();
                        EditText et1 = (EditText) findViewById(R.id.editText);
                        if(et1.getText().toString().isEmpty()){
                            Toast.makeText(v.getContext(),
                                    R.string.invalide, Toast.LENGTH_SHORT)
                                    .show();
                        }else{
                            String value = et1.getText().toString();
                            int adL = Integer.parseInt(value);
                            if(adL<30){
                                Toast.makeText(v.getContext(),
                                        R.string.salBas, Toast.LENGTH_SHORT)
                                        .show();
                            }else{
                                if(adL>sal && mot<96){
                                    SharedPreferences.Editor editor2 = motiv.edit();
                                    editor2.putInt("motiv",mot+5);
                                    editor2.apply();
                                    if(gre==1 && mot>=30){
                                        SharedPreferences.Editor edi = greve.edit();
                                        edi.putInt("greve",0);
                                        edi.apply();
                                        SharedPreferences.Editor to = toShow.edit();
                                        to.putInt("toShow",1);
                                        to.apply();
                                        /*new AlertDialog.Builder(Lutins.this)
                                                .setTitle(R.string.grevend)
                                                .setMessage(R.string.grevend)
                                                .setPositiveButton(R.string.ok,null)
                                                .show();*/
                                    }

                                }else if (adL<sal && mot>4){
                                    SharedPreferences.Editor editor2 = motiv.edit();
                                    editor2.putInt("motiv",mot-5);
                                    editor2.apply();
                                    if(mot<30){
                                        SharedPreferences.Editor edi = greve.edit();
                                        edi.putInt("greve",1);
                                        edi.apply();
                                        SharedPreferences.Editor to = toShow.edit();
                                        to.putInt("toShow",1);
                                        to.apply();
                                        /*new AlertDialog.Builder(Lutins.this)
                                                .setTitle(R.string.warning)
                                                .setMessage(R.string.greve)
                                                .setPositiveButton(R.string.ok,null)
                                                .show();*/
                                    }
                                }
                                sal=adL;
                                SharedPreferences.Editor editor = salaires.edit();
                                editor.putInt("salaires",sal);
                                editor.apply();

                                Toast.makeText(v.getContext(),
                                        R.string.toastSal, Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent1 = new Intent(Lutins.this,MainActivity.class);
                                startActivity(intent1);
                                finish();
                            }
                        }
                    }
                });
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                bu.start();
                Intent truc = new Intent(Lutins.this,MainActivity.class);
                int jou = day.getInt(PREFS3,MODE_PRIVATE);

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
