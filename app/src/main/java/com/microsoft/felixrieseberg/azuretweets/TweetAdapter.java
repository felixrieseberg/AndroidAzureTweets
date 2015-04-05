package com.microsoft.felixrieseberg.azuretweets;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class TweetAdapter extends ArrayAdapter<Tweet> {

    public TweetAdapter(Context context, ArrayList<Tweet> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet, parent, false);
        }

        // Lookup View for Data Population
        TextView tweetText = (TextView) convertView.findViewById(R.id.tweetText);
        TextView authorText = (TextView) convertView.findViewById(R.id.authorText);

        // Set Tweet and Author
        tweetText.setText(tweet.text);
        authorText.setText(tweet.author);

        return convertView;
    }
}