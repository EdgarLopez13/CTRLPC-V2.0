package com.example.ctrlpc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CuentaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CuentaFragment extends Fragment {

    RecyclerView recyclerView;


   List<CuentaBD> Listusuarios;

  Context global = null;

    RequestQueue requestQueue;

    String Correo = Login.Correo;

    String Password = Login.Password;

    private String URL_BD ="https://carlosarmenta.000webhostapp.com/ctrlpc/buscar_datos.php?EMAIL=" + Correo + "&PASSWORD=" + Password;

    ScrollView scrollView;

    Button iniciar,crear;

    int sesion = Login.sesion;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CuentaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CuentaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CuentaFragment newInstance(String param1, String param2) {
        CuentaFragment fragment = new CuentaFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cuenta, container, false);
       global = this.getActivity();
        recyclerView = view.findViewById(R.id.RVcuenta);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Listusuarios = new ArrayList<>();


        scrollView = view.findViewById(R.id.SVcuenta);
        iniciar = view.findViewById(R.id.button);
        crear = view.findViewById(R.id.button2);

        if (sesion ==1) {
            scrollView.setVisibility(View.GONE);
            iniciar.setVisibility(View.GONE);
            crear.setVisibility(View.GONE);
        }

        CargarCuenta(URL_BD);


        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), Login.class);
                getActivity().startActivity(intent);
            }
        });

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), RegistroUsuarios.class);
                getActivity().startActivity(intent);
            }
        });

        return view;

    }

    public  void CargarCuenta(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {


                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject cuenta = array.getJSONObject(i);

                        Listusuarios.add(new CuentaBD(
                                cuenta.getInt("ID_CLIENT"),
                                cuenta.getString("EMAIL"),
                                cuenta.getString("NOMBRES"),
                                cuenta.getString("APELLIDOS"),
                                cuenta.getString("FOTO")

                        ));

                    }


                    AdaptadorCuenta adaptadorCuenta = new AdaptadorCuenta(Listusuarios);
                    recyclerView.setAdapter(adaptadorCuenta);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

                new Response.ErrorListener(){


                    public void onErrorResponse(VolleyError error){


                    }

                });

        Volley.newRequestQueue(getContext()).add(stringRequest);

    }
}