package android.eservices.staticfragmenttabs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    static final int NUM_PAGES = 2;

    FragmentOne f1;
    FragmentTwo f2;

    public MyAdapter(FragmentActivity f, FragmentOne f1, FragmentTwo f2) {
        super(f);
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return f1;
        }
        return f2;
    }

}