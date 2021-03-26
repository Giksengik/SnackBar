package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.products.Snack;

public class TwixFactory implements IFactory {
    @Override
    public IProduct getProduct() {
        return new Snack("Twix", 1, 25);
    }
}
