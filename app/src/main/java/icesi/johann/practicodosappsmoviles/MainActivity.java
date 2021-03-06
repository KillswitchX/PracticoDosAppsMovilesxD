package icesi.johann.practicodosappsmoviles;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import icesi.johann.practicodosappsmoviles.model.Register;

public class MainActivity extends AppCompatActivity {

    private RadioGroup grupo_grupo;

    private RadioGroup grupo_superheroes;

    public Dialog epicDialog;

    private ImageView close_popup;

    private Button btn_grupos_personas;

    private Button getBtn_grupos_superheroes;

    private int cont_spiderman, cont_ironman, cont_capitanaMarvel, cont_capitanAmerica,

    cont_hulk,cont_laViudaNegra, cont_thor, cont_doctorStrange;

    private int total_votos;

    private int cont_mujeresAdultas, cont_hombresAdultos, cont_mujeresAdolescentes, cont_hombresAdolescentes,

    cont_niños;

    private Button btn_aceptar;

    //private FirebaseAuth mAuth;

    DatabaseReference rtdb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        epicDialog = new Dialog(this);
        grupo_grupo = findViewById(R.id.rg_grupos);
        grupo_superheroes = findViewById(R.id.rg_superheroes);
        btn_aceptar = findViewById(R.id.btn_aceptarEncuesta);
        //mAuth = FirebaseAuth.getInstance();
        rtdb = FirebaseDatabase.getInstance().getReference();
        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = grupo_grupo.getCheckedRadioButtonId();
                int b = grupo_superheroes.getCheckedRadioButtonId();


                if(grupo_grupo.getCheckedRadioButtonId() != -1){

                    if(grupo_superheroes.getCheckedRadioButtonId() != -1){

                        String group = "";
                        if(i == R.id.Mujeres_adultas){
                            cont_mujeresAdultas++;

                            group = "mujeres_adultas";
                        }
                        else if(i == R.id.Hombres_adultos){
                            cont_hombresAdultos++;

                            group = "hombres adultos";
                        }
                        else if (i == R.id.Mujeres_adolescentes){
                            cont_hombresAdolescentes++;

                            group = "mujeres adolescentes";
                        }
                        else if(i == R.id.Hombres_adolescentes){
                            cont_hombresAdolescentes++;

                            group = "hombres adolescentes";
                        }
                        else if(i == R.id.niños){
                            cont_niños++;

                            group = "niños";
                        }


                        if(b == R.id.spiderman){
                            cont_spiderman++;
                            total_votos++;
                            int x = porcentaje(cont_spiderman, total_votos);
                            Register r = new Register(group,"Spiderman");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else if(b == R.id.ironman){
                            cont_ironman++;
                            total_votos++;
                            int x = porcentaje(cont_ironman, total_votos);
                            Register r = new Register(group,"Ironman");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else if (b == R.id.capitan_america){
                            cont_capitanAmerica++;
                            total_votos++;
                            int x = porcentaje(cont_capitanAmerica, total_votos);
                            Register r = new Register(group,"Capitan America");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else if(b == R.id.capitana_marvel){
                            cont_capitanaMarvel++;
                            total_votos++;
                            int x = porcentaje(cont_capitanaMarvel, total_votos);
                            Register r = new Register(group,"Capitana Marvel");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else if(b == R.id.hulk){
                            cont_hulk++;
                            total_votos++;
                            int x = porcentaje(cont_hulk, total_votos);
                            Register r = new Register(group,"Hulk");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else if(b == R.id.la_viuda_negra){
                            cont_laViudaNegra++;
                            total_votos++;
                            int x = porcentaje(cont_laViudaNegra, total_votos);
                            Register r = new Register(group,"La Viuda Negra");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else if(b == R.id.thor){
                            cont_thor++;
                            total_votos++;
                            int x = porcentaje(cont_thor, total_votos);
                            Register r = new Register(group,"Thor");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                        else if(b == R.id.doctor_strange){
                            cont_doctorStrange++;
                            total_votos++;
                            int x = porcentaje(cont_doctorStrange,total_votos);
                            Register r = new Register(group,"Doctor Strange");
                            rtdb.child("Registers").push().setValue(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    //Toast.makeText(getApplicationContext(), "Usted ha votado satisfactoriamente", Toast.LENGTH_LONG).show();
                                    Toast.makeText(getApplicationContext(), ""+totalVotos(), Toast.LENGTH_LONG).show();
                                }
                            });
                        }




                        showPopup();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Seleccione un superheroe", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Seleccione un grupo", Toast.LENGTH_SHORT).show();
                }



            }
        });

        grupo_grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });

        grupo_superheroes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
            }
        });
    }

    private void showPopup(){



        epicDialog.setContentView(R.layout.epic_popup);

        close_popup = (ImageView) epicDialog.findViewById(R.id.btn_cerrar);

        btn_grupos_personas = epicDialog.findViewById(R.id.btn_grupos_personas);

        getBtn_grupos_superheroes = epicDialog.findViewById(R.id.btn_grupos_superheroes);



        close_popup.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                epicDialog.dismiss();

            }

        });
        btn_grupos_personas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        getBtn_grupos_superheroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Estadisticas.class);
                startActivity(i);
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        epicDialog.show();

    }

    public int porcentaje(int a, int b){
        return  (a*100)/b;

    }

    public int totalVotos =0;

    public int totalVotos(){
        rtdb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                totalVotos= (int) (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return totalVotos;
    }


}
