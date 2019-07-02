package trung.hci_billiards;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NearMeFragment extends Fragment {


    Button changeAll;
    Button uudaihot;
    Button ganban;
    Button sangtrong;

    public static NearMeFragment newInstance() {
        NearMeFragment fragment = new NearMeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_near_me, container, false);
        changeAll = view.findViewById(R.id.btnChangAll);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_nearMe, new TatCa_NearMe());
        transaction.commit();
        changeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_nearMe,new TatCa_NearMe());
                fragmentTransaction.commit();
            }
        });

        uudaihot = view.findViewById(R.id.btnUuDaiHot);
        uudaihot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_nearMe,new UuDaiHot_NearMe());
                fragmentTransaction.commit();
            }
        });
        ganban = view.findViewById(R.id.btnGanBan);
        ganban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_nearMe,new GanBan_NearMe());
                fragmentTransaction.commit();
            }
        });
        sangtrong = view.findViewById(R.id.btnSangTrong);
        sangtrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_nearMe,new SangTrong_NearMe());
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
