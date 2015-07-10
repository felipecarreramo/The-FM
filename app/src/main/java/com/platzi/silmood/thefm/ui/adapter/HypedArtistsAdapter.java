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

import java.util.ArrayList;

/**
 * Created by FelipeCarrera on 9/07/15.
 */
public class HypedArtistsAdapter  extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistViewHolder> {

    private Context context;
    private ArrayList<Artist> artists;


    public HypedArtistsAdapter( Context context) {
        this.context = context;
        this. artists = new ArrayList<>();
    }


    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(this.context).
                inflate(R.layout.item_hyped_artists, parent, false);


        return new HypedArtistViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {

        Artist art = this.artists.get(position);
        holder.setArtistName(art.getName());


    }

    @Override
    public int getItemCount() {
        return this.artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists){

        if (artists == null)
            throw new NullPointerException("The items cannot be null");

        this.artists.addAll(artists);
        //notifyItemRangeInserted(getItemCount() - 1, artists.size());
        notifyDataSetChanged();

    }

    public class HypedArtistViewHolder extends RecyclerView.ViewHolder{

        TextView artistName;
        ImageView artistImage;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            this.artistName = (TextView) itemView.findViewById(R.id.txt_name);
            this.artistImage = (ImageView) itemView.findViewById(R.id.img_artist);

        }

        public void setArtistName(String name){
            this.artistName.setText(name);
        }
    }

}
