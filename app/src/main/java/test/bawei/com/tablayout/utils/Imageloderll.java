package test.bawei.com.tablayout.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import test.bawei.com.tablayout.R;

/**
 * Created by lenovo on 2017/10/25.
 */

public class Imageloderll {
    public static void setimage(String url, Context context, ImageView imageView) {
        ImageLoaderConfiguration loaderConfiguration = new ImageLoaderConfiguration.Builder(context).build();
        ImageLoader loader = ImageLoader.getInstance();
        loader.init(loaderConfiguration);
        //com.nostra13.universalimageloader:universal-image-loader:1.9.5  依赖
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡中
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型
                .build();//构建完成
        loader.displayImage(url, imageView, options);

    }
}
