package com.ru.snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.ru.snackbar.adapters.BuyAdapter;
import com.ru.snackbar.adapters.QueueAdapter;
import com.ru.snackbar.models.Student;
import com.ru.snackbar.models.products.IProduct;
import com.ru.snackbar.models.snackbar.SnackBar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String AUTOMAT_NAME = "Автомат ";
    private static final String INACTIVE_STATUS = "Ожидание";
    private static final String ISSUING_AN_ORDER_STATUS = "Прием заказа";
    private static final String PAYMENT_FOR_THE_ORDER_STATUS = "Оплата заказа";
    private static final String ACCEPTANCE_OF_ORDER_STATUS = "Выдача заказа";
    SnackBar snackBar1;
    SnackBar snackBar2;
    SnackBar snackBar3;
    SnackBar snackBar4;
    BuyAdapter buyAdapter1;
    BuyAdapter buyAdapter2;
    BuyAdapter buyAdapter3;
    BuyAdapter buyAdapter4;

    QueueAdapter queueAdapter1;
    QueueAdapter queueAdapter2;
    QueueAdapter queueAdapter3;
    QueueAdapter queueAdapter4;

    TextView automatName1;
    TextView customerName1;
    RecyclerView shoppingList1;
    RecyclerView queueList1;
    TextView totalCost1;

    TextView automatName2;
    TextView customerName2;
    RecyclerView shoppingList2;
    RecyclerView queueList2;
    TextView totalCost2;

    TextView automatName3;
    TextView customerName3;
    RecyclerView shoppingList3;
    RecyclerView queueList3;
    TextView totalCost3;

    TextView automatName4;
    TextView customerName4;
    RecyclerView shoppingList4;
    RecyclerView queueList4;
    TextView totalCost4;
    TextView snackBarStatus1;
    TextView snackBarStatus2;
    TextView snackBarStatus3;
    TextView snackBarStatus4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        automatName1 = findViewById(R.id.automatName1);
        customerName1 = findViewById(R.id.customerName1);
        shoppingList1 = findViewById(R.id.shoppingList1);
        queueList1 = findViewById(R.id.queueList1);
        totalCost1 = findViewById(R.id.totalCost1);

        automatName2 = findViewById(R.id.automatName2);
        customerName2 = findViewById(R.id.customerName2);
        shoppingList2 = findViewById(R.id.shoppingList2);
        queueList2 = findViewById(R.id.queueList2);
        totalCost2 = findViewById(R.id.totalCost2);

        automatName3 = findViewById(R.id.automatName3);
        customerName3 = findViewById(R.id.customerName3);
        shoppingList3 = findViewById(R.id.shoppingList3);
        queueList3 = findViewById(R.id.queueList3);
        totalCost3 = findViewById(R.id.totalCost3);

        automatName4 = findViewById(R.id.automatName4);
        customerName4 = findViewById(R.id.customerName4);
        shoppingList4 = findViewById(R.id.shoppingList4);
        queueList4 = findViewById(R.id.queueList4);
        totalCost4 = findViewById(R.id.totalCost4);

        snackBarStatus1 = findViewById(R.id.snackBarStatus1);
        snackBarStatus2 = findViewById(R.id.snackBarStatus2);
        snackBarStatus3 = findViewById(R.id.snackBarStatus3);
        snackBarStatus4 = findViewById(R.id.snackBarStatus4);
        buyAdapter1 = new BuyAdapter();
        buyAdapter2 = new BuyAdapter();
        buyAdapter3 = new BuyAdapter();
        buyAdapter4 = new BuyAdapter();
        queueAdapter1 = new QueueAdapter();
        queueAdapter2 = new QueueAdapter();
        queueAdapter3 = new QueueAdapter();
        queueAdapter4 = new QueueAdapter();

        shoppingList1.setLayoutManager(new LinearLayoutManager(this));
        shoppingList2.setLayoutManager(new LinearLayoutManager(this));
        shoppingList3.setLayoutManager(new LinearLayoutManager(this));
        shoppingList4.setLayoutManager(new LinearLayoutManager(this));
        shoppingList1.setAdapter(buyAdapter1);
        shoppingList2.setAdapter(buyAdapter2);
        shoppingList3.setAdapter(buyAdapter3);
        shoppingList4.setAdapter(buyAdapter4);
        queueList1.setLayoutManager(new LinearLayoutManager(this));
        queueList2.setLayoutManager(new LinearLayoutManager(this));
        queueList3.setLayoutManager(new LinearLayoutManager(this));
        queueList4.setLayoutManager(new LinearLayoutManager(this));
        queueList1.setAdapter(queueAdapter1);
        queueList2.setAdapter(queueAdapter2);
        queueList3.setAdapter(queueAdapter3);
        queueList4.setAdapter(queueAdapter4);
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("Румянцева Мария"));
        students1.add(new Student("Быков Даниил"));
        students1.add(new Student("Зуева Мария"));
        students1.add(new Student("Скворцова Полина"));
        students1.add(new Student("Михеева Сафия"));
        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("Жуков Григорий"));
        students2.add(new Student("Зотова Анна"));
        students2.add(new Student("Гущина Таисия"));
        students2.add(new Student("Артемова Александра"));
        students2.add(new Student("Макаров Александр"));
        List<Student> students3 = new ArrayList<>();
        students3.add(new Student("Ершов Игорь"));
        students3.add(new Student("Петухов Иван"));
        students3.add(new Student("Иванова Ева"));
        students3.add(new Student("Зыков Богдан"));
        students3.add(new Student("Агеева Амалия"));
        List<Student> students4 = new ArrayList<>();
        students4.add(new Student("Волков Дмитрий"));
        students4.add(new Student("Фадеева Диана"));
        students4.add(new Student("Ефимова София"));
        students4.add(new Student("Егоров Семён"));
        students4.add(new Student("Сергеев Никита"));
        snackBar1 = new SnackBar(1, 100);
        snackBar2 = new SnackBar(2, 100);
        snackBar3 = new SnackBar(3,  100);
        snackBar4 = new SnackBar(4, 100);
        snackBar1.setQueue(students1);
        snackBar2.setQueue(students2);
        snackBar3.setQueue(students3);
        snackBar4.setQueue(students4);
        updateUI(1);
        updateUI(2);
        updateUI(3);
        updateUI(4);
        snackBar1.start(this);
        snackBar2.start(this);
        snackBar3.start(this);
        snackBar4.start(this);

    }
    @SuppressLint("SetTextI18n")
    public void updateUI(int snackBarNum) {
        switch(snackBarNum){
            case 1:
                if(snackBar1.getSnackBarStatus() == SnackBar.Status.INACTION){
                    automatName1.setText(AUTOMAT_NAME + 1);
                    customerName1.setText("");
                    buyAdapter1.setProducts(new ArrayList<>());
                    totalCost1.setText("");
                    snackBarStatus1.setText(INACTIVE_STATUS);
                }else{
                    if(snackBar1.getQueue().size() != 0) {
                        customerName1.setText(snackBar1.getQueue().get(0).getName());
                    }
                    buyAdapter1.setProducts(snackBar1.getCurrentProducts());
                    totalCost1.setText(getCost(snackBar1.getCurrentProducts()) + " ");
                    snackBarStatus1.setText(chooseState(snackBar1.getSnackBarStatus()));
                    queueAdapter1.setPersons(snackBar1.getStudentsNameList());
                }
                break;
            case 2 :
                if(snackBar2.getSnackBarStatus() == SnackBar.Status.INACTION){
                    automatName2.setText(AUTOMAT_NAME + 2);
                    customerName2.setText("");
                    buyAdapter2.setProducts(new ArrayList<>());
                    totalCost2.setText("");
                    snackBarStatus2.setText(INACTIVE_STATUS);
                }else{
                    if(snackBar2.getQueue().size() != 0) {
                        customerName2.setText(snackBar2.getQueue().get(0).getName());
                    }
                    buyAdapter2.setProducts(snackBar2.getCurrentProducts());
                    totalCost2.setText(getCost(snackBar2.getCurrentProducts()) + " ");
                    snackBarStatus2.setText(chooseState(snackBar2.getSnackBarStatus()));
                    queueAdapter2.setPersons(snackBar2.getStudentsNameList());
                }
                break;
            case 3:
                if(snackBar3.getSnackBarStatus() == SnackBar.Status.INACTION){
                    automatName3.setText(AUTOMAT_NAME + 3);
                    customerName3.setText("");
                    buyAdapter3.setProducts(new ArrayList<>());
                    totalCost3.setText("");
                    snackBarStatus3.setText(INACTIVE_STATUS);
                }else{
                    if(snackBar3.getQueue().size() != 0) {
                        customerName3.setText(snackBar3.getQueue().get(0).getName());
                    }
                    buyAdapter3.setProducts(snackBar3.getCurrentProducts());
                    totalCost3.setText(getCost(snackBar3.getCurrentProducts()) + " ");
                    snackBarStatus3.setText(chooseState(snackBar3.getSnackBarStatus()));
                    queueAdapter3.setPersons(snackBar3.getStudentsNameList());
                }
                break;
            case 4:
                if(snackBar4.getSnackBarStatus() == SnackBar.Status.INACTION){
                    automatName4.setText(AUTOMAT_NAME + 4);
                    customerName4.setText("");
                    buyAdapter4.setProducts(new ArrayList<>());
                    totalCost4.setText("");
                    snackBarStatus4.setText(INACTIVE_STATUS);
                }else{
                    if(snackBar4.getQueue().size() != 0) {
                        customerName4.setText(snackBar4.getQueue().get(0).getName());
                    }
                    buyAdapter4.setProducts(snackBar4.getCurrentProducts());
                    totalCost4.setText(getCost(snackBar4.getCurrentProducts()) + " ");
                    snackBarStatus4.setText(chooseState(snackBar4.getSnackBarStatus()));
                    queueAdapter4.setPersons(snackBar4.getStudentsNameList());
                }
        }
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