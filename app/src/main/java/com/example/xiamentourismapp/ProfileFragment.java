package com.example.xiamentourismapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {
    private ShapeableImageView userpic;
    private Button btnEditProfile, btnFavourite, btnChangePwd, btnLogout, btnDltAcc;
    private TextView tvUname, tvEmail;
    private DatabaseHelper databaseHelper;
    String userEmail, imageURL;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile,container,false);
        // link widgets
        userpic = view.findViewById(R.id.userImage);
        tvUname = view.findViewById(R.id.tv_username);
        tvEmail = view.findViewById(R.id.tv_email);
        btnLogout = view.findViewById(R.id.logout);
        btnDltAcc = view.findViewById(R.id.delete_acc);
        btnEditProfile = view.findViewById(R.id.btn_edit_profile);
        btnChangePwd = view.findViewById(R.id.btn_change_password);

        // retrieve session details
        SessionManager sessionManager = new SessionManager(getActivity());
        userEmail = sessionManager.getCurrentUserEmail();
        if (userEmail ==  null){
            Toast.makeText(getActivity(), "You haven't login!",Toast.LENGTH_SHORT).show();
            loadRegister();
        }

        // read data from database
        databaseHelper = new DatabaseHelper(getActivity());
        Cursor cursor = databaseHelper.getUserData(userEmail);
        if(cursor.getCount() == 0){
            // show error message
            Toast.makeText(getActivity(), "Error in reading Database!", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                tvEmail.setText(cursor.getString(0));
                tvUname.setText(cursor.getString(1));
                imageURL = cursor.getString(3);
            }
        }
        // read user profile image
        if(imageURL != null ){
            Uri image_uri = Uri.parse(imageURL);
            Picasso.get().load(image_uri).error(R.drawable.sample_profile).into(userpic, new Callback() {
                @Override
                public void onSuccess() {
                }
                @Override
                public void onError(Exception e) {
                    Log.d("ProfileError", e.getMessage().toString());
                }
            });
        }
        else{
            userpic.setImageResource(R.drawable.sample_profile);
        }
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment selectedFragment = new EditProfile();
                getChildFragmentManager().beginTransaction().replace(R.id.frame_container,selectedFragment).addToBackStack(null).commit();

            }
        });
        btnChangePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText resetPwd = new EditText(view.getContext());

                final AlertDialog.Builder pwdDialog = new AlertDialog.Builder(view.getContext());
                pwdDialog.setTitle("Reset Password ?");
                pwdDialog.setMessage("Enter new password with >6 characters.");
                pwdDialog.setView(resetPwd);

                pwdDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String newPwd = resetPwd.getText().toString().trim();
                        boolean isUpdate = databaseHelper.updateData(tvEmail.getText().toString(),tvUname.getText().toString(), newPwd);
                        if(isUpdate == true){
                            Toast.makeText(getActivity(), "Password Reset Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getActivity(), "Error! Unable to update password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                pwdDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                pwdDialog.create().show();

            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.setLogin(false,null);
                loadRegister();
            }
        });

        btnDltAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptMessage();
            }

            private void promptMessage() {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setCancelable(true);
                alertDialog.setTitle("Confirm Delete Account ("+userEmail+")?");
                alertDialog.setMessage("By killing the account, you will not be able to recover it.");
                alertDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Integer deletedRows = databaseHelper.deleteData(userEmail);
                        if(deletedRows > 0){
                            Toast.makeText(getActivity(), "You have killed your account!", Toast.LENGTH_SHORT).show();
                            sessionManager.setLogin(false,null);
                            loadRegister();
                        }

                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                });
                alertDialog.show();
            }
        });

        return view;
    }
    public void loadRegister(){
        Intent intent = new Intent(getActivity(), Register.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        // retrieve session details
        SessionManager sessionManager = new SessionManager(getActivity());
        userEmail = sessionManager.getCurrentUserEmail();
        if (userEmail ==  null){
            Toast.makeText(getActivity(), "You haven't login!",Toast.LENGTH_SHORT).show();
            loadRegister();
        }
        // read data from database
        databaseHelper = new DatabaseHelper(getActivity());
        Cursor cursor = databaseHelper.getUserData(userEmail);
        if(cursor.getCount() == 0){
            // show error message
            Toast.makeText(getActivity(), "Error in reading Database!", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {
                tvEmail.setText(cursor.getString(0));
                tvUname.setText(cursor.getString(1));
                imageURL = cursor.getString(3);
            }
        }
        if(imageURL != null ){
            Uri image_uri = Uri.parse(imageURL);
            Picasso.get().load(image_uri).error(R.drawable.sample_profile).into(userpic);
        }
    }


}
