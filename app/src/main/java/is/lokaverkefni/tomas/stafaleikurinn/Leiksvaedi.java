package is.lokaverkefni.tomas.stafaleikurinn;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

import is.lokaverkefni.tomas.virkni.Hlutur;
import is.lokaverkefni.tomas.virkni.Leikurinn;


public class Leiksvaedi extends ActionBarActivity {

    public Leikurinn leikur;

    Hlutur[] svor;

    MediaPlayer mp;

    boolean stafaleikur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leiksvaedi);
        stafaleikur = getIntent().getExtras().getBoolean("stafaleikur");
        mp = new MediaPlayer();
        leikur = new Leikurinn(this);
        nyLota();
    }


    public void nyLota()
    {
        leikur.startRound(stafaleikur);

        Hlutur current = leikur.getNuveradni();

        ImageView temp = (ImageView) findViewById(R.id.adalMynd);
        temp.setImageDrawable(current.getMyndin());

        svor = leikur.faSvor(stafaleikur);

        temp = (ImageView) findViewById(R.id.takki1);
        temp.setImageDrawable(svor[0].getMyndin());
        temp.setEnabled(true);

        temp = (ImageView) findViewById(R.id.takki1);
        temp.setImageDrawable(svor[0].getMyndin());
        temp.setEnabled(true);

        temp = (ImageView) findViewById(R.id.takki2);
        temp.setImageDrawable(svor[1].getMyndin());
        temp.setEnabled(true);

        temp = (ImageView) findViewById(R.id.takki3);
        temp.setImageDrawable(svor[2].getMyndin());
        temp.setEnabled(true);

        temp = (ImageView) findViewById(R.id.takki4);
        temp.setImageDrawable(svor[3].getMyndin());
        temp.setEnabled(true);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leiksvaedi, menu);
        return true;
    }

    public void takki1(View view)
    {
        try {
            mp.reset();
            AssetFileDescriptor afd;
            afd = getAssets().openFd("test.mp3");
            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (leikur.rightGuess(svor[0]))
        {
            nyLota();


        }
        else
        {
            ImageView temp;
            temp = (ImageView) findViewById(view.getId());
            temp.setImageDrawable(getResources().getDrawable(R.drawable.wronganswer));
            view.setEnabled(false);
        }
    }

    public void takki2(View view)
    {
        if (leikur.rightGuess(svor[1]))
        {
            nyLota();
        }
        else
        {
            ImageView temp;
            temp = (ImageView) findViewById(view.getId());
            temp.setImageDrawable(getResources().getDrawable(R.drawable.wronganswer));
            view.setEnabled(false);
        }
    }

    public void takki3(View view)
    {
        if (leikur.rightGuess(svor[2]))
        {
            nyLota();
        }
        else
        {
            ImageView temp;
            temp = (ImageView) findViewById(view.getId());
            temp.setImageDrawable(getResources().getDrawable(R.drawable.wronganswer));
            view.setEnabled(false);
        }
    }

    public void takki4(View view)
    {
        if (leikur.rightGuess(svor[3]))
        {
            nyLota();
        }
        else
        {
            ImageView temp;
            temp = (ImageView) findViewById(view.getId());
            temp.setImageDrawable(getResources().getDrawable(R.drawable.wronganswer));
            view.setEnabled(false);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
