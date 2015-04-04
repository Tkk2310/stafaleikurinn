package is.lokaverkefni.tomas.virkni;

import android.media.Image;
import android.media.SoundPool;

import java.util.Random;

/**
 * Created by Tommi on 3.4.2015.
 */
public class Leikurinn {

    private Hlutur hluturIGangi;
    private Hlutur[] stafirnir;
    private Hlutur[] hlutir;

    public Leikurinn(Hlutur[] s, Hlutur[] h)
    {
        stafirnir = s;
        hlutir = h;
    }

    public Hlutur getNuveradni()
    {
        return hluturIGangi;
    }

    public Boolean rightGuess(Hlutur gisk)
    {
        return hluturIGangi.getStafurinn() == gisk.getStafurinn();
    }

    public void startRound(Boolean stafaLeikur)
    {
        Random rand = new Random();
        if (stafaLeikur) {
            int visir = rand.nextInt(stafirnir.length);
            hluturIGangi = stafirnir[visir];
        }
        else
        {
            int visir = rand.nextInt(hlutir.length);
            hluturIGangi = hlutir[visir];
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
                hlutir = stokka(hlutir);
                if (i==rett)
                    svor[i] = faRettSvar(hlutir);
                else
                    svor[i] = faRangtSvar(hlutir);

            }
        }
        else
        {
            for (int i=0; i<svor.length; i++)
            {
                stafirnir = stokka(stafirnir);
                if (i==rett)
                    svor[i] = faRettSvar(stafirnir);
                else
                    svor[i] = faRangtSvar(stafirnir);
            }
        }
        return svor;
    }

    private Hlutur[] stokka(Hlutur[] array)
    {
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            Hlutur temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    private Hlutur faRettSvar(Hlutur[] array)
    {
        Hlutur skil = null;
        for (int i = 0; i<array.length ;i++)
        {
            if (hluturIGangi.getStafurinn() == array[i].getStafurinn()){
                skil = array[i];
                break;
            }

        }
        return skil;
    }

    private Hlutur faRangtSvar(Hlutur[] array)
    {
        Hlutur skil = null;
        for (int i = 0; i<array.length ;i++)
        {
            if (hluturIGangi.getStafurinn() != array[i].getStafurinn())
            {
                skil = array[i];
                break;
            }
        }
        return skil;
    }


}