package com.example.dj.sqliteexample;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {

    private TextView text_display;


    public ReadContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_contacts, container, false);

        text_display = view.findViewById(R.id.text_display);
        readContacts();

        return view;
    }

    private void readContacts(){

        // use seprate thread
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.readContacts(database);

        String info = "";
        while (cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            info = info+"\n\n"+ " ID: "+ id+"\nName: "+name+ "\nEmail: "+ email;
        }

        text_display.setText(info);
        contactDbHelper.close();
    }

}
