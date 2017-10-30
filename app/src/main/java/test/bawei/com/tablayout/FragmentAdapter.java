package test.bawei.com.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/10/25.
 */

public class FragmentAdapter extends FragmentPagerAdapter {


  private String [] title = {"最新日报","专栏","热门","主题日报"};
    private List<Fragment> fragmentList;
    public FragmentAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
   @Override
   public CharSequence getPageTitle(int position) {
      return title[position];
   }
}
