package material.danny_jiang.com.baiduweatherdemo;

import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.List;

import material.danny_jiang.com.baiduweatherdemo.BR;
import material.danny_jiang.com.baiduweatherdemo.adapter.CommonAdapter;
import material.danny_jiang.com.baiduweatherdemo.databinding.ActivityMainBinding;
import material.danny_jiang.com.baiduweatherdemo.model.CityModel;
import material.danny_jiang.com.baiduweatherdemo.model.WeatherModel;
import material.danny_jiang.com.baiduweatherdemo.net.RetrofitUtils;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_WEEK_WEATHER = 1;
    private ActivityMainBinding binding;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            List<WeatherModel.ResultsBean.WeatherDataBean> weatherDataBeen =
                    (List<WeatherModel.ResultsBean.WeatherDataBean>) msg.obj;

            CommonAdapter<WeatherModel.ResultsBean.WeatherDataBean> adapter =
                    new CommonAdapter<>(MainActivity.this, weatherDataBeen,
                            R.layout.list_item, BR.weather_data);

            binding.listMain.onRefreshComplete();//刷新完毕
            binding.listMain.setAdapter(adapter);
        }
    };
    private CityModel cityModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        cityModel = new CityModel();

        binding.setCity(cityModel);
        binding.setActivity(this);

        initPullToRefresh();
    }

    private void initPullToRefresh() {
        ILoadingLayout loadingLayoutProxy = binding.listMain.getLoadingLayoutProxy();
        //自定义下拉刷新动画
        loadingLayoutProxy.setLoadingDrawable(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));
        //定义继续下拉时显示的文本
        loadingLayoutProxy.setReleaseLabel("释放刷新...");
        //定义上次下拉的标记文本
        loadingLayoutProxy.setLastUpdatedLabel("上次刷新时间");
        //刚刚开始下拉时显示的文本
        loadingLayoutProxy.setPullLabel("继续下拉刷新...");
        //数据加载过程中显示的文本
        loadingLayoutProxy.setRefreshingLabel("玩命加载中...");
        //修改字体
        loadingLayoutProxy.setTextTypeface(Typeface.createFromAsset(getAssets(), "mycustom.ttf"));

        binding.listMain.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                RetrofitUtils.getWeatherDadta(cityModel.getCityName(),
                        handler, REQUEST_WEEK_WEATHER);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }

    public void btnClicked(View view, String cityName) {
        binding.listMain.setRefreshing();//设置正在刷新
        //TODO 使用Retrofit发送网络请求
        RetrofitUtils.getWeatherDadta(cityName, handler, REQUEST_WEEK_WEATHER);
    }
}
