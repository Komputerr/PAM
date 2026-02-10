package com.example.a04_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormFragment extends Fragment {

   private Button button;
   private EditText editTextEmail, editTextImie, editTextNazwisko;

   private Bundle info;

    public FormFragment() {
        // Required empty public constructor
    }
    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        button = view.findViewById(R.id.button);
        editTextEmail = view.findViewById(R.id.editTextTextEmailAddress);
        editTextImie = view.findViewById(R.id.editTextText);
        editTextNazwisko = view.findViewById(R.id.editTextText2);
        info = new Bundle();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String imie = editTextImie.getText().toString();
                String nazwisko = editTextNazwisko.getText().toString();
                if(!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
                {
                    Toast.makeText(getContext(), "Zly email", Toast.LENGTH_LONG).show();
                }
                else if(imie.isBlank() || nazwisko.isBlank())
                {
                    Toast.makeText(getContext(), "imie lub nazwisko nie moga byc puste", Toast.LENGTH_LONG).show();
                }
                else{
                    info.putString("email",email);
                    info.putString("imie",imie);
                    info.putString("nazwisko",nazwisko);
                    getParentFragmentManager().setFragmentResult("requestKey", info);
                    FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.main, new ResultFragment());
                    fragmentTransaction.commit();


                }
            }
        });
        return view;
    }
}