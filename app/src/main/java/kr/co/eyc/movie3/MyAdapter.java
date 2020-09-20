package kr.co.eyc.movie3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<DaliyBoxofficeList> datas;

    public MyAdapter(Context context, ArrayList<DaliyBoxofficeList> datas){
        this.context= context;
        this.datas= datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder= new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder)holder;
        DaliyBoxofficeList data= datas.get(position);

        viewHolder.name.setText(data.movieNm);
        viewHolder.rank.setText(data.rank);
        viewHolder.openDt.setText(data.openDt);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, rank, openDt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.name);
            rank= itemView.findViewById(R.id.rank);
            openDt= itemView.findViewById(R.id.open);
        }
    }
}
