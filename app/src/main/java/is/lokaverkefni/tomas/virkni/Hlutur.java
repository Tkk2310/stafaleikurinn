package is.lokaverkefni.tomas.virkni;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.SoundPool;

/**
 * Created by Tommi on 3.4.2015.
 */
public class Hlutur {
    private char stafurinn;
    private Drawable myndin;
    private SoundPool hljodid;
    private String name;

    public void setStafurinn(char stafur)
    {
        stafurinn = stafur;
    }

    public void setMyndin(Drawable mynd)
    {
        myndin = mynd;
    }

    public void setHljod(SoundPool hljod)
    {
        hljodid = hljod;
    }

    public void setName(String n)
    {
        name = n;
    }

    public char getStafurinn()
    {
        return stafurinn;
    }

    public Drawable getMyndin()
    {
        return myndin;
    }

    public SoundPool getHljodid()
    {
        return hljodid;
    }
}
