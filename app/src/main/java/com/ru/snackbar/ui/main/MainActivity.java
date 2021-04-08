package com.ru.snackbar.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.ru.snackbar.R;
import com.ru.snackbar.models.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, new SnackBarFragment(students1)).commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment2, new SnackBarFragment(students2)).commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment3, new SnackBarFragment(students3)).commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment4, new SnackBarFragment(students4)).commit();
    }
    public void makeContainersInvisible() {
        ((FrameLayout)findViewById(R.id.fragment1)).setVisibility(View.INVISIBLE);
        ((FrameLayout)findViewById(R.id.fragment2)).setVisibility(View.INVISIBLE);
        ((FrameLayout)findViewById(R.id.fragment3)).setVisibility(View.INVISIBLE);
        ((FrameLayout)findViewById(R.id.fragment4)).setVisibility(View.INVISIBLE);
    }


}