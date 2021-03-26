package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.products.Snack;

public class SnickersFactory implements IFactory {
    @Override
    public IProduct getProduct() {
        return new Snack("Snickers", 1, 30);
    }
}
