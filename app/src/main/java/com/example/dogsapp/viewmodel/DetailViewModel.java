package com.example.dogsapp.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dogsapp.model.DogBreed;
import com.example.dogsapp.model.DogDao;
import com.example.dogsapp.model.DogDatabase;

public class DetailViewModel extends AndroidViewModel {

    public MutableLiveData<DogBreed> dogLiveData = new MutableLiveData<>();

    private AsyncTask<Integer, Void, DogBreed> retrieveDogTask;

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetch(int Uuid){
        retrieveDogTask = new RetrieveDogTask();
        retrieveDogTask.execute(Uuid);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        if (retrieveDogTask != null){
            retrieveDogTask.cancel(true);
            retrieveDogTask = null;
        }
    }

    private class RetrieveDogTask extends AsyncTask<Integer, Void, DogBreed>{

        @Override
        protected DogBreed doInBackground(Integer... integers) {
            return DogDatabase.getInstance(getApplication()).dogDao().getDog(integers[0]);
        }

        @Override
        protected void onPostExecute(DogBreed dogBreed) {
            dogLiveData.setValue(dogBreed);
        }
    }
}
