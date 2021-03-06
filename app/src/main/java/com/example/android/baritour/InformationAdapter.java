package com.example.android.baritour;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InformationAdapter extends ArrayAdapter<Information> {

    public InformationAdapter(Activity context, ArrayList<Information> info) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for multiple Views, the adapter is not
// going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, info);

    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    com.example.android.baritour.R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Information currentInformation = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID list_name
        TextView nameTextView = (TextView) listItemView.findViewById(com.example.android.baritour.R.id.list_name);
        // Get the list namer from the current Information object and
        // set this text on the info TextView
        nameTextView.setText(currentInformation.getName());

        ImageView pictureImageView = (ImageView) listItemView.findViewById(com.example.android.baritour.R.id.list_picture);
        pictureImageView.setImageResource(currentInformation.getPictureId());

        ImageView starsImageView = (ImageView) listItemView.findViewById(com.example.android.baritour.R.id.list_stars);
        if (currentInformation.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            starsImageView.setImageResource(currentInformation.getStars());
            // Make sure the view is visible
            starsImageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            starsImageView.setVisibility(View.GONE);
        }


        return listItemView;
    }

}
