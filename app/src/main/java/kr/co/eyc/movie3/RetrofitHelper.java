package kr.co.eyc.movie3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {

    public static Retrofit getData(){

        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://www.kobis.or.kr/");
        builder.addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }
}
