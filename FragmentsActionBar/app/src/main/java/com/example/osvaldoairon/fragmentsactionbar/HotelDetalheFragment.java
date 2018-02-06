package com.example.osvaldoairon.fragmentsactionbar;

/**
 * Created by osvaldoairon on 06/02/18.
 */
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

public class HotelDetalheFragment extends Fragment {
    public static final String TAG_DETALHE="tag_detalhe";
    public static final String EXTRA_HOTEL ="hotel";

    private TextView textNome;
    private TextView txtEndereco;
    private RatingBar estrelas;
    Hotel hotel;

    public static HotelDetalheFragment novaIntancia(Hotel hotel){
        Bundle parametros = new Bundle();
        parametros.putSerializable(EXTRA_HOTEL,hotel);

        HotelDetalheFragment fragment = new HotelDetalheFragment();
        fragment.setArguments(parametros);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotel = (Hotel) getArguments().getSerializable(EXTRA_HOTEL);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detalhe_hotel,container,false);

        textNome = (TextView)layout.findViewById(R.id.txtNome);
        txtEndereco = (TextView)layout.findViewById(R.id.txtEndereco);
        estrelas = (RatingBar)layout.findViewById(R.id.estrelas);

        if(hotel != null){
            textNome.setText(hotel.nome);
            txtEndereco.setText(hotel.endereco);
            estrelas.setRating(hotel.estrelas);
        }
        return layout;
    }
}
