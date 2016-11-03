package material.danny_jiang.com.baiduweatherdemo.net;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.List;

import material.danny_jiang.com.baiduweatherdemo.model.WeatherModel;
import material.danny_jiang.com.baiduweatherdemo.service.WeatherService;
import material.danny_jiang.com.baiduweatherdemo.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by axing on 16/10/27.
 */

public class RetrofitUtils {

    private static RetrofitUtils instance;
    private final Retrofit weatherRetrofit;

    public static RetrofitUtils getInstance() {
        if (instance == null) {
            instance = new RetrofitUtils();
        }

        return instance;
    }

    public RetrofitUtils() {
        weatherRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constants.BAIDU_WEATHER_BASE_URL)
                .build();
    }

    public Retrofit getWeatherRetrofit() {
        return weatherRetrofit;
    }


    public static void getWeatherDadta(String location, final Handler handler, final int what) {
        WeatherService weatherService = getInstance().getWeatherRetrofit()
                .create(WeatherService.class);

        Observable<WeatherModel> weatherModelObservable = weatherService.getweatherData(location, Constants.BAIDU_WEATHER_OUTPUT_JSON,
                Constants.BAIDU_WEATHER_AK_VALUE);

        weatherModelObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherModel>() {
                    @Override
                    public void onCompleted() {
                        Log.e("TAG", "onCompleted: 任务完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(WeatherModel weatherModel) {
                        Log.e("TAG", "onResponse: ");
                        WeatherModel.ResultsBean resultsBean = weatherModel.getResults().get(0);

                        List<WeatherModel.ResultsBean.WeatherDataBean> weather_data =
                                resultsBean.getWeather_data();

                        Message message = handler.obtainMessage();

                        message.obj = weather_data;

                        message.what = what;

                        handler.sendMessage(message);
                    }
                });
    }
}
