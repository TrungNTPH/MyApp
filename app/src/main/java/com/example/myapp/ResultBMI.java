package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultBMI extends AppCompatActivity {

    private TextView txtBmi, txtCategory, txtAdvice;

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_bmi);

        txtBmi = findViewById(R.id.txtBmi);
        txtCategory = findViewById(R.id.txtCategory);
        txtAdvice = findViewById(R.id.txtAdvice);

        // Nhận dữ liệu từ Intent
        float bmi = getIntent().getFloatExtra("bmi_result", 0);

        // Hiển thị kết quả BMI
        txtBmi.setText("BMI của bạn là: " + String.format("%.2f", bmi));

        // Xác định phân loại và lời khuyên dựa trên giá trị BMI
        String category = "";
        String advice = "";

        if (bmi < 18.5) {
            category = "Bạn gầy";
            advice = "Hãy ăn uống đầy đủ và cân nhắc việc tập luyện để tăng cường sức khỏe.";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            category = "Bạn bình thường";
            advice = "Tiếp tục duy trì chế độ ăn uống và luyện tập lành mạnh.";
        } else if (bmi >= 25 && bmi < 29.9) {
            category = "Bạn thừa cân";
            advice = "Hãy chú ý đến chế độ ăn uống và tập luyện để cải thiện sức khỏe.";
        } else {
            category = "Bạn béo phì";
            advice = "Nên tham khảo ý kiến bác sĩ hoặc chuyên gia dinh dưỡng để có kế hoạch giảm cân hợp lý.";
        }

        // Hiển thị phân loại và lời khuyên
        txtCategory.setText("Phân loại: " + category);
        txtAdvice.setText("Lời khuyên: " + advice);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(ResultBMI.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
