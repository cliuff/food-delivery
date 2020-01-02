package com.cqut.cat.se.fooddelivery.diy;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GeneralViewModel extends ViewModel {
    public MutableLiveData<GeneralActivity.WindowInsets> windowInsets = new MutableLiveData<>();
}
