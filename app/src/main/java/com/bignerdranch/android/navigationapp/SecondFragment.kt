package com.bignerdranch.android.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.navigationapp.databinding.FragmentFisrtBinding
import com.bignerdranch.android.navigationapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding//для доступа к польз.интерефейсу.
    val args: SecondFragmentArgs by navArgs()//доступ арументов при переходе к фрагменту.
        //navA - автоматическа генерация Navigation Components.

    override fun onCreateView(//создание пользовательского интерфейса.
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)//связывени тнрейефа со 2.

       val numberSecond = args.number// получение аргумента number, Значение аргумента сохраняется в переменной numberSecond.
        binding.textView2.setText(numberSecond.toString())// переменная которая нам показывается при переходе от 1 фрагмента.

        binding.textView2.setOnClickListener() {//. Когда пользователь нажимает на этот элемент, выполняется код внутри лямбда-выражения.
            it.findNavController().navigate(R.id.fisrtFragment)//получение контроллера навигации
        // для текущего фрагмента и вызов метода navigate с идентификатором перехода fisrtFragment.
            // переход от 2 к 1.
        }

        return binding.root
    }
}
// Когда пользователь нажимает на элемент textView2, происходит переход обратно к FirstFragment. Этот переход управляется Navigation Component.


