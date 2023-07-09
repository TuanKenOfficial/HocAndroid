package com.example.myapplication.hocandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class ThemSQLiteActivity extends AppCompatActivity {

    private static final String TAG = "THEM";
    private EditText edtma, edtten, edtcasi, edtgioitinh, edtdiachi,edtphone;
    private Button btnThem, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sqlite);

        addControl();

        /*Nếu là cây model Music thì mở edtcasi View.VISIBLE
        * Còn là cây model SinhVien thì đóng hết 4 cái này View.GONE
        * Còn là cây model Contact thì đóng edtcasi lại View.GONE*/
        edtcasi.setVisibility(View.GONE);
        edtgioitinh.setVisibility(View.VISIBLE);
        edtdiachi.setVisibility(View.VISIBLE);
        edtphone.setVisibility(View.VISIBLE);
    }

    private void addControl() {
        edtma = (EditText) findViewById(R.id.edtma);
        edtten = (EditText) findViewById(R.id.edtten);
        edtcasi = (EditText) findViewById(R.id.edtcasi);
        edtgioitinh = (EditText) findViewById(R.id.edtgioitinh);
        edtdiachi = (EditText) findViewById(R.id.edtdiachi);
        edtphone = (EditText) findViewById(R.id.edtphone);
    }

    public void xulyLuu(View view) {
        int ma = Integer.parseInt(edtma.getText().toString());
        String ten = edtten.getText().toString();
//        String casi = edtten.getText().toString();
        String gioitinh = edtgioitinh.getText().toString();
        String diachi = edtdiachi.getText().toString();
        String phone = edtphone.getText().toString();

        ContentValues values = new ContentValues();
        values.put("Ma",ma);
        values.put("Ten",ten);
//        values.put("caSi",casi);
        values.put("GioiTinh",gioitinh);
        values.put("DiaChi",diachi);
        values.put("Phone",phone);

        Log.d(TAG, "xulyLuu: Mã: "+ma);
        Log.d(TAG, "xulyLuu: Tên: "+ten);
//        Log.d(TAG, "xulyLuu: Ca sĩ: "+casi);
        Log.d(TAG, "xulyLuu: Giới tính: "+gioitinh);
        Log.d(TAG, "xulyLuu: Địa chỉ: "+diachi);
        Log.d(TAG, "xulyLuu: Số điện thoại: "+phone);

        long kq = MainActivity.database.insert("Contact",null, values);
        Log.d(TAG, "xulyLuu: "+kq);
        if (kq>0){
            Log.d(TAG, "xulyLuu: Thành công");
            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_LONG).show();
        }
        else {
            Log.d(TAG, "xulyLuu: Thất bại");
            Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_LONG).show();
        }
    }

    public void xulyTiep(View view) {
        Log.d(TAG, "xulyTiep: ");
        edtma.setText("");
        edtten.setText("");
        edtcasi.setText("");
        edtgioitinh.setText("");
        edtdiachi.setText("");
        edtphone.setText("");
        edtma.requestFocus();
    }

    public void xulyDong(View view) {
        Log.d(TAG, "xulyDong: ");
        finish();
    }
}