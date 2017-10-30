package test.bawei.com.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import static test.bawei.com.tablayout.R.id.tablayout;
import static test.bawei.com.tablayout.R.id.viewpager;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  FragemntOne f1;
    private  Fragmenttwo f2;
    private  Fragemntthree f3;
    private  Fragmentfour f4;
    private List<Fragment> fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(tablayout);

        viewPager= (ViewPager) findViewById(viewpager);
        fragments= new ArrayList<Fragment>();

        f1 = new FragemntOne();
        f2 = new Fragmenttwo();
        f3 = new Fragemntthree();
        f4 = new Fragmentfour();

        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);


        FragmentAdapter  adapter = new FragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
