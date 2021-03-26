package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.products.Meal;

public class SandwichFactory implements IFactory {
    @Override
    public IProduct getProduct() {
        return new Meal("Сэндвич", 1, 30);
    }
}
