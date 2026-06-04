package com.example.a29_04;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;

public class PhotoDialogFragment extends DialogFragment {

    private static final String ARG_IMAGE_ID = "image_id";

    public static PhotoDialogFragment newInstance(int imageResId) {
        PhotoDialogFragment fragment = new PhotoDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_ID, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_dialog, container, false);
        ImageView imageView = view.findViewById(R.id.dialog_image);
        imageView.setImageResource(getArguments().getInt(ARG_IMAGE_ID));
        return view;
    }
}