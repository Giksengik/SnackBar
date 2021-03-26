package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.Drink;
import com.ru.snackbar.models.products.IProduct;

public class CoffeeFactory implements IFactory {

    @Override
    public IProduct getProduct() {
        return new Drink("Coffee", 1, 40);
    }
}
