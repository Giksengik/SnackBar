package com.ru.snackbar.models.snackbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.android.material.snackbar.Snackbar;
import com.ru.snackbar.MainActivity;
import com.ru.snackbar.factories.BaguetteFactory;
import com.ru.snackbar.factories.BountyFactory;
import com.ru.snackbar.factories.CoffeeFactory;
import com.ru.snackbar.factories.IFactory;
import com.ru.snackbar.factories.JuiceFactory;
import com.ru.snackbar.factories.SandwichFactory;
import com.ru.snackbar.factories.ShaurmaFactory;
import com.ru.snackbar.factories.SnickersFactory;
import com.ru.snackbar.factories.TwixFactory;
import com.ru.snackbar.factories.WaterFactory;
import com.ru.snackbar.models.Student;
import com.ru.snackbar.models.products.IProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class SnackBar {
    private TreeMap<IProduct, Integer> mSnacks;
    public int snackBarNum;
    private int mSnacksNum;
    private Status snackBarStatus;
    private List<Student> mQueue;
    private List<IProduct> currentProducts =  new ArrayList<>();
    public SnackBar(int snackBarNum, int snacksNum){
        this.snackBarStatus = Status.INACTION;
        this.mSnacks = new TreeMap<>();
        this.snackBarNum = snackBarNum;
    }

    public static enum Status{
        INACTION, ACCEPTANCE_OF_ORDER , PAYMENT_FOR_THE_ORDER, ISSUING_AN_ORDER
    }


    public void setProducts(){
        List<IFactory> factories = new ArrayList<>();
        factories.add(new BaguetteFactory());
        factories.add(new BountyFactory());
        factories.add(new CoffeeFactory());
        factories.add(new JuiceFactory());
        factories.add(new SandwichFactory());
        factories.add(new ShaurmaFactory());
        factories.add(new SnickersFactory());
        factories.add(new TwixFactory());
        factories.add(new WaterFactory());
        Random rand = new Random();
        for(int i = 0; i < mSnacksNum; i++) {
            int randIndex = rand.nextInt(factories.size());
            int innerCount = mSnacks.getOrDefault(factories.get(randIndex).getProduct(), 0);
            mSnacks.put(factories.get(randIndex).getProduct(), innerCount + 1);
        }
    }
    public IProduct getProduct() {
        List<IProduct> products = new ArrayList<>(mSnacks.keySet());

        int randomProductIndex = new Random().nextInt(products.size());
        if (mSnacks.get(products.get(randomProductIndex)) > 0) {
            mSnacks.put(products.get(randomProductIndex),
                    mSnacks.get(products.get(randomProductIndex)) - 1);
            return products.get(randomProductIndex);
        } else {
            return null;
        }
    }
    public void setQueue(List<Student> students){
        mQueue = students;
    }
    public int getSnacksNum() {
        return mSnacksNum;
    }

    public Status getSnackBarStatus() {
        return snackBarStatus;
    }
    public void start(Activity activity) {
        ClientProcessing clientProcessing = new ClientProcessing(activity);
        clientProcessing.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
    class ClientProcessing extends AsyncTask<Void, Void, Void> {
            List<Student> allQueue = new ArrayList<>();
            Activity activity;
            ClientProcessing(Activity activity){
                this.activity = activity;
            }
            @SuppressLint("StaticFieldLeak")
            @Override
            protected Void doInBackground(Void... voids) {
                allQueue.addAll(mQueue);
                for(Student student : allQueue){
                    currentProducts.clear();
                    currentProducts.addAll(student.getCart());
                    snackBarStatus = SnackBar.Status.ACCEPTANCE_OF_ORDER;
                    publishProgress();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    snackBarStatus = SnackBar.Status.PAYMENT_FOR_THE_ORDER;
                    publishProgress();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    snackBarStatus = SnackBar.Status.ISSUING_AN_ORDER;
                    publishProgress();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mQueue.remove(student);
                    publishProgress();
                }
                snackBarStatus = SnackBar.Status.INACTION;
                return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                ((MainActivity) activity).updateUI(snackBarNum);
            }
        }

    public List<Student> getQueue() {
        return mQueue;
    }

    public List<IProduct> getCurrentProducts() {
        return currentProducts;
    }
    public List<String> getStudentsNameList(){
        List<String> list = new ArrayList<>();
        for(Student item : mQueue){
            list.add(item.getName());
        }
        return list;
    }
}
