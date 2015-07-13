package com.platzi.silmood.thefm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.silmood.thefm.R;
import com.platzi.silmood.thefm.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Felipe Carrera on 13/07/15.
 */
public class TopArtistsAdapter extends RecyclerView.Adapter<TopArtistsAdapter.TopArtistViewHolder> {

    private Context context;
    private ArrayList<Artist> artists;


    public TopArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }


    @Override
    public TopArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.context).
                inflate(R.layout.item_top_artists, parent, false);


        return new TopArtistsAdapter.TopArtistViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(TopArtistViewHolder holder, int position) {

        Artist art = this.artists.get(position);
        holder.setArtistName(art.getName());
        holder.setArtistPlaycount(art.getPlaycount());
        holder.setArtistListeners(art.getListeners());
        if (art.getUrlMediumImage() != null)
            holder.setArtistImage(art.getUrlMediumImage());
        else
            holder.setArtistDefaultImage();
    }

    @Override
    public int getItemCount() {
        return this.artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists) {

        if (artists == null)
            throw new NullPointerException("The items cannot be null");

        this.artists.addAll(artists);
        //notifyItemRangeInserted(getItemCount() - 1, artists.size());
        notifyDataSetChanged();

    }

    public class TopArtistViewHolder extends RecyclerView.ViewHolder {

        TextView artistName;
        TextView artistPlaycount;
        TextView artistListeners;
        ImageView artistImage;

        public TopArtistViewHolder(View itemView) {
            super(itemView);

            this.artistName = (TextView) itemView.findViewById(R.id.txt_name);
            this.artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
            this.artistPlaycount = (TextView) itemView.findViewById(R.id.txt_playcount);
            this.artistListeners = (TextView) itemView.findViewById(R.id.txt_listeners);

        }

        public void setArtistName(String name) {
            this.artistName.setText(name);
        }

        public void setArtistPlaycount(String playcount) {
            artistPlaycount.setText(playcount);
        }

        public void setArtistListeners(String listeners) {
            artistListeners.setText(listeners);

        }


        public void setArtistImage(String url) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.artist_placeholder)
                    .into(artistImage);
        }

        public void setArtistDefaultImage() {
            Picasso.with(context)
                    .load(R.drawable.artist_placeholder)
                    .into(artistImage);
        }

    }

}


