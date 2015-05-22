package is.lokaverkefni.tomas.virkni;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.SoundPool;
import android.content.res.Resources;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import is.lokaverkefni.tomas.stafaleikurinn.R;

/**
 * Created by Tommi on 3.4.2015.
 */
public class Leikurinn {

    private Hlutur hluturIGangi;
    private ArrayList<Hlutur> stafirnir;
    private  ArrayList<Hlutur> hlutir;
    private Context context;

    private String[] stafrof;
    private String[] stuff = {"api", "batur", "hundur", "dropi", "gormur"};

    public Leikurinn(Context c)
    {
        context = c;
        stafirnir = new ArrayList<Hlutur>();
        hlutir = new ArrayList<Hlutur>();
        fillaStafi();
        fyllaHluti();
    }

    public Hlutur getNuveradni()
    {
        return hluturIGangi;
    }
        

    private void fillaStafi()
    {

        stafrof = context.getResources().getStringArray(R.array.Stafrof);
        for (int i =0; i<stafrof.length; i++)
        {
            Hlutur temp = new Hlutur();
            if(stafrof[i].equals("aa"))
            {
                temp.setStafurinn('á');
                temp.setName("á");
            }
            else if (stafrof[i].equals( "dd"))
            {
                temp.setStafurinn('ð');
                temp.setName("ð");
                Log.d("hvadaStafurKemur",Character.toString(temp.getStafurinn()));

            }
            else if (stafrof[i].equals( "ee"))
            {
                temp.setStafurinn('é');
                temp.setName("é");

            }
            else
            {
                temp.setStafurinn(stafrof[i].charAt(0));
                temp.setName(stafrof[i]);

            }

            Drawable drawable = context.getResources().getDrawable(context.getResources()
                    .getIdentifier("stafur_"+stafrof[i], "drawable", context.getPackageName()));
            temp.setMyndin(drawable);


            stafirnir.add(temp);

        }

    }

    private void fyllaHluti()
    {
        for (int i =0; i<stuff.length; i++)
        {
            Hlutur temp = new Hlutur();
            String check = stuff[i].substring(0,2);
            if (check.equals("aa"))
            {
                temp.setStafurinn('á');
            }
            else if (check.equals('ð'))
            {
                temp.setStafurinn(stuff[i].charAt(0));
            }
            else if (check.equals('é'))
            {
                temp.setStafurinn(stuff[i].charAt(0));
            }
            else
            {
                temp.setStafurinn(stuff[i].charAt(0));
            }
            temp.setName(stuff[i]);
            Drawable drawable = context.getResources().getDrawable(context.getResources()
                    .getIdentifier("hlutur_"+stuff[i], "drawable", context.getPackageName()));
            temp.setMyndin(drawable);

            hlutir.add(temp);

        }
    }

    public Boolean rightGuess(Hlutur gisk)
    {
        return hluturIGangi.getStafurinn() == gisk.getStafurinn();
    }

    public void startRound(Boolean stafaLeikur)
    {
        Random rand = new Random();
        if (stafaLeikur) {
            int visir = rand.nextInt(stafirnir.size());
            hluturIGangi = stafirnir.get(visir);

        }
        else
        {
            int visir = rand.nextInt(hlutir.size());
            hluturIGangi = hlutir.get(visir);
        }
    }

    public Hlutur[] faSvor(Boolean stafaLeikur)
    {
        Hlutur[] svor = new Hlutur[4];
        Random rand = new Random();
        int rett = rand.nextInt(svor.length);
        if (stafaLeikur)
        {
            for (int i=0; i<svor.length; i++)
            {
                Collections.shuffle(hlutir);
                if (i==rett)
                    svor[i] = faRettSvar(hlutir);
                else
                    svor[i] = faRangtSvar(hlutir,svor);

            }
        }
        else
        {
            for (int i=0; i<svor.length; i++)
            {
                Collections.shuffle(stafirnir);
                if (i==rett)
                    svor[i] = faRettSvar(stafirnir);
                else
                    svor[i] = faRangtSvar(stafirnir,svor);
            }
        }
        return svor;
    }

    private boolean isIn(Hlutur[] array, Hlutur check)
    {
        boolean isIn = false;
        if (array.length > 1) {
            for (int i = 0; i < array.length; i++) {

                if (array[i] != null && array[i].getStafurinn() == check.getStafurinn()) {
                    isIn = true;
                    break;
                }
            }
        }
        return isIn;
    }

    private Hlutur faRettSvar(ArrayList<Hlutur> array)
    {
        Hlutur skil = null;
        for (int i = 0; i<array.size() ;i++)
        {
            if (hluturIGangi.getStafurinn() == array.get(i).getStafurinn()){
                skil = array.get(i);
                break;
            }

        }
        return skil;
    }

    private Hlutur faRangtSvar(ArrayList<Hlutur> array, Hlutur[] ofLimmits)
    {
        Hlutur skil = null;
        for (int i = 0; i<array.size() ;i++)
        {
            if (!isIn(ofLimmits,array.get(i))) {
                if (hluturIGangi.getStafurinn() != array.get(i).getStafurinn()) {
                    skil = array.get(i);
                    break;
                }
            }
        }
        return skil;
    }

}