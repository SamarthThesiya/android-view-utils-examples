package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewutilsjavatest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabThreeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabThreeFragment extends Fragment {

    public TabThreeFragment() {}

    public static TabThreeFragment newInstance() {
        return new TabThreeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_three, container, false);
    }
}