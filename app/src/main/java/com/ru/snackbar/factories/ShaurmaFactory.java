package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.products.Meal;
import com.ru.snackbar.models.products.Snack;

public class ShaurmaFactory implements IFactory {
    @Override
    public IProduct getProduct() {
        return new Meal("Шаурма", 1 , 50);
    }
}
