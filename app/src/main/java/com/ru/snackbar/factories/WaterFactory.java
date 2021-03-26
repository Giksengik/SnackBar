package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.Drink;
import com.ru.snackbar.models.products.IProduct;

public class WaterFactory implements IFactory {

    @Override
    public IProduct getProduct() {
        return new Drink("Water",1, 10);
    }
}
