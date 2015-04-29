package mx.com.factico.diputinder.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import mx.com.factico.diputinder.R;
import mx.com.factico.diputinder.beans.Diputado;

/**
 * Created by zace3d on 4/27/15.
 */
public class MyArrayAdapter extends ArrayAdapter<Diputado> {
    private final Activity activity;
    private final List<Diputado> values;

    public MyArrayAdapter(Activity activity, List<Diputado> values) {
        super(activity, R.layout.item_diputado, values);
        this.activity = activity;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;

        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_diputado, parent, false);
            holder = new ViewHolder();

            // configure view holder
            holder.name = (TextView) rowView.findViewById(R.id.helloText);

            holder.image = (ImageView) rowView.findViewById(R.id.helloImage);

            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        Diputado bean = getItem(position);
        holder.name.setText(String.format(Locale.getDefault(), "%s %s %s", bean.nombres, bean.apellidoPaterno, bean.apellidoMaterno));
        holder.image.setImageResource(R.drawable.ic_launcher);

        return rowView;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Diputado getItem(int position) {
        return values.get(position);
    }

    static class ViewHolder {
        public TextView name;
        public ImageView image;
    }
}
