package is.lokaverkefni.tomas.stafaleikurinn;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import is.lokaverkefni.tomas.virkni.Adapter;
import is.lokaverkefni.tomas.virkni.Hlutur;
import is.lokaverkefni.tomas.virkni.Leikurinn;


public class stafrof extends ActionBarActivity {


    Leikurinn Leikur;
    ArrayList<Hlutur> stafrof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafrof);

        Leikur = new Leikurinn(this);
        stafrof = Leikur.getStafir();

        setUp();

    }

    private void setUp()
    {
        GridView gridview = (GridView) findViewById(R.id.gridview);

        gridview.setAdapter(new Adapter(this,stafrof));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(stafrof.this, "" + stafrof.get(position).getStafurinn(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stafrof, menu);
        return true;
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
