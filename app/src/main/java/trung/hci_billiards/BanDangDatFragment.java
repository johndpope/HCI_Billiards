package trung.hci_billiards;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BanDangDatFragment extends Fragment {

    private static final String TAG = "BanDangDatFragment";

    public BanDangDatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d(TAG, "onCreateView: BanDangDatFragment created");
        return inflater.inflate(R.layout.fragment_ban_dang_dat, container, false);
    }

}
