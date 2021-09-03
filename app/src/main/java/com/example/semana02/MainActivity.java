package com.example.semana02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.semana02.Model.Client;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button btnRegistar;
    private TextView txtName;
    private TextView txtGmail;
    private TextView txtPhone;
    private TextView txtDate;
    private Spinner cboCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistar = findViewById(R.id.btnRegistrar);
        btnRegistar.setOnClickListener(this);


        txtName =  findViewById(R.id.idTextNombre);
        txtGmail = findViewById(R.id.idTextCorreo);
        txtPhone = findViewById(R.id.idTextPhone);
        txtDate = findViewById(R.id.idTextDate);
        cboCategory = findViewById(R.id.idSpnCategoria);


    }

    @Override
    public void onClick(View view) {
        if(view.findViewById(R.id.btnRegistrar) == this.btnRegistar){
            if(!(getName() == null ||  getPhone() == null || getGmail() == null || getDate() == null || getCategory() == -1)){
                Client c = new Client();
                c.setName(getName());
                c.setPhone(getPhone());
                c.setGmail(getGmail());
                c.setDate(getDate());
                c.setCategory(getCategory());
                mensaje(c.toString());
            }

        }
    }


    public String getName(){
        String nombre = this.txtName.getText().toString().trim();
        if(nombre.length()<=0){
            mensajeToast("Ingrese nombre");
        }else{
            return nombre;
        }
        return null;
    }
    public String getGmail(){
        String correo = this.txtGmail.getText().toString().trim();
        if(correo.length()<=0){
            mensajeToast("Ingrese correo");
        }else if(!correo.contains("@") || !correo.contains(".")){
            mensajeToast("Ingrese un correo Valido");
        }else{
            return correo;
        }
        return null;
    }
    public String getPhone(){
        String phone = this.txtPhone.getText().toString().trim();
        if(phone.length()<=0){
            mensajeToast("Ingrese phone");
        }else if(phone.length() != 9) {
            mensajeToast("Ingrese phone 9 digito");
        }else{
            return phone;
        }
        return null;
    }
    public String getDate(){
        String date = this.txtDate.getText().toString().trim();
        if(date.length()<=0){
            mensajeToast("Ingrese Fecha");
        }else{
            return date;
        }
        return null;
    }
    public int getCategory(){
        int categoria = this.cboCategory.getSelectedItemPosition();
        if(categoria <=0){
            mensajeToast("Selecione una Categoria");
        }else {
            return categoria;
        }
        return -1;
    }

    private void mensaje(String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Registrado Correctamente");
        alert.setMessage(msg);
        alert.setCancelable(true);
        alert.show();
    }
    private void mensajeToast(String msg){
     Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


}