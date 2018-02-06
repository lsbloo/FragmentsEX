package com.example.osvaldoairon.fragmentsactionbar;

/**
 * Created by osvaldoairon on 06/02/18.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HotelListFragment extends ListFragment{
    List<Hotel> hoteis;
    ArrayAdapter<Hotel> hotelAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hoteis = carregarHoteis();
        hotelAdapter = new ArrayAdapter<Hotel>(getActivity(),android.R.layout.simple_list_item_1,hoteis);

        setListAdapter(hotelAdapter);
    }
    private List<Hotel> carregarHoteis(){
        List<Hotel> hotels = new ArrayList<Hotel>();

        hotels.add(new Hotel("Hotel brasil", "Pedra",4.5f));
        hotels.add(new Hotel("Hotel brasil", "Pedra",4.5f));
        hotels.add(new Hotel("Hotel brasil", "Pedra",4.5f));
        hotels.add(new Hotel("Hotel brasil", "Pedra",4.5f));
        hotels.add(new Hotel("Hotel brasil", "Pedra",4.5f));

        return hotels;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Activity act = getActivity();

        if(act instanceof AoClicarNoHotel){
            Hotel hotel = (Hotel)l.getItemAtPosition(position);

            AoClicarNoHotel listener = (AoClicarNoHotel)act;
            listener.clicouNoHotel(hotel);
        }
    }


    public interface AoClicarNoHotel{
        void clicouNoHotel(Hotel hotel);
    }

}
