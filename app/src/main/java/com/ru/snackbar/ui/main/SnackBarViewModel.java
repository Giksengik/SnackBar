package com.ru.snackbar.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ru.snackbar.repositories.SnackBarRepository;
import com.ru.snackbar.models.Student;
import com.ru.snackbar.models.snackbar.SnackBar;

import java.util.List;

public class SnackBarViewModel extends AndroidViewModel {
    private SnackBarRepository mSnackBarRepository;
    private MutableLiveData<SnackBar> mSnackBar;
    public SnackBarViewModel(@NonNull Application application, List<Student> queue) {
        super(application);
        mSnackBarRepository = new SnackBarRepository(queue);
        mSnackBar = mSnackBarRepository.getSnackBar();
    }
    public LiveData<SnackBar> getSnackBars(){
        return mSnackBar;
    }
    public void startWorking(){
        mSnackBarRepository.startWorking();
    }
    public void setSnackBar(SnackBar snackBar) { mSnackBarRepository.setSnackBar(snackBar); }
}
