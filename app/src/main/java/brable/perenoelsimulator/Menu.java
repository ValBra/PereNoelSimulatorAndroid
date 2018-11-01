package brable.perenoelsimulator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.security.SecureRandom;
import java.util.Locale;

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
import static brable.perenoelsimulator.Partie.PREFS21;
import static brable.perenoelsimulator.Partie.PREFS22;
import static brable.perenoelsimulator.Partie.PREFS23;
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
import static brable.perenoelsimulator.Partie.exist;
import static brable.perenoelsimulator.Partie.greve;
import static brable.perenoelsimulator.Partie.langue;
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
import static brable.perenoelsimulator.Partie.traineau;
import static brable.perenoelsimulator.Partie.vitesse;
import static brable.perenoelsimulator.R.array.languages;

/**
 * Created by BRABLE on 7/19/2017.
 */

public class Menu extends AppCompatActivity{//implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {

    int noting,jou,bud,lut,ate,sal,liv,ren,cad,com;
    Button bouton2;
    static MediaPlayer snow;
    MediaPlayer bu;
    String[] languages = {"Language","Français","English","Español","Deutsche","Italiano","Português","Dansk","Svenska","Norske","Suomi"};
    int flags[] = {0,R.drawable.gf,R.drawable.gb,R.drawable.es,R.drawable.de,R.drawable.it,R.drawable.pt,R.drawable.dk,R.drawable.se,R.drawable.bv,R.drawable.fi};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        snow = MediaPlayer.create(this,R.raw.magical_snow);
        snow.setLooping(true);
        snow.start();

        bu = MediaPlayer.create(this,R.raw.bouton);

        //Spinner spinnerctrl;
        overridePendingTransition(R.transition.fadein, R.transition.fadeout);
        setContentView(R.layout.menu);

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
        exist = getBaseContext().getSharedPreferences(PREFS21,MODE_PRIVATE);
        note = getBaseContext().getSharedPreferences(PREFS22,MODE_PRIVATE);
        greve = getBaseContext().getSharedPreferences(PREFS23,MODE_PRIVATE);
        int existing = exist.getInt(PREFS21,MODE_PRIVATE);
        if (existing!=1){
            existing=0;
        }
        noting = note.getInt(PREFS22,MODE_PRIVATE);
        if (noting!=1){
            noting=0;
        }

        jou = day.getInt(PREFS3,MODE_PRIVATE);
        bud = budg.getInt(PREFS1,MODE_PRIVATE);
        lut = lutins.getInt(PREFS5,MODE_PRIVATE);
        ate = atelier.getInt(PREFS11,MODE_PRIVATE);
        sal = salaires.getInt(PREFS6,MODE_PRIVATE);
        liv = livreurs.getInt(PREFS14,MODE_PRIVATE);
        ren = rennes.getInt(PREFS20,MODE_PRIVATE);
        cad = cadeau.getInt(PREFS2,MODE_PRIVATE);
        com = compteJours.getInt(PREFS9,MODE_PRIVATE);

