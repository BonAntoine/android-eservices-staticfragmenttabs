package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "SUBTRACT TO COUNTER";

    private View localView;

    private int counter;

    private CounterInterface counterInterface;

    public FragmentTwo() {
        // Comme dans la doc mais ne fonctionne pas
        // super(R.layout.fragment_one);

        counter = 0;

    }

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        localView = inflater.inflate(R.layout.fragment_two, container, false);
        return localView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();

        counterInterface = ((MainActivity)getActivity());

        // add listener to the button
        final Button btn = (Button) localView.findViewById(R.id.button_decrement);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counterInterface.decCpt();
            }
        });
    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}
