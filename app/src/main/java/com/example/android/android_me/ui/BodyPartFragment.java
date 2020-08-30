package com.example.android.android_me.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class BodyPartFragment extends Fragment {
    public  static  final String Image_Id_List="image_id";
    public static final String List_Index="List_index";
private List<Integer> mImageIds;
private int mListIndex;
public BodyPartFragment(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    if (savedInstanceState!=null){
        mImageIds=savedInstanceState.getIntegerArrayList(Image_Id_List);
        mListIndex=savedInstanceState.getInt(List_Index);
    }
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView=rootView.findViewById(R.id.body_part_image_view);
      if (mImageIds!=null){
          imageView.setImageResource(mImageIds.get(mListIndex));
      } else {
          Log.v(TAG,"This fragment has a null list of image id's");
      }
      imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              if (mListIndex<mImageIds.size()-1){
                  mListIndex++;
              }
              else{
                  mListIndex=0;
              }
              imageView.setImageResource(mImageIds.get(mListIndex));
          }
      });
        return rootView;
    }
public void setmImageIds(List<Integer> imageIds){
mImageIds= imageIds;
}
public void setmListIndex(int index){
    mListIndex=index;
}
@Override
    public  void onSaveInstanceState(Bundle currentState){
 currentState.putIntegerArrayList(Image_Id_List,(ArrayList<Integer>) mImageIds);
 currentState.putInt(List_Index,mListIndex);
    }
}