        SecureRandom rand = new SecureRandom();
        int random = rand.nextInt(20) +1;
        if(random==20 && noting!=1){
            new AlertDialog.Builder(Menu.this)
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

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        setFont(tv1,"PWHappyChristmas.ttf");

        Button bouton1 = (Button) findViewById(R.id.but1);
        if(existing==1){
            bouton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    new AlertDialog.Builder(Menu.this)
                            .setTitle(R.string.warning)
                            .setMessage(R.string.supprimer)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    initialisation();
                                    Intent intent1 = new Intent(Menu.this,MainActivity.class);
                                    startActivity(intent1);
                                }
                            })
                            .setNegativeButton(R.string.annuler, null)
                            .show();
                }
            });
        }else{
            bouton1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    bu.start();
                    initialisation();
                    Intent intent1 = new Intent(Menu.this,MainActivity.class);
                    startActivity(intent1);
                }
            });
        }

        bouton2 = (Button) findViewById(R.id.but2);
        if(existing==0){
            bouton2.setEnabled(false);
        }else {
            bouton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    bu.start();
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
                    Intent intent2 = new Intent(Menu.this, MainActivity.class);
                    startActivity(intent2);
                }
            });
        }

        Button bouton3 = (Button) findViewById(R.id.but3);
        bouton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bu.start();
                Intent intent3 = new Intent(Menu.this,Credits.class);
                startActivity(intent3);
            }
        });

        ImageButton imb = (ImageButton) findViewById(R.id.imageButton);
        imb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Uri url = Uri.parse("https://www.facebook.com/BrableyApps/");
                Intent intent = new Intent(Intent.ACTION_VIEW,url);
                startActivity(intent);
            }
        });

        Button boutonx4 = (Button) findViewById(R.id.but4);
        boutonx4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=brable.perenoelsimulator");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Spinner spinnerctrl;
        spinnerctrl = (Spinner) findViewById(R.id.Spinner1);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),flags,languages);
        spinnerctrl.setAdapter(customAdapter);

        spinnerctrl.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                if (pos == 1) {
                    Toast.makeText(parent.getContext(),
                            "Baguette !", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("fr");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "fr");
                    editor1.apply();
                } else if (pos == 2) {

                    Toast.makeText(parent.getContext(),
                            "Merry Christmas!", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("en");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "en");
                    editor1.apply();
                } else if (pos==3){
                    Toast.makeText(parent.getContext(),
                            "Feliz Navidad", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("es");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "es");
                    editor1.apply();
                } else if (pos==4){
                    setLocale("de");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "de");
                    editor1.apply();
                } else if(pos==5){
                    setLocale("it");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "it");
                    editor1.apply();
                } else if (pos==6){
                    setLocale("pt");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "pt");
                    editor1.apply();
                } else if (pos==7){
                    setLocale("da");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "da");
                    editor1.apply();
                } else if (pos==8){
                    setLocale("sv");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue", "sv");
                    editor1.apply();
                } else if (pos==9){
                    setLocale("nb");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue","nb");
                    editor1.apply();
                } else if (pos==10){
                    setLocale("fi");
                    SharedPreferences.Editor editor1 = langue.edit();
                    editor1.putString("langue","fi");
                    editor1.apply();
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
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

    public void initialisation(){
        SharedPreferences.Editor editor1 = budg.edit();
        editor1.putInt("budget",0);
        editor1.apply();
        SharedPreferences.Editor editor2 = cadeau.edit();
        editor2.putInt("cadeaux",0);
        editor2.apply();
        SharedPreferences.Editor editor3 = day.edit();
        editor3.putInt("days",364);
        editor3.apply();
        SharedPreferences.Editor editor4 = reputation.edit();
        editor4.putInt("reput",50);
        editor4.apply();
        SharedPreferences.Editor editor6 = pretEnCours.edit();
        editor6.putInt("pretEnCours",0);
        editor6.apply();
        SharedPreferences.Editor editor7 = dettes.edit();
        editor7.putInt("dettes",0);
        editor7.apply();
        SharedPreferences.Editor editor8 = compteJours.edit();
        editor8.putInt("compteJours",0);
        editor8.apply();
        SharedPreferences.Editor editor9 = lutins.edit();
        editor9.putInt("lutins",0);
        editor9.apply();
        SharedPreferences.Editor editor10 = salaires.edit();
        editor10.putInt("salaires",50);
        editor10.apply();
        SharedPreferences.Editor editor11 = motiv.edit();
        editor11.putInt("motiv",50);
        editor11.apply();
        SharedPreferences.Editor editor12 = atelier.edit();
        editor12.putInt("atelier",0);
        editor12.apply();
        SharedPreferences.Editor editor13 = siege.edit();
        editor13.putInt("siege",0);
        editor13.apply();
        SharedPreferences.Editor editor14 = rd.edit();
        editor14.putInt("rd",0);
        editor14.apply();
        SharedPreferences.Editor editor15 = livreurs.edit();
        editor15.putInt("livreurs",0);
        editor15.apply();
        SharedPreferences.Editor editor16 = traineau.edit();
        editor16.putInt("traineau",0);
        editor16.apply();
        SharedPreferences.Editor editor17 = people.edit();
        editor17.putInt("people",2000000000);
        editor17.apply();
        SharedPreferences.Editor editor18 = vitesse.edit();
        editor18.putInt("vitesse",1);
        editor18.apply();
        SharedPreferences.Editor editor19 = contenance.edit();
        editor19.putInt("contenance",1);
        editor19.apply();
        SharedPreferences.Editor editor20 = design.edit();
        editor20.putInt("design",1);
        editor20.apply();
        SharedPreferences.Editor editor21 = rennes.edit();
        editor21.putInt("rennes",0);
        editor21.apply();
        SharedPreferences.Editor editor5 = exist.edit();
        editor5.putInt("exist",1);
        editor5.apply();
        SharedPreferences.Editor editor22 = greve.edit();
        editor22.putInt("greve",0);
        editor22.apply();
        bouton2.setEnabled(true);
    }

    public void setLocale(String lang) {

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, Menu.class);
        startActivity(refresh);
    }

    /*public void onPrepared(MediaPlayer snow){
        snow.start();
        snow.setLooping(true);
    }*/

    public void onPause(){
        super.onPause();
        snow.pause();
    }

    /*public void onStart(){
        super.onStart();
        mGoogleApiClient.connect();
        //api.connect();
    }*/

    /*public void onStop(){
        super.onStop();
        mGoogleApiClient.disconnect();
        //snow.pause();
    }*/

    public void onDestroy(){
        super.onDestroy();
        snow.stop();
    }

    public static void startMusic(){
        snow.start();
        snow.setLooping(true);
    }

    public static void stopMusic(){
        snow.stop();
    }

    public void onResume(){
        super.onResume();
        snow.start();
        snow.setLooping(true);
    }
}