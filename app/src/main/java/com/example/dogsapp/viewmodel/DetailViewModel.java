package com.example.dogsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dogsapp.model.DogBreed;

public class DetailViewModel extends ViewModel {

    public MutableLiveData<DogBreed> dogLiveData = new MutableLiveData<>();

    public void fetch(){
        DogBreed dog = new DogBreed("1", "corgi", "15 years", "", "companionship" , "calm and friendly", "");
        dogLiveData.setValue(dog);
    }
}
