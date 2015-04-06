package com.microsoft.felixrieseberg.azuretweets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        TextView timestampText = (TextView) convertView.findViewById(R.id.timeText);
        ImageView avatarImage = (ImageView) convertView.findViewById(R.id.avatar);

        // Set Tweet, Author and Timestamp
        tweetText.setText(tweet.text);
        authorText.setText(tweet.author);
        timestampText.setText(tweet.timestamp);

        // Set Avatar
        String avatarUrl;

        if (IsEmail(tweet.author)) {
            avatarUrl = Gravatar.getAvatarURL(tweet.author);
        } else {
            avatarUrl = "http://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?f=y&d=retro";
        }
        try {
            Picasso.with(avatarImage.getContext()).load(avatarUrl).into(avatarImage);
        } catch (Exception e) {

        }

        return convertView;
    }

    /**
     * Checks if a string is an email.
     * @param email
     * @return
     */
    public static boolean IsEmail(String email) {
        if (email == null || email == "") {
            return false;
        }

        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);

        if (mat.matches()){
            return true;
        } else {
            return false;
        }
    }
}