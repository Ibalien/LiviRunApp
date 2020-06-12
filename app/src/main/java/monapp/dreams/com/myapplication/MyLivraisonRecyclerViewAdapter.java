package monapp.dreams.com.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import monapp.dreams.com.myapplication.dummy.DummyContent.DummyItem;
import monapp.dreams.com.myapplication.models.Bon_Livraison;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLivraisonRecyclerViewAdapter extends RecyclerView.Adapter<MyLivraisonRecyclerViewAdapter.ViewHolder> {

    private final List<Bon_Livraison> mValues;

    public MyLivraisonRecyclerViewAdapter(List<Bon_Livraison> items) {

        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.livraison_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(Long.toString(mValues.get(position).getId()));
        holder.nomView.setText(mValues.get(position).getIdClient().getNom()+" "+mValues.get(position).getIdClient().getPrenom());
        holder.villeView.setText(mValues.get(position).getIdAdresse().getVille());
        holder.magasinView.setText(mValues.get(position).getIdMagasinAchat().getNom());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView nomView;
        public final TextView villeView;
        public final TextView magasinView;
        public Bon_Livraison mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            nomView = (TextView) view.findViewById(R.id.nom_client);
            villeView = view.findViewById(R.id.ville_view);
            magasinView = view.findViewById(R.id.magasin_view);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + nomView.getText() + "'";
        }
    }
}