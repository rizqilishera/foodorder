package com.example.kelompok3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView txtJumlahBeef, txtJumlahCheese, txtHarga, txtGetNama, txtGetAlamat;
    EditText editNama, editAlamat;
    CheckBox cbx_beef, cbx_cheese;
    Spinner spinner1;
    int jumlah1, jumlah2, total, harga, harga1 = 13000, harga2 = 15000, beef, cheese;
    String nama, alamat, statusBeef = "tidak", statusCheese = "tidak";
    boolean iscbx_beef, isCbx_cheese;
    String[] metode = {
            "– pilih –",
            "Delivery Order",
            "Pick-up",
    };

    Spinner s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtJumlahBeef = (TextView) findViewById(R.id.txt_jumlahbeef);
        txtJumlahCheese = (TextView) findViewById(R.id.txt_jumlahcheese);
        txtHarga = (TextView) findViewById(R.id.txt_price);
        editNama = (EditText) findViewById(R.id.txt_nama);
        editAlamat = (EditText) findViewById(R.id.txt_alamat);
        txtGetNama = (TextView) findViewById(R.id.txt_getNama);
        txtGetAlamat = (TextView) findViewById(R.id.txt_getAlamat);
        cbx_beef = (CheckBox) findViewById(R.id.cbx_beef);
        cbx_cheese = (CheckBox) findViewById(R.id.cbx_cheese);
        s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, metode);
        s1.setAdapter(adapter);
    }


    public void beef() {
        if (cbx_beef.isChecked()) {
            iscbx_beef = true;
            statusBeef = "Beef Burger";
            beef = 1;
        } else {
            iscbx_beef = false;
            statusBeef = "";
            beef = 0;
        }

        if (cbx_cheese.isChecked()) {
            isCbx_cheese = true;
            statusCheese = "Cheese Burger";
            cheese = 2;
        } else {
            isCbx_cheese = false;
            statusCheese = "";
            cheese = 0;
        }
    }

    public void tambah1(View view) {
        jumlah1 = jumlah1 + 1;
        txtJumlahBeef.setText("" + jumlah1);
    }

    public void kurang1(View view) {
        jumlah1 = jumlah1 - 1;
        txtJumlahBeef.setText("" + jumlah1);
    }

    public void tambah2(View view) {
        jumlah2 = jumlah2 + 1;
        txtJumlahCheese.setText("" + jumlah2);
    }

    public void kurang2(View view) {
        jumlah2 = jumlah2 - 1;
        txtJumlahCheese.setText("" + jumlah2);
    }

    public void order(View view) {
        display(harga1);
    }

    public void display(int harga) {
        beef();
        total = (jumlah1 * harga1) + (jumlah2 * harga2);

        Log.i("harga :", "" + total);
        nama = editNama.getText().toString();
        txtGetNama.setText("Nama: " + nama +
                "\n" + statusBeef + ": " + jumlah1 +
                "\n" + statusCheese + ": "+ jumlah2 +
                "\nTerimakasih");
        txtHarga.setText("Harga : Rp." + total);
        int index = s1.getSelectedItemPosition();
        TextView lihat = (TextView) findViewById(R.id.textView2);
        if (metode[index] == "Delivery Order") {
            lihat.setText("Makanan Akan diantar kepada Alamat Anda");
        } else if (metode[index] == "Pick-up") {
            lihat.setText("Ambil Makanan Anda pada cabang Threeger terdekat");
        } else {
            lihat.setText("Pilih Metode");
        }
    }
}