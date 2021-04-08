package com.ru.snackbar.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.material.snackbar.Snackbar;
import com.ru.snackbar.models.Student;
import com.ru.snackbar.models.products.Snack;
import com.ru.snackbar.models.snackbar.SnackBar;

import java.util.ArrayList;
import java.util.List;

public class SnackBarRepository {
    private MutableLiveData<SnackBar> mSnackBar;

    public SnackBarRepository(List<Student> queue){
        mSnackBar = new MutableLiveData<>();
        SnackBar snackBar = new SnackBar(5,100);
        snackBar.setQueue(queue);
        mSnackBar.setValue(snackBar);
    }
    public void setSnackBar(SnackBar snackBar) {
        mSnackBar.setValue(snackBar);
    }
    public MutableLiveData<SnackBar> getSnackBar(){
        return mSnackBar;
    }
    public void startWorking(){
        new Thread(new ClientProcessing()).start();
    }
    class ClientProcessing implements Runnable {
        List<Student> allQueue = new ArrayList<>();
        SnackBar snackBar = mSnackBar.getValue();
        @Override
        public void run() {
            allQueue.addAll(snackBar.getQueue());
            for(Student student : allQueue){
                snackBar.currentProducts.clear();
                snackBar.currentProducts.addAll(student.getCart());
                snackBar.setSnackBarStatus(SnackBar.Status.ACCEPTANCE_OF_ORDER);
                mSnackBar.postValue(snackBar);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snackBar.setSnackBarStatus(SnackBar.Status.PAYMENT_FOR_THE_ORDER);
                mSnackBar.postValue(snackBar);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snackBar.setSnackBarStatus(SnackBar.Status.ISSUING_AN_ORDER);
                mSnackBar.postValue(snackBar);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snackBar.mQueue.remove(student);
                mSnackBar.postValue(snackBar);
            }
            snackBar.setSnackBarStatus(SnackBar.Status.INACTION);
            mSnackBar.postValue(snackBar);
        }
    }
}
