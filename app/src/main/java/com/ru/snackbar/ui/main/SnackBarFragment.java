package com.ru.snackbar.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.snackbar.R;
import com.ru.snackbar.adapters.BuyAdapter;
import com.ru.snackbar.adapters.QueueAdapter;
import com.ru.snackbar.models.Student;
import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.snackbar.SnackBar;
import com.ru.snackbar.ui.main.SnackBarViewModel;

import java.util.ArrayList;
import java.util.List;

public class SnackBarFragment extends Fragment {
    private static final String AUTOMAT_NAME = "Автомат ";
    private static final String INACTIVE_STATUS = "Ожидание";
    private static final String ISSUING_AN_ORDER_STATUS = "Прием заказа";
    private static final String PAYMENT_FOR_THE_ORDER_STATUS = "Оплата заказа";
    private static final String ACCEPTANCE_OF_ORDER_STATUS = "Выдача заказа";
    private SnackBarViewModel mViewModel;
    private List<Student> startingQueue;
    TextView automatName;
    TextView customerName;
    TextView snackBarStatus;
    RecyclerView shoppingList;
    RecyclerView queueList;
    TextView totalCost;
    public SnackBarFragment(List<Student> queue){
        startingQueue = queue;
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_snackbar,container,false);
        automatName = root.findViewById(R.id.automatName);
        customerName = root.findViewById(R.id.customerName);
        shoppingList = root.findViewById(R.id.shoppingList);
        queueList = root.findViewById(R.id.queueList);
        totalCost = root.findViewById(R.id.totalCost1);
        snackBarStatus = root.findViewById(R.id.snackBarStatus);
        BuyAdapter buyAdapter = new BuyAdapter();
        QueueAdapter queueAdapter = new QueueAdapter();
        shoppingList.setLayoutManager(new LinearLayoutManager(getContext()));
        queueList.setLayoutManager(new LinearLayoutManager(getContext()));
        shoppingList.setAdapter(buyAdapter);
        queueList.setAdapter(queueAdapter);
        mViewModel.getSnackBars().observe(getViewLifecycleOwner(), new Observer<SnackBar>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(SnackBar snackBar) {
                if (snackBar.getSnackBarStatus() == SnackBar.Status.INACTION) {
                    automatName.setText(AUTOMAT_NAME);
                    customerName.setText("");
                    buyAdapter.setProducts(new ArrayList<>());
                    totalCost.setText("");
                    snackBarStatus.setText(INACTIVE_STATUS);
                } else {
                    if (snackBar.getQueue().size() != 0) {
                        customerName.setText(snackBar.getQueue().get(0).getName());
                    }
                    buyAdapter.setProducts(snackBar.getCurrentProducts());
                    totalCost.setText(getCost(snackBar.getCurrentProducts()) + " ");
                    snackBarStatus.setText(chooseState(snackBar.getSnackBarStatus()));
                    queueAdapter.setPersons(snackBar.getStudentsNameList());
                }

        }});
        mViewModel.startWorking();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new SnackBarViewModel(getActivity().getApplication(),startingQueue);
    }
    public int getCost(List<IProduct> products){
        int cost = 0;
        for(IProduct item : products){
            cost += item.getCost();
        }
        return cost;
    }
    public String chooseState(SnackBar.Status status){
        switch(status){
            case ISSUING_AN_ORDER:
                return ISSUING_AN_ORDER_STATUS;
            case PAYMENT_FOR_THE_ORDER:
                return PAYMENT_FOR_THE_ORDER_STATUS;
            case ACCEPTANCE_OF_ORDER:
                return ACCEPTANCE_OF_ORDER_STATUS;
        }
        return "";
    }
}
