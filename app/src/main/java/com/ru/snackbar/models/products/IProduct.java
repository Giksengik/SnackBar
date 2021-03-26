package com.ru.snackbar.models.products;

public abstract class IProduct implements Comparable<IProduct> {
    private String mName;
    private int mQuantity;
    private int mCost;
    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuontity(int quontity) {
        this.mQuantity = quontity;
    }

    public int getCost() {
        return mCost;
    }

    public void setCost(int cost) {
        this.mCost = cost;
    }

    public IProduct(String mName, int mQuantity, int mCost) {
        this.mName = mName;
        this.mQuantity = mQuantity;
        this.mCost = mCost;
    }

    @Override
    public int compareTo(IProduct o) {
        return this.getName().compareTo(o.getName());
    }
}
