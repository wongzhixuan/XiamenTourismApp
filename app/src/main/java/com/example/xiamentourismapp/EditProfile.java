package com.example.xiamentourismapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;


public class EditProfile extends Fragment {
    private ImageButton btnClose, btnChangePic;
    private ShapeableImageView profileImage;
    private EditText etEmail, etName;
    private Button btn_save;
    String userEmail;
    private DatabaseHelper databaseHelper;
    String imageURL;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.edit_profile_fragment,container,false);

        // link widgets
        btn_save = view.findViewById(R.id.btn_saveprofile);
        btnClose = view.findViewById(R.id.btn_close);
        btnChangePic = view.findViewById(R.id.btn_changePic);
        profileImage = view.findViewById(R.id.profile_image);
        etEmail = view.findViewById(R.id.etEmail_profile);
        etName = view.findViewById(R.id.etName_profile);


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
                etEmail.setText(cursor.getString(0));
                etName.setText(cursor.getString(1));
                imageURL = cursor.getString(3);
            }
        }

        // read user profile image
        if(imageURL != null && imageURL.length() > 0){
            Uri image_uri = Uri.parse(imageURL);
            Picasso.get().load(image_uri).error(R.drawable.sample_profile).into(profileImage);
        }


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = databaseHelper.updateName(userEmail, etName.getText().toString().trim());
                if(isUpdate == true){
                    Toast.makeText(getActivity(), "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Error! Profile Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnChangePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open gallery
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1000);

            }
        });


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().popBackStack();
            }
        });
        return view;
    }
    // Change profile Image
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                profileImage.setImageURI(imageUri);
                databaseHelper = new DatabaseHelper(getActivity());
                String imageURL = imageUri.toString();
                boolean isUpdated = databaseHelper.updateImage(userEmail, imageURL);
                if(isUpdated == true){
                    Toast.makeText(getActivity(),"Image Updated!",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void loadRegister(){
        Intent intent = new Intent(getActivity(), Register.class);
        startActivity(intent);
    }
}
