package com.example.healthy_choice;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AlertDialogTest extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());

        builder.setTitle("Confirm!");
        builder.setMessage("Are you sure you want to delete this item?");

        builder.setPositiveButton("Yes", null);
        builder.setNegativeButton("No", null);
        builder.show();
        return builder.create();
    }
}
