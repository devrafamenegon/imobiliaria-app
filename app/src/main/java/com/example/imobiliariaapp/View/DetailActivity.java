package com.example.imobiliariaapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.imobiliariaapp.Domain.ItemsDomain;
import com.example.imobiliariaapp.R;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt, addressTxt, bedTxt, bathTxt, wifiTxt, descriptionTxt, priceTxt;
    private ItemsDomain itemsDomain;
    private ImageView imgView;

    NumberFormat formatter = NumberFormat.getInstance(new Locale("pt", "BR"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable() {
        itemsDomain = (ItemsDomain) getIntent().getSerializableExtra("propertyValues");

        titleTxt.setText(itemsDomain.getTitle());
        addressTxt.setText(itemsDomain.getAddress());
        bedTxt.setText(itemsDomain.getBed() + "");
        bathTxt.setText(itemsDomain.getBath() + "");
        descriptionTxt.setText(itemsDomain.getDescription());
        priceTxt.setText("R$" + formatter.format(itemsDomain.getPrice()));

        if (itemsDomain.isWifi()) {
            wifiTxt.setText("Sim");
        } else {
            wifiTxt.setText("Não");
        }

        int drawableResourceId = getResources().getIdentifier(itemsDomain.getPic(), "drawable", getPackageName());

        Glide.with(this).load(drawableResourceId).into(imgView);
    }

    private void initView() {
        titleTxt = findViewById(R.id.detailTxtViewTitle);
        addressTxt = findViewById(R.id.detailTxtViewAddress);
        bedTxt = findViewById(R.id.detailTxtViewBedroom);
        bathTxt = findViewById(R.id.detailTxtViewBathroom);
        wifiTxt = findViewById(R.id.detailTxtViewWifi);
        descriptionTxt = findViewById(R.id.detailTxtViewDescription);
        imgView = findViewById(R.id.detailImgViewProperty);
        priceTxt = findViewById(R.id.detailTxtViewPrice);
    }
}