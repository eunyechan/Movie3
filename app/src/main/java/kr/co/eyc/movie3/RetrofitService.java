package kr.co.eyc.movie3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=cb6d6dc84dcac76d321a14951b39b545&targetDt={20200913}")
    Call<MovieItem> getData();
}
