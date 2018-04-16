package com.example.dj.sqliteexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button bnSave,bnView, bnDelete, bnUpdate;
    onDbOperationListener dbOperationListener;


    public HomeFragment() {
        // Required empty public constructor
    }

    public interface onDbOperationListener{
        public void dBOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bnSave = view.findViewById(R.id.bn_add_contact);
        bnSave.setOnClickListener(this);
        bnView = view.findViewById(R.id.bn_view_contact);
        bnView.setOnClickListener(this);
        bnUpdate = view.findViewById(R.id.bn_update_contact);
        bnUpdate.setOnClickListener(this);
        bnDelete = view.findViewById(R.id.bn_delete_contact);
        bnDelete.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bn_add_contact:
                dbOperationListener.dBOpPerformed(0);
                break;
            case R.id.bn_view_contact:
                dbOperationListener.dBOpPerformed(1);
                break;
            case R.id.bn_update_contact:
                dbOperationListener.dBOpPerformed(2);
                break;
            case R.id.bn_delete_contact:
                dbOperationListener.dBOpPerformed(3);
                break;

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {
            dbOperationListener = (onDbOperationListener) activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement the interface method");
        }

    }
}
