package com.practice.quotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder> {

    List<Quote> quotes;

    public QuotesAdapter(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        holder.bindView(quotes.get(position));
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    class QuoteViewHolder extends RecyclerView.ViewHolder {

        TextView tvQuote, tvAuthor;

        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuote = itemView.findViewById(R.id.tvQuote);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
        }

        public void bindView(Quote quote) {
            tvQuote.setText(quote.getQuote());
            tvAuthor.setText(quote.getAuthor());
        }
    }
}
