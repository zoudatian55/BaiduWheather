package material.danny_jiang.com.baiduweatherdemo.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import material.danny_jiang.com.baiduweatherdemo.R;

/**
 * Created by axing on 16/10/27.
 */

public class WeatherModel {

    /**
     * error : 0
     * status : success
     * date : 2016-10-26
     * results : [{"currentCity":"杭州","pm25":"73","index":[{"title":"穿衣","zs":"舒适","tipt":"穿衣指数","des":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},{"title":"洗车","zs":"不宜","tipt":"洗车指数","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},{"title":"旅游","zs":"适宜","tipt":"旅游指数","des":"有降水，温度适宜，在细雨中游玩别有一番情调，可不要错过机会呦！但记得出门要携带雨具。"},{"title":"感冒","zs":"较易发","tipt":"感冒指数","des":"天气转凉，空气湿度较大，较易发生感冒，体质较弱的朋友请注意适当防护。"},{"title":"运动","zs":"较不宜","tipt":"运动指数","des":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"},{"title":"紫外线强度","zs":"弱","tipt":"紫外线强度指数","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}],"weather_data":[{"date":"周三 10月26日 (实时：22℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/zhenyu.png","weather":"阵雨","wind":"南风微风","temperature":"24 ~ 19℃"},{"date":"周四","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"东风微风","temperature":"25 ~ 19℃"},{"date":"周五","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/zhenyu.png","weather":"阵雨","wind":"南风微风","temperature":"22 ~ 16℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"小雨","wind":"北风4-5级","temperature":"19 ~ 13℃"}]}]
     */

    private int error;
    private String status;
    private String date;
    /**
     * currentCity : 杭州
     * pm25 : 73
     * index : [{"title":"穿衣","zs":"舒适","tipt":"穿衣指数","des":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},{"title":"洗车","zs":"不宜","tipt":"洗车指数","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},{"title":"旅游","zs":"适宜","tipt":"旅游指数","des":"有降水，温度适宜，在细雨中游玩别有一番情调，可不要错过机会呦！但记得出门要携带雨具。"},{"title":"感冒","zs":"较易发","tipt":"感冒指数","des":"天气转凉，空气湿度较大，较易发生感冒，体质较弱的朋友请注意适当防护。"},{"title":"运动","zs":"较不宜","tipt":"运动指数","des":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"},{"title":"紫外线强度","zs":"弱","tipt":"紫外线强度指数","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}]
     * weather_data : [{"date":"周三 10月26日 (实时：22℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/zhenyu.png","weather":"阵雨","wind":"南风微风","temperature":"24 ~ 19℃"},{"date":"周四","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"东风微风","temperature":"25 ~ 19℃"},{"date":"周五","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/zhenyu.png","weather":"阵雨","wind":"南风微风","temperature":"22 ~ 16℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"小雨","wind":"北风4-5级","temperature":"19 ~ 13℃"}]
     */

    private List<ResultsBean> results;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String currentCity;
        private String pm25;
        /**
         * title : 穿衣
         * zs : 舒适
         * tipt : 穿衣指数
         * des : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
         */

        private List<IndexBean> index;
        /**
         * date : 周三 10月26日 (实时：22℃)
         * dayPictureUrl : http://api.map.baidu.com/images/weather/day/zhenyu.png
         * nightPictureUrl : http://api.map.baidu.com/images/weather/night/zhenyu.png
         * weather : 阵雨
         * wind : 南风微风
         * temperature : 24 ~ 19℃
         */

        private List<WeatherDataBean> weather_data;

        public String getCurrentCity() {
            return currentCity;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public List<IndexBean> getIndex() {
            return index;
        }

        public void setIndex(List<IndexBean> index) {
            this.index = index;
        }

        public List<WeatherDataBean> getWeather_data() {
            return weather_data;
        }

        public void setWeather_data(List<WeatherDataBean> weather_data) {
            this.weather_data = weather_data;
        }

        public static class IndexBean {
            private String title;
            private String zs;
            private String tipt;
            private String des;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getZs() {
                return zs;
            }

            public void setZs(String zs) {
                this.zs = zs;
            }

            public String getTipt() {
                return tipt;
            }

            public void setTipt(String tipt) {
                this.tipt = tipt;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }
        }

        public static class WeatherDataBean {
            private String date;
            private String dayPictureUrl;
            private String nightPictureUrl;
            private String weather;
            private String wind;
            private String temperature;

            @BindingAdapter("img")
            public static void getInternetImage(ImageView imageView, String url) {
                Picasso
                        .with(imageView.getContext())
                        .load(url)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(imageView);
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDayPictureUrl() {
                return dayPictureUrl;
            }

            public void setDayPictureUrl(String dayPictureUrl) {
                this.dayPictureUrl = dayPictureUrl;
            }

            public String getNightPictureUrl() {
                return nightPictureUrl;
            }

            public void setNightPictureUrl(String nightPictureUrl) {
                this.nightPictureUrl = nightPictureUrl;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }
        }
    }
}
