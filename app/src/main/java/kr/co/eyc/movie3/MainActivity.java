package kr.co.eyc.movie3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DaliyBoxofficeList> items= new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recycler);
        adapter= new MyAdapter(this, items);
        recyclerView.setAdapter(adapter);

        Retrofit retrofit= RetrofitHelper.getData();
        RetrofitService service= retrofit.create(RetrofitService.class);
        Call<MovieItem> call= service.getData();

        call.enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
//                Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
                MovieItem item= response.body();
                String typ= item.boxOfficeResult.boxofficeType;

                Toast.makeText(MainActivity.this, typ+"", Toast.LENGTH_SHORT).show();

                ArrayList<DaliyBoxofficeList> lists= item.boxOfficeResult.daliyBoxofficeList;
                for (DaliyBoxofficeList list: lists){
                    items.add(list);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieItem> call, Throwable t) {

            }
        });
    }
}
