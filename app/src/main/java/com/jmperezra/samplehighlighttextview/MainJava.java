package com.jmperezra.samplehighlighttextview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.jmperezra.commons.Eval;
import com.jmperezra.commons.None;
import com.jmperezra.commons.Some;
import com.jmperezra.highlighttextview.HighlightTextLimit;
import com.jmperezra.highlighttextview.HighlightTextView;
import com.jmperezra.highlighttextview.HighlightTextViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainJava extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initExamples();
    }

    private void initExamples() {
        initExample8();
        initExample9();
        initExample10();
        initExample11();
    }

    private void initExample8() {
        HighlightTextView htv = findViewById(R.id.htvExample8);
        htv.renderHighlightViewModels(Collections.singletonList(buildMinConfigViewModel()));
    }

    private void initExample9() {
        HighlightTextView htv = findViewById(R.id.htvExample9);
        htv.renderHighlightViewModels(Collections.singletonList(buildFullConfigViewModel()));
    }

    private void initExample10() {
        HighlightTextView htv = findViewById(R.id.htvExample10);
        htv.renderHighlightViewModels(Collections.singletonList(buildWithEventConfigViewModel()));
    }

    private void initExample11() {
        HighlightTextView htv = findViewById(R.id.htvExample11);
        List<HighlightTextViewModel> viewModels = new ArrayList<>();
        viewModels.add(buildRedViewModel());
        viewModels.add(buildGreenViewModel());
        viewModels.add(buildOrangeViewModel());
        htv.renderHighlightViewModels(viewModels);
    }

    private HighlightTextViewModel buildMinConfigViewModel() {
        return new HighlightTextViewModel(getText(R.string.example8_text_to_highlight).toString(),
                R.style.Link, None.INSTANCE, 0, new HighlightTextLimit.Default(), false);
    }

    private HighlightTextViewModel buildFullConfigViewModel() {
        return new HighlightTextViewModel(getText(R.string.example9_text_to_highlight).toString(),
                R.style.Link, None.INSTANCE, 0, new HighlightTextLimit.All(), true);
    }

    private HighlightTextViewModel buildWithEventConfigViewModel() {
        return new HighlightTextViewModel(getText(R.string.example10_text_to_highlight).toString(),
                R.style.Link, new Some<>(new Eval(view -> {
                    showHelloWorldToast();
                    return null;
        })), 0, new HighlightTextLimit.NumLimit(1), true);
    }

    private HighlightTextViewModel buildRedViewModel() {
        return new HighlightTextViewModel(
                getText(R.string.example11_text_to_highlight_1).toString(), R.style.Red,
                new Some<>(new Eval(view -> {
                    showRedToast();
                    return null;
                })), 0, new HighlightTextLimit.All(), true);
    }

    private HighlightTextViewModel buildGreenViewModel() {
        return new HighlightTextViewModel(
                getText(R.string.example11_text_to_highlight_2).toString(),
                R.style.Green,
                None.INSTANCE,
                0, new HighlightTextLimit.NumLimit(1), true);
    }

    private HighlightTextViewModel buildOrangeViewModel() {
        return new HighlightTextViewModel(
                getText(R.string.example11_text_to_highlight_3).toString(),
                R.style.Orange,
                new Some<>(new Eval(view -> {
                    showOrangeToast();
                    return null;
                })),
                0, new HighlightTextLimit.First(), true);
    }

    private void showHelloWorldToast() {
        Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT).show();
    }

    private void showOrangeToast() {
        Toast.makeText(this, R.string.hello_orange_world, Toast.LENGTH_SHORT).show();
    }

    private void showRedToast() {
        Toast.makeText(this, R.string.hello_red_world, Toast.LENGTH_SHORT).show();
    }
}
