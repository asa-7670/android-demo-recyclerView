package com.asa.dices.demorecyclerview;

import android.app.AlertDialog;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private final List<Pair<String, String>> contacts = Arrays.asList (
            Pair.create ( "Cpntact 1","telephone 1" ),
            Pair.create ( "Cpntact 2","telephone 2" ),
            Pair.create ( "Cpntact 3","telephone 3" ),
            Pair.create ( "Cpntact 4","telephone 4" ),
            Pair.create ( "Cpntact 5","telephone 5" ),
            Pair.create ( "Cpntact 6","telephone 6" ),
            Pair.create ( "Cpntact 7","telephone 7" ),
            Pair.create ( "Cpntact 8","telephone 8" ),
            Pair.create ( "Cpntact 9","telephone 9" ),
            Pair.create ( "Cpntact 10","telephone 10" ),
            Pair.create ( "Cpntact 11","telephone 11" ),
            Pair.create ( "Cpntact 12","telephone 12" ),
            Pair.create ( "Cpntact 13","telephone 13" ),
            Pair.create ( "Cpntact 14","telephone 14" ),
            Pair.create ( "Cpntact 10","telephone 15" ),
            Pair.create ( "Cpntact 11","telephone 16" ),
            Pair.create ( "Cpntact 12","telephone 18" ),
            Pair.create ( "Cpntact 13","telephone 19" ),
            Pair.create ( "Cpntact 14","telephone 20" ),
            Pair.create ( "Cpntact 12","telephone 21" ),
            Pair.create ( "Cpntact 13","telephone 22" ),
            Pair.create ( "Cpntact 14","telephone 23" )
    );


    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from ( parent.getContext () );
        View view = inflater.inflate ( R.layout.layout_item, parent, false );
        return new MyViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pair<String, String> pair = contacts.get ( position );
        holder.display(pair);

    }

    @Override
    public int getItemCount() {
        return contacts.size ();
    }

    public  static class MyViewHolder extends  RecyclerView.ViewHolder{

        private TextView contactTxView;
        private TextView telTxView;

        private Pair<String, String> currentPair;

        public MyViewHolder(@NonNull final View itemView) {
            super ( itemView );

            contactTxView = (TextView) itemView.findViewById ( R.id.contactTxView );
            telTxView = (TextView) itemView.findViewById ( R.id.telTxView );
            itemView.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder (itemView.getContext ())
                            .setTitle ( currentPair.first )
                            .setMessage ( currentPair.second )
                            .show ();
                }
            } );
        }

        public void display(Pair<String, String> pair){
            currentPair = pair;
            contactTxView.setText ( pair.first );
            telTxView.setText ( pair.second );
        }
    }
}
