package com.example.academy_notebook

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.loginframe_button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_regFragment_to_logFragment)
        }

        view.findViewById<Button>(R.id.register_button).setOnClickListener{
            addUser(view)
        }

    }

    private fun addUser(view: View) {
        // Инициализация полей
        val loginInput : TextView = view.findViewById(R.id.login)
        val emailInput : TextView = view.findViewById(R.id.email)
        val passwordInput : TextView = view.findViewById(R.id.password)
        val passwordInput2 : TextView = view.findViewById(R.id.checkpassword)
        val rulesSwitch : Switch = view.findViewById(R.id.rules)

        val sharedPreferences : SharedPreferences = requireActivity().getSharedPreferences("userPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.apply {
                putString("login", loginInput.text.toString())
                putString("email", emailInput.text.toString())
                putString("password", passwordInput.text.toString())
                putBoolean("session", false)
            }.apply()
            Navigation.findNavController(view).navigate(R.id.action_regFragment_to_logFragment)
            Toast.makeText(context, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show()

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}