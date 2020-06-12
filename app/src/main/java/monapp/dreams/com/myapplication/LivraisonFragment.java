package monapp.dreams.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import monapp.dreams.com.myapplication.models.Adresse;
import monapp.dreams.com.myapplication.models.Bon_Livraison;
import monapp.dreams.com.myapplication.models.Client;
import monapp.dreams.com.myapplication.models.Livreur;
import monapp.dreams.com.myapplication.models.Magasin;

import static android.app.Activity.RESULT_OK;

/**
 * A fragment representing a list of Items.
 */
public class LivraisonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private String dateCalendar = null;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LivraisonFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LivraisonFragment newInstance(int columnCount) {
        LivraisonFragment fragment = new LivraisonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }
    ArrayList<Bon_Livraison> listeBon_Livraison;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.livraison_item_list, container, false);

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url ="https://livirunapi.herokuapp.com/bl/aujourdhui";
        listeBon_Livraison =new ArrayList<>();
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("volley",response);
                        try {
                            JSONArray tab=new JSONArray(response);
                            for(int i=0;i<tab.length();i++) {
                                JSONObject o = tab.getJSONObject(i);


                                Gson gson = new Gson();
                                Client client = gson.fromJson(o.getString("id_Client"), Client.class);
                                Adresse adresse = gson.fromJson(o.getString("id_Adresse"), Adresse.class);
                                Magasin magasin = gson.fromJson(o.getString("id_Magasin_Achat"), Magasin.class);
                                Livreur livreur = gson.fromJson(o.getString("id_Livreur"), Livreur.class);
                                Bon_Livraison bon_livraison = new Bon_Livraison(

                                        o.getLong("id"),

                                        client,
                                        magasin,
                                        livreur, null, null,
                                        //new SimpleDateFormat("dd/MM/yyyy").parse(o.getString("date_Achat")),
                                        //new SimpleDateFormat("dd/MM/yyyy").parse(o.getString("date_Livraison")),
                                        o.getString("commentaire"),
                                        adresse,
                                        o.getString("signature")
                                );
                                listeBon_Livraison.add(bon_livraison);
                            }
                            recyclerView.getAdapter().notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("volley",error.toString());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
             recyclerView = view.findViewById(R.id.list);
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyLivraisonRecyclerViewAdapter(listeBon_Livraison));
        }
        recyclerView = view.findViewById(R.id.list);
        imageView = view.findViewById(R.id.imageView_Calendar);
        textView_DateLivraison = view.findViewById(R.id.textView_dateLivraison);
        recyclerView.setAdapter(new MyLivraisonRecyclerViewAdapter(listeBon_Livraison));
        Date date = new Date();
        textView_DateLivraison.setText(date.getDate()+"-"+(date.getMonth()+1)+"-"+(date.getYear()+1900));

        imageView.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {

                    Intent surf = new Intent(getContext(), ActivityCalendar.class);
                    startActivityForResult(surf, 1);
            }
        });
        return view;


    }
    RecyclerView recyclerView;
    ImageView imageView;
    TextView textView_DateLivraison;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                dateCalendar = data.getStringExtra("date");
                listeBon_Livraison = new ArrayList<>();
                if (dateCalendar != null) {
                    Log.d("dateCalendar", dateCalendar);
                    textView_DateLivraison.setText(dateCalendar);
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    String url = "https://livirunapi.herokuapp.com/bl/" + dateCalendar;

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Display the first 500 characters of the response string.
                                    Log.d("volley", response);
                                    try {
                                        JSONArray tab = new JSONArray(response);
                                        for (int i = 0; i < tab.length(); i++) {
                                            JSONObject o = tab.getJSONObject(i);


                                            Gson gson = new Gson();
                                            Client client = gson.fromJson(o.getString("id_Client"), Client.class);
                                            Adresse adresse = gson.fromJson(o.getString("id_Adresse"), Adresse.class);
                                            Magasin magasin = gson.fromJson(o.getString("id_Magasin_Achat"), Magasin.class);
                                            Livreur livreur = gson.fromJson(o.getString("id_Livreur"), Livreur.class);
                                            Bon_Livraison bon_livraison = new Bon_Livraison(

                                                    o.getLong("id"),

                                                    client,
                                                    magasin,
                                                    livreur, null, null,
                                                    //new SimpleDateFormat("dd/MM/yyyy").parse(o.getString("date_Achat")),
                                                    //new SimpleDateFormat("dd/MM/yyyy").parse(o.getString("date_Livraison")),
                                                    o.getString("commentaire"),
                                                    adresse,
                                                    o.getString("signature")
                                            );
                                            listeBon_Livraison.add(bon_livraison);
                                        }
                                        recyclerView.setAdapter(new MyLivraisonRecyclerViewAdapter(listeBon_Livraison));
                                        recyclerView.getAdapter().notifyDataSetChanged();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("volley", error.toString());
                        }
                    });

// Add the request to the RequestQueue.
                    queue.add(stringRequest);
                }else{
                    recyclerView.setAdapter(new MyLivraisonRecyclerViewAdapter(listeBon_Livraison));
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}