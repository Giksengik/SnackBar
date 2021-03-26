package com.ru.snackbar.models;

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
import com.ru.snackbar.models.products.IProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private List<IProduct> mCart;
    private String mName;
    public Student(String name){
        mCart = new ArrayList<>();
        this.mName = name;
        setCart();
    }
    private void setCart(){
        Random rand = new Random();
        List<IFactory> drinkFactories =  new ArrayList<>();
        List<IFactory> snackFactories =  new ArrayList<>();
        List<IFactory> mealFactories = new ArrayList<>();
        drinkFactories.add(new WaterFactory());
        drinkFactories.add(new JuiceFactory());
        drinkFactories.add(new CoffeeFactory());
        snackFactories.add(new SnickersFactory());
        snackFactories.add(new TwixFactory());
        snackFactories.add(new BountyFactory());
        mealFactories.add(new ShaurmaFactory());
        mealFactories.add(new BaguetteFactory());
        mealFactories.add(new SandwichFactory());
        mCart.add(drinkFactories.get(rand.nextInt(drinkFactories.size())).getProduct());
        mCart.add(mealFactories.get(rand.nextInt(drinkFactories.size())).getProduct());
        mCart.add(snackFactories.get(rand.nextInt(drinkFactories.size())).getProduct());
    }
    public List<IProduct> getCart(){
        return mCart;
    }
    public String getName(){
        return mName;
    }
}
