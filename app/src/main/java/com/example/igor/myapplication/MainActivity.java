package com.example.igor.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.igor.myapplication.di.AppComponentBuilder;
import com.example.igor.myapplication.di.DaggerAppComponentBuilder;
import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text_any)
    TextView mTextView;

    private static AppComponentBuilder mAppComponentBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppComponentBuilder = DaggerAppComponentBuilder.builder().build();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String string = mAppComponentBuilder.get();
        mTextView.setText(string);

        Observable<CharSequence> observable = RxTextView.textChanges(mTextView);
        observable
//                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::show);
    }

    private void show(CharSequence charSequence) {
        new Handler().postDelayed(()->Toast.makeText(this, charSequence, Toast.LENGTH_SHORT).show(),1000);
    }
}
