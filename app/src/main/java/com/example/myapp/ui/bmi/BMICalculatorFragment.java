package com.example.myapp.ui.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.R;
import com.example.myapp.ResultBMI;

public class BMICalculatorFragment extends Fragment {

    private EditText edtAge, edtHeight, edtWeight;
    private Button btnCalculate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bmi_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtAge = view.findViewById(R.id.edtage);
        edtHeight = view.findViewById(R.id.edtheight);
        edtWeight = view.findViewById(R.id.edtweigh);
        btnCalculate = view.findViewById(R.id.btnCalcu);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI(v);
            }
        });
    }

    private void calculateBMI(View view) {
        String ageStr = edtAge.getText().toString();
        String heightStr = edtHeight.getText().toString();
        String weightStr = edtWeight.getText().toString();

        if (ageStr.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);
        float height = Float.parseFloat(heightStr) / 100; // convert cm to meters
        float weight = Float.parseFloat(weightStr);

        if (age <= 0 || height <= 0 || weight <= 0) {
            Toast.makeText(getActivity(), "Giá trị không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        float bmi = weight / (height * height);

        // Chuyển sang ResultActivity và truyền dữ liệu
        Intent intent = new Intent(getActivity(), ResultBMI.class);
        intent.putExtra("bmi_result", bmi);
        startActivity(intent);
    }
}
