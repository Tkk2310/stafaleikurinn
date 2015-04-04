package is.lokaverkefni.tomas.stafaleikurinn;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import is.lokaverkefni.tomas.virkni.Hlutur;
import is.lokaverkefni.tomas.virkni.Leikurinn;


public class Leiksvaedi extends ActionBarActivity {

    public Hlutur[] stafir = new Hlutur[5];
    public Hlutur[] hlutir = new Hlutur[2];
    public Leikurinn leikur;

    String stafrof = "abcde";
    Hlutur[] svor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leiksvaedi);
        fyllaStafi();

        leikur = new Leikurinn(stafir,hlutir);
        nyLota();
    }


    public void nyLota()
    {
        leikur.startRound(false);

        Hlutur current = leikur.getNuveradni();

        ImageView temp = (ImageView) findViewById(R.id.adalMynd);
        temp.setImageDrawable(current.getMyndin());

        svor = leikur.faSvor(false);

        temp = (ImageView) findViewById(R.id.takki1);
        temp.setImageDrawable(svor[0].getMyndin());

        temp = (ImageView) findViewById(R.id.takki1);
        temp.setImageDrawable(svor[0].getMyndin());

        temp = (ImageView) findViewById(R.id.takki2);
        temp.setImageDrawable(svor[1].getMyndin());

        temp = (ImageView) findViewById(R.id.takki3);
        temp.setImageDrawable(svor[2].getMyndin());

        temp = (ImageView) findViewById(R.id.takki4);
        temp.setImageDrawable(svor[3].getMyndin());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leiksvaedi, menu);
        return true;
    }

    public void takki1(View view)
    {
        if (leikur.rightGuess(svor[0]))
            nyLota();
    }

    public void takki2(View view)
    {
        if (leikur.rightGuess(svor[1]))
            nyLota();
    }

    public void takki3(View view)
    {
        if (leikur.rightGuess(svor[2]))
            nyLota();
    }

    public void takki4(View view)
    {
        if (leikur.rightGuess(svor[3]))
            nyLota();
    }

    public void fyllaStafi()
    {
        /*
        for (int i = 0; i<stafrof.length(); i++)
        {
            stafir[i] = new Hlutur():
            stafir[i].setStafurinn(stafrof.charAt(i));
            String bla = "stafur_" + stafrof.charAt(i);
            stafir[i].setMyndin(getResources().getDrawable(R.drawable.bla));
        }
        */
        stafir[0] = new Hlutur();
        stafir[0].setStafurinn(stafrof.charAt(0));
        stafir[0].setMyndin(getResources().getDrawable(R.drawable.stafur_a));

        stafir[1] = new Hlutur();
        stafir[1].setStafurinn(stafrof.charAt(1));
        stafir[1].setMyndin(getResources().getDrawable(R.drawable.stafur_b));

        stafir[2] = new Hlutur();
        stafir[2].setStafurinn(stafrof.charAt(2));
        stafir[2].setMyndin(getResources().getDrawable(R.drawable.stafur_c));

        stafir[3] = new Hlutur();
        stafir[3].setStafurinn(stafrof.charAt(3));
        stafir[3].setMyndin(getResources().getDrawable(R.drawable.stafur_d));

        stafir[4] = new Hlutur();
        stafir[4].setStafurinn(stafrof.charAt(4));
        stafir[4].setMyndin(getResources().getDrawable(R.drawable.stafur_e));

        hlutir[0] = new Hlutur();
        hlutir[0].setStafurinn('a');
        hlutir[0].setMyndin(getResources().getDrawable(R.drawable.hlutur_api));

        hlutir[1] = new Hlutur();
        hlutir[1].setStafurinn('b');
        hlutir[1].setMyndin(getResources().getDrawable(R.drawable.hlutur_batur));

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
