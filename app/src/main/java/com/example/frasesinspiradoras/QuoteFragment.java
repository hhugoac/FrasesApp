package com.example.frasesinspiradoras;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class QuoteFragment extends Fragment {



    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View quoteView = inflater.inflate(R.layout.fragment_quote,container,false);

        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardView);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[]= new int[]{ R.color.purple_100,R.color.primary,R.color.red_100,
                R.color.green_600,R.color.orange_500};

        quoteText.setText(quote);
        byAuthor.setText("-"+author);

        cardView.setBackgroundResource(getRandomQuote(colors));
        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote",quote);
        bundle.putString("author",author);
        fragment.setArguments(bundle);

        return fragment;
    }

    int getRandomQuote(int[] colorArray){
        int color;
        int quotesArrayLen= colorArray.length;


        int randomNum = (int) (Math.random()*quotesArrayLen-1);

        color = colorArray[randomNum];
        return color;
    }
}
