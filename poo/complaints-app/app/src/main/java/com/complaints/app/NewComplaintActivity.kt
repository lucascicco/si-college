  package com.complaints.app

  import android.app.DatePickerDialog
  import android.app.Dialog
  import android.os.Bundle
  import android.support.v4.app.DialogFragment
  import android.support.v7.app.AppCompatActivity
  import android.widget.DatePicker
  import kotlinx.android.synthetic.main.activity_new_complaint.*
  import org.jetbrains.anko.doAsync
  import org.jetbrains.anko.uiThread
  import java.util.*

  class NewComplaintActivity : AppCompatActivity() {

      lateinit var database : ComplaintsDatabase
      lateinit var currentComplaint : ComplaintsEntity


      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_new_complaint)
          setupDatabase()

          val c = Calendar.getInstance()
          var year = c.get(Calendar.YEAR)
          var month = c.get(Calendar.MONTH)
          var day = c.get(Calendar.DAY_OF_MONTH)

          var fullDate = day.toString() + "/" + (month + 1) + "/" + year

          btn_date.setOnClickListener {
              class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
                  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
                      return DatePickerDialog(activity, this, year, month, day)
                  }
                  override fun onDateSet(view: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int) {
                      day = selectedDay;
                      month = selectedMonth;
                      year = selectedYear;
                      val result = selectedDay.toString() + "/" + (selectedMonth + 1) + "/" + selectedYear
                      fullDate = result
                  }
              }

              val newFragment = DatePickerFragment()
              newFragment.show(supportFragmentManager, "datePicker")
          }

          btn_add.setOnClickListener {
              val description = "Descrição: " + el_description.text.toString()
              val code =  "Código: " + el_code.text.toString()
              val date = "Data:  $fullDate"
              currentComplaint = ComplaintsEntity(code, description, date)
              doAsync {
                  database.DAO().insertComplaint(currentComplaint)
                  uiThread {
                      finish()
                  }
              }
          }
      }

      private fun setupDatabase() {
          database = ComplaintsDatabase.getInstance(this)
      }


  }
