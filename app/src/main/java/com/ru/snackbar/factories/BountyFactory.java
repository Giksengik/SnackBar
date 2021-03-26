package com.ru.snackbar.factories;

import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.products.Snack;

public class BountyFactory implements IFactory {

    @Override
    public IProduct getProduct() {
        return new Snack("Bounty",1, 20);
    }
}
