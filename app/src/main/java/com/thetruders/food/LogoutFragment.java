package com.thetruders.food;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;



public class LogoutFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    View view;
    Button mButton;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_logout, container, false);
        mButton = view.findViewById(R.id.btnSignOut);
        context = view.getContext();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("OnLogout==","LogOutttt");
                Intent intent = new Intent(context,LoginActivity.class);
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getActivity().startActivity(intent);
//                getActivity().finish();
//                System.exit(0);

            }
        });
        return view;
    }


//    private FirebaseAuth firebaseAuth;
//    public FirebaseAuth.AuthStateListener authStateListener;
//    View view;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState){
//
//        Log.d("######", "onCreateView: ");
//        view = inflater.inflate(R.layout.fragment_logout,container,false );
//
//
//            Button btnSignOut = getView().findViewById(R.id.btnSignOut);
//            btnSignOut.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    FirebaseAuth.getInstance().signOut();
//                    Intent I = new Intent(getActivity(),HomeFragment.class);
//                    startActivity(I);
//                }
//            });
//
//
//        return view;
//    }

}
