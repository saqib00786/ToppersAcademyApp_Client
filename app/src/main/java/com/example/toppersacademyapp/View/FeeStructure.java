package com.example.toppersacademyapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.toppersacademyapp.R;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

public class FeeStructure extends Fragment {

    private Thread thread;

    private MaterialCheckBox mEnglish, mPhysics, mChemistry, mComputer, mMath, mProgramming, mPsychology, mBiology;
    private MaterialTextView mFee, mDiscount;
    private static int fee = 0;
    private static int discount_fee = 0;
    public static int i=0;

    public FeeStructure() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fee_structure, container, false);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();

        //todo: ID Assignment

        mEnglish = view.findViewById(R.id.englishID);
        mPhysics = view.findViewById(R.id.physicsID);
        mChemistry = view.findViewById(R.id.chemistryID);
        mComputer = view.findViewById(R.id.computerID);
        mProgramming = view.findViewById(R.id.programmingID);
        mMath = view.findViewById(R.id.mathID);
        mPsychology = view.findViewById(R.id.psychologyID);
        mBiology = view.findViewById(R.id.biologyID);

        mFee = view.findViewById(R.id.totalFeeID);
        mDiscount = view.findViewById(R.id.discountID);

        setUpdateFun();


        return view;
    }

    private void setUpdateFun() {
        mEnglish.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });
        mPhysics.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });
        mChemistry.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });
        mComputer.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });
        mProgramming.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });
        mMath.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });
        mPsychology.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });
        mBiology.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                UpdateThread();
            }
            if (!isChecked) {
                UpdateNewThread();
            }
        });

    }

    private void UpdateThread() {
        thread = new Thread() {
            @Override
            public void run() {
                try {

                    Thread.sleep(50);
                    getActivity().runOnUiThread(() -> {
                        fee = fee + 800;
                        if (fee >= 1600) {
                            discount_fee = fee - (fee * 6 / 100)-(i+=2);

                            String value = String.valueOf(fee);
                            String dis = String.valueOf(discount_fee);

                            mFee.setText("Rs. " + value);
                            mDiscount.setText("Rs. " + dis);
                        } else {

                            discount_fee = fee - (fee * 6 / 100)-(i+=2);

                            String value = String.valueOf(fee);
                            String dis = String.valueOf(discount_fee);

                            mFee.setText("Rs. " + value);
                            mDiscount.setText("Rs. " + dis);
                        }

                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();


    }

    private void UpdateNewThread() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                    getActivity().runOnUiThread(() -> {
                        fee = fee - 800;
                        if (fee >= 1600) {
                            discount_fee = fee - (fee * 6 / 100)-(i-=2);

                            String value = String.valueOf(fee);
                            String dis = String.valueOf(discount_fee);

                            mFee.setText("Rs. " + value);
                            mDiscount.setText("Rs. " + dis);
                        } else {

                            discount_fee = fee - (fee * 6 / 100)-(i-=2);

                            String value = String.valueOf(fee);
                            String dis = String.valueOf(discount_fee);

                            mFee.setText("Rs. " + value);
                            mDiscount.setText("Rs. " + dis);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();


    }

    @Override
    public void onDetach() {
        super.onDetach();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().hide();

        if (!(mBiology.isChecked() && mPsychology.isChecked() && mMath.isChecked()
                && mProgramming.isChecked() && mChemistry.isChecked() && mPhysics.isChecked()
                && mComputer.isChecked() && mEnglish.isChecked())) {
            Thread.currentThread().interrupt();
            thread = null;

        }
    }
}