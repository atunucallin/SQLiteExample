package com.example.dj.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteContactFragment extends Fragment {

    private EditText Id;
    private Button bnDelete;


    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete_contact, container, false);

        Id = view.findViewById(R.id.bn_del_id);
        bnDelete = view.findViewById(R.id.bn_delete);

        bnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContact();
            }
        });



        return view;
    }

    public void deleteContact(){

        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getWritableDatabase();

        int id = Integer.parseInt(Id.getText().toString());

        contactDbHelper.deleteContact(id,database);
        contactDbHelper.close();
        Id.setText("");
        Toast.makeText(getActivity(), "Contact Removed succesfully", Toast.LENGTH_SHORT).show();

    }

}
