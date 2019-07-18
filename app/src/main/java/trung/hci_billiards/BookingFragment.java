package trung.hci_billiards;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment {


    Button banDangDat, lichSuDatBan;

    public static BookingFragment newInstance () {
        BookingFragment fragment = new BookingFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking_history,container,false);
        banDangDat = view.findViewById(R.id.btnBanDangDat);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_booking_history, new BanDangDatFragment());
        transaction.commit();
        banDangDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.replace(R.id.frame_booking_history, new BanDangDatFragment());
                transaction1.commit();
            }
        });

        lichSuDatBan = view.findViewById(R.id.btnLichSuDatBan);
        lichSuDatBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_booking_history, new LichSuDatBanFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
