package monapp.dreams.com.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import monapp.dreams.com.myapplication.dummy.DummyContent.DummyItem;
import monapp.dreams.com.myapplication.models.Magasin;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMagasinRecyclerViewAdapter extends RecyclerView.Adapter<MyMagasinRecyclerViewAdapter.ViewHolder> {

    private final List<Magasin> mValues;

    public MyMagasinRecyclerViewAdapter(List<Magasin> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.magasin_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNomView.setText(mValues.get(position).getNom());
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNomView;
        public Magasin mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNomView = (TextView) view.findViewById(R.id.nom_view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNomView.getText() + "'";
        }
    }
}