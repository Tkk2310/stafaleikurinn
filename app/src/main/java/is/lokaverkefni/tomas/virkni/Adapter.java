package is.lokaverkefni.tomas.virkni;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Tommi on 23/05/15.
 */
public class Adapter extends BaseAdapter
{
    Context context;
    ArrayList<Hlutur> stafir;

    public Adapter(Context c, ArrayList<Hlutur> s)
    {
        context = c;
        stafir = s;
    }

    @Override
    public int getCount() {
        return stafir.size();
    }

    @Override
    public Object getItem(int position) {
        return stafir.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageDrawable(stafir.get(position).getMyndin());
        return imageView;
    }
}

