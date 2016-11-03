package material.danny_jiang.com.baiduweatherdemo.service;

import material.danny_jiang.com.baiduweatherdemo.model.WeatherModel;
import material.danny_jiang.com.baiduweatherdemo.utils.Constants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by axing on 16/10/27.
 */

public interface WeatherService {

    @GET(Constants.BAIDU_WEATHER_WEEK_URL)
    Observable<WeatherModel> getweatherData(
            @Query("location") String location,
            @Query("output") String output,
            @Query("ak") String ak);
}
