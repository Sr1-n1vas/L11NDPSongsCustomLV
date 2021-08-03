package sg.edu.rp.c346.id20004969.l11ndpsongscustomlv;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> SongList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects)
    {
        super(context,resource,objects);

        this.parent_context = context;
        this.layout_id = resource;
        this.SongList = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        ImageView ivImage = rowView.findViewById(R.id.imageView);
        RatingBar RATING = rowView.findViewById(R.id.ratingBar2);

        // Obtain the Android Version information based on the position
        Song currentSong = SongList.get(position);

        // Set values to the TextView to display the corresponding information

        tvName.setText(currentSong.getTitle());
        tvYear.setText(currentSong.toStringYear());
        RATING.setRating(currentSong.getStars());


        tvSinger.setText(currentSong.getSingers());

        if(currentSong.getYearReleased() >= 2019)
        {
            ivImage.setImageResource(R.drawable.newer);
        }
        else if (currentSong.getYearReleased() < 2019)
        {
            ivImage.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }
}

