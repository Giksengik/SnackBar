package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.Drink;
import com.ru.snackbar.models.products.IProduct;

public class JuiceFactory implements IFactory {

    @Override
    public IProduct getProduct() {
        return new Drink("Juice",1, 20);
    }
}
