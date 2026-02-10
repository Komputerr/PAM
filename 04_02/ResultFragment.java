package com.example.a04_02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class ResultFragment extends Fragment {
    private TextView textView1, textView2, textView3;
    private String email,imie,nazwisko;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                email = result.getString("email");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");

                if(email != null && imie!=null && nazwisko!=null)
                {
                    textView1.setText(email);
                    textView2.setText(imie);
                    textView3.setText(nazwisko);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_result, container, false);

        textView1 = view.findViewById(R.id.textView);
        textView2 = view.findViewById(R.id.textView2);
        textView3 = view.findViewById(R.id.textView3);

        if(email != null && imie!=null && nazwisko!=null)
        {
            textView1.setText(email);
            textView2.setText(imie);
            textView3.setText(nazwisko);
        }

        return view;
    }
}