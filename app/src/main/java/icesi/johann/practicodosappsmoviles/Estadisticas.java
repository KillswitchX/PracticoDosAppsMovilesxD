package icesi.johann.practicodosappsmoviles;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {

    private EditText estadisticasHeroes;

    public int i;

    public ArrayList<String> lista;

    DatabaseReference rtdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        estadisticasHeroes= findViewById(R.id.et_grupo_superheroes);
        rtdb = FirebaseDatabase.getInstance().getReference();
        lista = new ArrayList<String>();
        initHeroes();
    }

    public String initHeroes() {
        String spiderman = "Spiderman: " + "\n";
        String ironman = "Ironman: " + "\n";
        String capitanaMarvel = "Capitana Marvel: " + "\n";
        String capitanAmerica = "Capitan America: " + "\n";
        String hulk = "Hulk: " + "\n";
        String laViudaNegra = "La viuda negra: " + "\n";
        String Thor = "Thor: " + "\n";
        String DoctorStrange = "Doctor Strange: " + "\n";

        lista.add(spiderman);
        lista.add(ironman);
        lista.add(capitanaMarvel);
        lista.add(capitanAmerica);
        lista.add(hulk);
        lista.add(laViudaNegra);
        lista.add(Thor);
        lista.add(DoctorStrange);

        while (i<lista.size()){

        rtdb.child("hero").child(lista.get(i)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String num = dataSnapshot.getValue(String.class);
                lista.set(i, lista.get(i)+num);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    String sum = spiderman + ironman + capitanaMarvel + capitanAmerica + DoctorStrange + DoctorStrange + hulk + laViudaNegra;

        estadisticasHeroes.setText(sum);
        return "";
    }

}
