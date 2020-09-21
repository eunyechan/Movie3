package kr.co.eyc.movie3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
//        Call<String> call =service.getData();
//
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Toast.makeText(MainActivity.this, "성공"+response.body(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });

        Date date= new Date(); //오늘날짜
        date.setTime( date.getTime() - (1000*60*60*24) ); //1일전
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd"); //날짜를 지정한 패턴으로 만들어줌.

        String dateStr=sdf.format(date);//검색 날짜 "20200526"


        Call<MovieItem> call= service.getData(dateStr);

        call.enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                MovieItem item= response.body();

                ArrayList<DaliyBoxofficeList> lists= item.boxOfficeResult.dailyBoxOfficeList;
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
