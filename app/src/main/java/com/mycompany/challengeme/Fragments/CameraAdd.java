package com.mycompany.challengeme.Fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mycompany.challengeme.ChallengeSet;
import com.mycompany.challengeme.MainActivity;
import com.mycompany.challengeme.R;
import com.mycompany.challengeme.Singleton;

import java.io.File;
import java.util.ArrayList;

import static com.mycompany.challengeme.R.layout.fragment_camera_add_challenge;

/**
 * Created by joshua on 5/22/2016.
 */



public class CameraAdd extends Fragment {

    int i =0;
    ArrayList<ChallengeSet> objects;
    Button bSave;
    Button bBack;
    ImageView mImageView;
    static final int CAM_REQUEST = 1;
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);


    }
    private File getFile(){
        File folder = new File("sdcard/camera_app");
        if(!folder.exists()){
            folder.mkdir();
        }
       // File image_file = new File(folder,"cam_image"+i+".jpg");
        File image_file = new File(folder,"cam_image.jpg");
        return image_file;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        String path ="sdcard/camera_app/cam_image.jpg";
        mImageView.setImageDrawable(Drawable.createFromPath(path));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstance){
        View v = inflater.inflate(fragment_camera_add_challenge , parent , false);
       // final String value = getArguments().getString("Title");
        mImageView = (ImageView)v.findViewById(R.id.imageView);
        objects = Singleton.get(getActivity()).getChallenges();

        bSave = (Button) v.findViewById(R.id.bStartImage);
        bBack = (Button) v.findViewById(R.id.bReturn);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent cam_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
/*
                for(i = 0;i < objects.size(); i++)
                {
                    if(value.equals(objects.get(i).getTitle()))
                    {
                        objects.get(i).setF1(file);
                    }
                }
*/
                cam_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(cam_intent,CAM_REQUEST);

            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(),MainActivity.class);
                startActivity(i);

                /*Fragment newFragment = new Challenges();
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.fFragmentContainer, newFragment)
                        .commit();*/

            }
        });



        return v;
    }
}
