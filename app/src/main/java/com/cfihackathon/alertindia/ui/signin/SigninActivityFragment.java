package com.cfihackathon.alertindia.ui.signin;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cfihackathon.alertindia.R;
import com.google.android.gms.common.SignInButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class SigninActivityFragment extends Fragment
        implements View.OnClickListener {

    private SignInButton mSignInButton;
    private OnFragmentInteractionListener mListener;

    public SigninActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);

        // Large sign-in
        mSignInButton = (SignInButton) rootView.findViewById(R.id.sign_in_button);
        mSignInButton.setSize(SignInButton.SIZE_WIDE);

        mSignInButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSignInButton.setOnClickListener(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                // User clicked the sign-in button, so begin the sign-in process
                mListener.onSignIn();
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        void onSignIn();
    }
}
