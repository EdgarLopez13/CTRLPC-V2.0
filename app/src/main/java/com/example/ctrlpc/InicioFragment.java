package com.example.ctrlpc;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

  TextView Discos,Rams,tarjetamadre,accesorios,tarjetagrafica;

    ImageView IV1,IV2,IV3,IV4,IV5,IV6,IV7,IV8,IV9,IV10,IV11,IV12;

  public static String Articulo = "";
  public static int Accion = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        IV1 = view.findViewById(R.id.IVA1);
        IV2 = view.findViewById(R.id.IVA2);
        IV3 = view.findViewById(R.id.IVA3);
        IV4 = view.findViewById(R.id.IVA4);
        IV5 = view.findViewById(R.id.IVA5);
        IV6 = view.findViewById(R.id.IVA6);
        IV7 = view.findViewById(R.id.IVA7);
        IV8 = view.findViewById(R.id.IVA8);
        IV9 = view.findViewById(R.id.IVA9);
        IV10 = view.findViewById(R.id.IVA10);
        IV11 = view.findViewById(R.id.IVA11);
        IV12 = view.findViewById(R.id.IVA12);


        ponerimagen();





        Discos = view.findViewById(R.id.TVvermasCV);
        Rams = view.findViewById(R.id.TVvermasCV1);
        tarjetamadre = view.findViewById(R.id.TVvermasCV2);
        accesorios = view.findViewById(R.id.TVvermasCV3);

        Articulos articulos = new Articulos();
        Discos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent =  new Intent(getActivity(), ArticulosFragment.class);
                getActivity().startActivity(intent);*/

                Articulo = "HDD";
                Accion = 2;


                ArticulosFragment articulosFragment = new ArticulosFragment();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.frameLayout,articulosFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        Rams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Articulo = "RAM";
                Accion = 1;

               /* Intent intent =  new Intent(getActivity(), ArticulosFragment.class);
                getActivity().startActivity(intent);*/

                ArticulosFragment articulosFragment = new ArticulosFragment();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.frameLayout,articulosFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        tarjetamadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Articulo = "TARJETA MADRE";
                Accion = 3;

                ArticulosFragment articulosFragment = new ArticulosFragment();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.frameLayout,articulosFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        accesorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Articulo = "ACCESORIO";
                Accion = 4;

                ArticulosFragment articulosFragment = new ArticulosFragment();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.frameLayout,articulosFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


                return view;
    }

    public void ponerimagen()
    {
        Picasso.get()
                .load("https://images-na.ssl-images-amazon.com/images/I/61UV4Psi80L._AC_SL1100_.jpg")
                .into(IV1);
        Picasso.get()
                .load("https://http2.mlstatic.com/D_NQ_NP_962239-MLA32170216683_092019-O.jpg")
                .into(IV2);
        Picasso.get()
                .load("https://media.ldlc.com/r1600/ld/products/00/04/94/95/LD0004949540_2.jpg")
                .into(IV3);
        Picasso.get()
                .load("https://ae01.alicdn.com/kf/HTB1T5kfm7SWBuNjSszdq6zeSpXac/KingSpec-512GB-mSATA-Hard-Drive-SSD-500GB-Mini-Card-For-Laptop-3-5-mm-1-3.jpg")
                .into(IV4);
        Picasso.get()
                .load("https://dojiw2m9tvv09.cloudfront.net/14577/product/L_10081-27422.jpg?252")
                .into(IV5);
        Picasso.get()
                .load("https://http2.mlstatic.com/D_NQ_NP_776792-MLA40491725737_012020-O.jpg")
                .into(IV6);
        Picasso.get()
                .load("https://www.cyberpuerta.mx/img/product/L/CP-AORUS-B450AORUSPROWIFI-1.jpg")
                .into(IV7);
        Picasso.get()
                .load("https://www.cyberpuerta.mx/img/product/L/CP-GIGABYTE-H410MH(REV10)-1.jpg")
                .into(IV8);
        Picasso.get()
                .load("https://intercompras.com/images/product/GIGABYTE_B450GAMINGX.jpg")
                .into(IV9);
        Picasso.get()
                .load("https://www.sanborns.com.mx/imagenes-sanborns-ii/1200/631145836782.jpg")
                .into(IV10);
        Picasso.get()
                .load("https://cdn.shopify.com/s/files/1/0254/2144/7246/products/5dfc93f7-beff-4646-ad51-f9ad6aafeb07.jpg?v=1612377194")
                .into(IV11);
        Picasso.get()
                .load("https://resources.claroshop.com/medios-plazavip/s2/10252/1268355/5dcdcf0239527-audifonos-gamer-nivava-k6-luz-led-sonido-envolvente-verde-1600x1600.jpg")
                .into(IV12);
    }
}