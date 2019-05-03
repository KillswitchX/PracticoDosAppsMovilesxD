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
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

import icesi.johann.practicodosappsmoviles.model.Register;

public class Estadisticas extends AppCompatActivity {

    public static final String SPIDERMAN = "Spiderman";
    public static final String IRONMAN = "Ironman";
    public static final String CAPITAN_AMERICA = "Capitan America";
    public static final String CAPITANA_MARVEL = "Capitana Marvel";
    public static final String HULK = "Hulk";
    public static final String LA_VIUDA_NEGRA = "La Viuda Negra";
    public static final String THOR = "Thor";
    public static final String DOCTOR_STRANGE = "Doctor Strange";

    private EditText estadisticasHeroes;

    public int i;

    public ArrayList<String> lista;

    DatabaseReference rtdb;

    public int totalVotos = 0;

    public ArrayList<Register> registers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        estadisticasHeroes= findViewById(R.id.et_grupo_superheroes);
        rtdb = FirebaseDatabase.getInstance().getReference();
        lista = new ArrayList<String>();
        registers = new ArrayList<>();
        String text = "";
        rtdb.child("Registers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot c:dataSnapshot.getChildren()) {
                    Register r = c.getValue(Register.class);
                    registers.add(r);
                }
            }

            @Override


            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        int y = totalVotos();
        int f = registers.size();
        text+=y;
        estadisticasHeroes.setText(text +"   "  + f);

        //initHeroes();
    }

    public String initHeroes() {
        String spiderman = "Spiderman: ";
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



        }


    String sum = spiderman + "\n" + ironman + "\n" + capitanaMarvel + "\n" + capitanAmerica + "\n" +
            DoctorStrange + "\n" + DoctorStrange + "\n" + hulk + "\n" + laViudaNegra + "\n";

        estadisticasHeroes.setText(sum);
        return "";
    }

    public int totalVotos(){
        rtdb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot c:dataSnapshot.getChildren()) {
                    Register r = c.getValue(Register.class);
                    registers.add(r);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return totalVotos;
    }

    public int porcentaje(int a, int b){
        return  (a*100)/b;

    }

}
