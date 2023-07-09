package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="SQL";
//    String DATABASE_NAME = "dbSinhvien.sqlite";
//    String DATABASE_NAME = "dbMusic.sqlite";
    String DATABASE_NAME = "dbContact.sqlite";
    String DB_PATH_SUFFIX="/databases/";
    SQLiteDatabase database = null;
    ListView lvContact;
//    ArrayAdapter<Music> contactArrayAdapter;
//    ArrayAdapter<SinhVien> contactArrayAdapter;
    ArrayAdapter<Contact> contactArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        processCopy();
        addControl();
        hienthiSanPham();
    }
    private void hienthiSanPham() {
        database = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        //theo kieu rawQuery
//        Cursor cursor = database.rawQuery("select * from SinhVien",null);
//        Cursor cursor = database.rawQuery("select * from Music",null);
//        Cursor cursor = database.rawQuery("select * from Contact",null);

        //theo kieu query lay theo ma >= 2
        Cursor cursor = database.query("Contact",null,"Ma>=?",new String[]{"2"},null,null,null);
        contactArrayAdapter.clear();
        while (cursor.moveToNext()){
            int ma = cursor.getInt(0);
            String ten = cursor.getString(1);
            String gioitinh = cursor.getString(2);
            String diachi = cursor.getString(3);
            String phone = cursor.getString(4);
//            String casi = cursor.getString(2);

            Log.d(TAG, "hienthiSanPham: Mã: "+ma);
            Log.d(TAG, "hienthiSanPham: Tên: "+ten);
            Log.d(TAG, "hienthiSanPham: Giới tính: "+gioitinh);
            Log.d(TAG, "hienthiSanPham: Địa chỉ: "+diachi);
            Log.d(TAG, "hienthiSanPham: Số điện thoại: "+phone);
//            Log.d(TAG, "hienthiSanPham: Ca sĩ: "+casi);

//            Music music= new Music(ma,ten,casi);
//            contactArrayAdapter.add(music);
//            SinhVien sinhVien= new SinhVien(ma,ten);
//            contactArrayAdapter.add(sinhVien);

            Contact contact= new Contact(ma,ten,gioitinh,diachi,phone);
            contactArrayAdapter.add(contact);
        }
        cursor.close();
    }

    private void addControl() {
        lvContact = (ListView) findViewById(R.id.lvContact);
//        contactArrayAdapter = new ArrayAdapter<Music>(MainActivity.this, android.R.layout.simple_list_item_1);
//        contactArrayAdapter = new ArrayAdapter<SinhVien>(MainActivity.this, android.R.layout.simple_list_item_1);
        contactArrayAdapter = new ArrayAdapter<Contact>(MainActivity.this, android.R.layout.simple_list_item_1);

        lvContact.setAdapter(contactArrayAdapter);
    }

    private void processCopy(){
        try {
            File dbFile= getDatabasePath(DATABASE_NAME);
            if(!dbFile.exists()){
                copyDatabaseFromAsset();
                Toast.makeText(this, "Sao chép CSDL Sqlite vào hệ thống điện thoại thành công",
                        Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "Lỗi: "+e, Toast.LENGTH_LONG).show();
            Log.e(TAG, "processCopy: " +e);
        }
    }

    private String getDatabasePath(){
        return getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;
    }
    private void copyDatabaseFromAsset() {
        try {
            Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "copyDatabaseFromAsset: ");
            InputStream myInput = getAssets().open(DATABASE_NAME);
            String outFileName=getDatabasePath();
            File f = new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
           /*Lần chạy đầu tiên thì bỏ ! bên dưới ra
           * Sau khi chạy run lên được rồi thì để dấu chấm than lại
           * Vậy là kết thúc quy trình
           * Nhớ kiểm tra lớp Model coi có đúng với bảng sqlite đã tạo*/
            if(f.exists()){
                Toast.makeText(this, "File tồn tại đưa dữ liệu vào", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "copyDatabaseFromAsset: Load file lên");
                f.mkdir();
                OutputStream myOutPut = new FileOutputStream(outFileName);
                byte []buffer= new byte[1024];
                int length;
                while ((length=myInput.read(buffer))>0){
                    myOutPut.write(buffer,0,length);
                }
                myOutPut.flush();
                myOutPut.close();
                myInput.close();
            }
            else if (!f.exists()){
                Toast.makeText(this, "File không tồn tại", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "copyDatabaseFromAsset: Load file lên");
                f.mkdir();
                OutputStream myOutPut = new FileOutputStream(outFileName);
                byte []buffer= new byte[1024];
                int length;
                while ((length=myInput.read(buffer))>0){
                    myOutPut.write(buffer,0,length);
                }
                myOutPut.flush();
                myOutPut.close();
                myInput.close();
            }

        }
        catch (Exception e){
            Toast.makeText(this, "Lỗi: "+e, Toast.LENGTH_SHORT).show();
            Log.e(TAG, "copyDatabaseFromAsset: ", e);
        }
    }
}