package monapp.dreams.com.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import monapp.dreams.com.myapplication.models.Magasin;

/**
 * A fragment representing a list of Items.
 */
public class MagasinFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MagasinFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MagasinFragment newInstance(int columnCount) {
        MagasinFragment fragment = new MagasinFragment();
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
    ArrayList<Magasin> listeMagasin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.magasin_item_list, container, false);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url ="https://livirunapi.herokuapp.com/magasins";
        listeMagasin=new ArrayList<>();
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("volley",response);
                        try {
                            JSONArray tab=new JSONArray(response);
                            for(int i=0;i<tab.length();i++){
                                JSONObject o=tab.getJSONObject(i);
                                Magasin m=new Magasin();
                                m.setId(o.getLong("id"));
                                m.setAddress(o.getString("adresse"));
                                m.setEmail(o.getString("email"));
                                m.setNom(o.getString("nom"));
                                listeMagasin.add(m);
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
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyMagasinRecyclerViewAdapter(listeMagasin));
        }
        return view;
    }
    RecyclerView recyclerView;
}