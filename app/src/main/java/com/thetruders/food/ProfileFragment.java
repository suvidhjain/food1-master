package com.thetruders.food;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.support.v4.media.MediaBrowserServiceCompat.RESULT_OK;

public class ProfileFragment extends Fragment {


    public CircleImageView mCircleImage;
    int PICK_IMAGE_REQUEST = 200;
    View view;
    public static  Bitmap mBitmap=null;

//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);

//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("$$$$$$", "onCreateView");
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        mCircleImage =  view.findViewById(R.id.profile_image) ;
        if(mBitmap!=null)
        {
            mCircleImage.setImageBitmap(mBitmap);
            mCircleImage.setRotation(90);
        }

        mCircleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetImage();
                Log.d("$$$$$$","OnClick");
            }
        });
        return view;
    }

    void GetImage() {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode ==PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
            Uri uri = data.getData();

            try {
                mBitmap  = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver() , uri);
                mCircleImage.setImageBitmap(mBitmap);
//                mCircleImage.setRotation(90);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
