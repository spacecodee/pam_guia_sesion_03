package com.spacecodee.pamguiasesion03.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.spacecodee.pamguiasesion03.R;
import com.spacecodee.pamguiasesion03.dao.ProductDao;
import com.spacecodee.pamguiasesion03.dto.ProductDto;

public class MainActivity extends AppCompatActivity {

    private Spinner spnBrand;
    private Spinner spnTall;
    private EditText txtPairs;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.spnBrand = this.findViewById(R.id.spnBrand);
        this.spnTall = this.findViewById(R.id.spnTall);
        this.txtPairs = this.findViewById(R.id.txtPairs);
        this.txtTotal = this.findViewById(R.id.txtTotal);
    }

    public void calcular(View view) {
        ProductDao productDao = new ProductDao();
        ProductDto productDto = new ProductDto();

        productDto.setBrand(this.spnBrand.getSelectedItemPosition());
        productDto.setTall(this.spnTall.getSelectedItemPosition());
        productDto.setPairs(Integer.parseInt(this.txtPairs.getText().toString()));

        this.txtTotal.setText(productDao.calcularOperacion(productDto));
    }
}