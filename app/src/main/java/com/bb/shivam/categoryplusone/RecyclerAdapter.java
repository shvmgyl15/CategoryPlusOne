package com.bb.shivam.categoryplusone;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.shivam.categoryplusone.model.Category;

import java.util.ArrayList;

/**
 * Created by shivam on 27/08/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CategoryHolder> {

    private ArrayList<Category> mCategories;

    public RecyclerAdapter(ArrayList<Category> categories){
        mCategories = categories;
    }

    public class CategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tV;
        private Button bAdd, bDelete, bModify;
        private Context context;
        private Category mCategory;

        public CategoryHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            tV = (TextView) itemView.findViewById(R.id.tV);
            bAdd = (Button) itemView.findViewById(R.id.bAdd);
            bDelete = (Button) itemView.findViewById(R.id.bDelete);
            bModify = (Button) itemView.findViewById(R.id.bModify);

            bAdd.setOnClickListener(this);
            bDelete.setOnClickListener(this);
            bModify.setOnClickListener(this);
        }

        public void bindCategory(Category category){
            //string format for spaces from integer
            tV.setText(category.getDistance() + "-");
//            tV.setText(String.format("%" + category.getDistance()+1 + "s", ""));
            tV.append(category.getCategoryName());
        }

//        void addOrModifyCategoryDialogBox(String dialogTitle, final String editText) {
//
//            final Dialog dialog = new Dialog(context);
//            dialog.setContentView(R.layout.user_input_dialog_box);
//
//            final EditText userInputDialogEditText = (EditText) dialog.findViewById(R.id.userInputDialog);
//            userInputDialogEditText.setText(editText);
//
//            TextView tVDialogTitle = (TextView) dialog.findViewById(R.id.tVDialog);
//            tVDialogTitle.setText(dialogTitle);
//
//            Button dialogButtonSuccess = (Button) dialog.findViewById(R.id.btn_ok);
//            Button dialogButtonCancel = (Button) dialog.findViewById(R.id.btn_cancel);
//
//            dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dialog.dismiss();
//                }
//            });
//            dialogButtonSuccess.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    String enteredText = userInputDialogEditText.getText().toString();
//                    System.err.println(enteredText);
//                    if(!enteredText.isEmpty()) {
//                        if(editText == ""){
//                            Category category = new Category(enteredText, mCategories.get(getAdapterPosition()).getCategoryName(), mCategories.get(getAdapterPosition()).getDistance() + 1);
//                            addAt(category, getAdapterPosition());
//                        }else{
//                            mCategories.get(getAdapterPosition()).setCategoryName(enteredText);
//                            bindCategory(mCategories.get(getAdapterPosition()));
//                        }
//                    }
//                    dialog.dismiss();
//                }
//            });
//
//            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
//            dialog.show();
//
//
//        }


        void addOrModifyCategoryDialogBox(String dialogTitle, final String editText) {

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View dialogView = layoutInflater.inflate(R.layout.user_input_dialog_box, new LinearLayout(context), false);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(context);
            alertDialogBuilderUserInput.setView(dialogView);

            final EditText userInputDialogEditText = (EditText) dialogView.findViewById(R.id.userInputDialog);
            userInputDialogEditText.setText(editText);
            alertDialogBuilderUserInput
                    .setCancelable(false)
                    .setTitle(dialogTitle)
//                    .setMessage(dialogMessage)
                    .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String enteredText = userInputDialogEditText.getText().toString();
                            System.err.println(enteredText);
                            if(!enteredText.isEmpty()) {
                                if(editText == ""){
                                    Category category = new Category(enteredText, mCategories.get(getAdapterPosition()).getCategoryName(), mCategories.get(getAdapterPosition()).getDistance() + 1);
                                    addAt(category, getAdapterPosition() + 1);
                                }else{
                                    mCategories.get(getAdapterPosition()).setCategoryName(enteredText);
                                    bindCategory(mCategories.get(getAdapterPosition()));
                                }
                            }
                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilderUserInput.create();
            alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            alertDialog.show();
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            switch (view.getId()){
                case R.id.bAdd:
                    if(position == 0){
                        addOrModifyCategoryDialogBox("ADD CATEGORY", "");
                        return;
                    }
                    addOrModifyCategoryDialogBox("ADD SUB CATEGORY", "");
                    break;
                case R.id.bDelete:
                    if(position == 0){
                        Toast.makeText(context, "YOU CANNOT DELETE THE ROOT ELEMENT", Toast.LENGTH_SHORT);
                        bDelete.setEnabled(false);
                        return;
                    }
                    removeAt(position);
                    break;
                case R.id.bModify:
                    if(position == 0){
                        Toast.makeText(context, "YOU CANNOT MODIFY THE ROOT ELEMENT", Toast.LENGTH_SHORT);
                        bModify.setEnabled(false);
                        return;
                    }
                    addOrModifyCategoryDialogBox("EDIT SUB CATEGORY NAME", mCategories.get(position).getCategoryName());
                    break;
            }
        }

        public void removeAt(int position){
            mCategories.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mCategories.size());
        }

        public void addAt(Category category, int position){
            mCategories.add(position, category);
            notifyItemInserted(position);
            notifyItemRangeChanged(position, mCategories.size());
        }
    }

    @Override
    public RecyclerAdapter.CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);

        return new CategoryHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.CategoryHolder holder, int position) {
        holder.bindCategory(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }
}
