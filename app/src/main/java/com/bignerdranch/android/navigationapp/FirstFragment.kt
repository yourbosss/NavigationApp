package com.bignerdranch.android.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bignerdranch.android.navigationapp.databinding.FragmentFisrtBinding

class FirstFragment : Fragment() { //описываем поведение первого фрагмента.
    private lateinit var binding: FragmentFisrtBinding //переменная для доступа к интерфейсу.

    override fun onCreateView(//ссоздается пользовательских интерфейс.
        inflater: LayoutInflater, container: ViewGroup?,//создание xml разметки.
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFisrtBinding.inflate(inflater, container, false)//cвязывает пользовательских интерфейс с с FF/
        binding.textView.setOnClickListener() {
            val action = FirstFragmentDirections.actionFisrtFragmentToSecondFragment(52)// создается объект передачи генерированное значение от 1 ко 2.
            it.findNavController().navigate(action)//происходит переход.
        }

        return binding.root// возращение корневого фрагмента.
    }
}
// поведение фрагмента FirstFragment. Когда пользователь нажимает на элемент textView в пользовательском интерфейсе фрагмента,
// происходит переход к SecondFragment с передачей аргумента 133. Этот переход управляется Navigation Component.


