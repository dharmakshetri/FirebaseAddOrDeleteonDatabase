package co.firebaseaddordeleteondatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dharma kshetri(@dharma.kshetri@gmail.com) on 12/14/16.
 */
public class MainActivity extends AppCompatActivity {
    public static  final String TAG="FIREBASE";

    public  RecyclerView recyclerListView;
    public  UserAdapter myAdapter;
    public  EditText editTextName;
    public  EditText editTextCountry;
    public  EditText editTextWeight;
    public  static TextView  textViewEmptyView;
    Button buttonAdd;
    public  ProgressBar myProgressBar;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        // creating layout
        creatingLayouts();
    }
    public void creatingLayouts(){
        myProgressBar=(ProgressBar) findViewById(R.id.loader);
        textViewEmptyView = (TextView) findViewById(R.id.tvEmptyView);
        editTextName = (EditText) findViewById(R.id.nameEditText);
        editTextCountry=(EditText) findViewById(R.id.countryEditText);
        editTextWeight=(EditText) findViewById(R.id.weightEditText);
        buttonAdd = (Button) findViewById(R.id.addButton);
        recyclerListView=(RecyclerView) findViewById(R.id.recylerview_list);
        recyclerListView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter= new UserAdapter(this);
        updateAdapter();
        recyclerListView.setAdapter(myAdapter);
    }

    //add new user to database
    public void btnAddOnClick(View v) {

        String name = editTextName.getText().toString().trim();
        String country=editTextCountry.getText().toString().trim();
        double weight=Double.parseDouble(editTextWeight.getText().toString().trim());
        User user= new User(name, country, weight);

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Please enter name",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(country)) {
            Toast.makeText(getApplicationContext(), "Please enter country",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        updateDatabase(user);

    }

    // adding new user to end  the user using on firebase database
    public void updateDatabase(User user){

        databaseReference.child("users").push().setValue(user);

        editTextName.setText(null);
        editTextCountry.setText(null);
        editTextWeight.setText(null);

        updateAdapter();

    }

    //update adapter
    public void updateAdapter(){

       final List<User> listUsers= new ArrayList<>();
        databaseReference.child("users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                listUsers.add(dataSnapshot.getValue(User.class));
                displayUsers(listUsers);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Canceled",Toast.LENGTH_SHORT).show();
            }
        });


    }


    //display the user on Adapter
    public void displayUsers(List<User> ls){
        myProgressBar.setVisibility(View.GONE);
        textViewEmptyView.setVisibility(View.GONE);
        recyclerListView.setVisibility(View.VISIBLE);
        editTextName.setText(null);
        editTextCountry.setText(null);
        myAdapter.setData(ls);
        myAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
