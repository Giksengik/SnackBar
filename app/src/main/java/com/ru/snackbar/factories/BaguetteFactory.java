package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.products.Meal;

public class BaguetteFactory implements IFactory {
    @Override
    public IProduct getProduct() {
        return new Meal("Багет",1, 35);
    }
}
