package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity implements CounterInterface {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private int currentCounter = Integer.MAX_VALUE;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {

        counterTextView = (TextView) findViewById(R.id.counter_textview);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        // Pourquoi newInstance et pas utilise le constructeur ?
        FragmentOne f1 = FragmentOne.newInstance();
        FragmentTwo f2 = FragmentTwo.newInstance();

        //TODO set adapter to viewpager and handle tragment change inside
        viewPager = (ViewPager2) findViewById(R.id.tab_viewpager);
        viewPager.setAdapter(new MyAdapter(this, f1, f2) {

        });

        //TabLayoutMediator tabLayoutMediator...

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(position == 0 ? FragmentOne.TAB_NAME : FragmentTwo.TAB_NAME);
            }
        });
        tabLayoutMediator.attach();

    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)

    public void incCpt() {
        currentCounter++;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }

    public void decCpt() {
        currentCounter--;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }
}
