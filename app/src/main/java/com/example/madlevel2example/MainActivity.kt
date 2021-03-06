package com.example.madlevel2example

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2example.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_reminder.view.*

class MainActivity : AppCompatActivity() {

    private  val reminders = arrayListOf<Reminder>()
    private val reminderAdapter = ReminderAdapter(reminders)
    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    private fun initViews(){
        binding.btnAddReminder.setOnClickListener{
            val reminder = binding.etReminder.text.toString()
            addReminder(reminder)
        }
        binding.rvReminders.layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
        binding.rvReminders.adapter = reminderAdapter
        binding.rvReminders.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
    }
    private fun addReminder(reminder:String){
        if(reminder.isNotBlank()){
            Log.d(reminders.toString(),"test")
            reminders.add(Reminder(reminder))
            reminderAdapter.notifyDataSetChanged()
            binding.etReminder.text?.clear()
        }else{
            Snackbar.make(etReminder,"You must fill in the inputfield!",Snackbar.LENGTH_SHORT).show()
        }
    }
}
