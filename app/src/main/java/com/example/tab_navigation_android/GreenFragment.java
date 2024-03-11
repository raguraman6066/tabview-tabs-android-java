package com.example.tab_navigation_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class GreenFragment extends Fragment implements View.OnClickListener {
    EditText num1, num2;
    Button plus, minus, multiply, divide;
    TextView result;

    public GreenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_green, container, false);
         num1=view.findViewById(R.id.number1);
         num2=view.findViewById(R.id.number2);
         plus=view.findViewById(R.id.plus);
         minus=view.findViewById(R.id.minus);
         multiply=view.findViewById(R.id.product);
         divide=view.findViewById(R.id.divide);
         result=view.findViewById(R.id.results);

         plus.setOnClickListener(this);
         minus.setOnClickListener(this);
         multiply.setOnClickListener(this);
         divide.setOnClickListener(this);
        num1.requestFocus();
        return view;
    }

    @Override
    public void onClick(View view) {
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int r = 0;

        if (view.getId() == R.id.plus) {
            r = n1 + n2;
        } else if (view.getId() == R.id.minus) {
            r = n1 - n2;
        } else if (view.getId() == R.id.product) {
            r = n1 * n2;
        } else if (view.getId() == R.id.divide) {
            if (n2 != 0) {
                r = n1 / n2;
            } else {
                result.setText("Cannot divide by zero");
                return; // Exit onClick() method early if division by zero
            }
        }

        result.setText(String.valueOf(r));
    }

}