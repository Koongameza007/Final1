package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            calculate.setOnClickListener {


                if (rd1.isChecked == false && rd2.isChecked == false && rd3.isChecked == false && rd4.isChecked == false && rd5.isChecked == false) {
                    Toast.makeText(this, "กรุณาเลือกกิจกรรม", Toast.LENGTH_SHORT).show()
                } else if (women.isChecked == false && men.isChecked == false) {
                    Toast.makeText(this, "กรุณาเลือกเพศ", Toast.LENGTH_SHORT).show()
                } else if (height.text.toString() == "" || age.text.toString() == "" || weight.text.toString() == "") {
                    Toast.makeText(this, "กรุณาใส่ข้อมูลให้ถูกต้อง", Toast.LENGTH_SHORT).show()
                } else {
                    var txt1 = weight.text.toString().toDouble()
                    var txt2 = (height.text.toString().toDouble() * 0.01)
                    var txt3 = (txt1.toDouble() / Math.pow(txt2.toDouble(), 2.0))
                    var txt4 = age.text.toString().toDouble()

                    var m: Double = 0.0
                    var n = 0.0
                    if (men.isChecked) {
                        m = (66 + (13.7 * weight.text.toString()
                            .toDouble()) + (5 * height.text.toString().toDouble()) - (6.8 * txt4))
                    } else if (women.isChecked) {
                        m = (665 + (9.6 * weight.text.toString()
                            .toDouble()) + (1.8 * height.text.toString().toDouble()) - (4.7 * txt4))
                    }

                    if (rd1.isChecked) {
                        n = (m.toDouble() * 1.2)
                    } else if (rd2.isChecked) {
                        n = (m.toDouble() * 1.375)
                    } else if (rd3.isChecked) {
                        n = (m.toDouble() * 1.55)
                    } else if (rd4.isChecked) {
                        n = (m.toDouble() * 1.725)
                    } else if (rd5.isChecked) {
                        n = (m.toDouble() * 1.9)
                    }

                    val i = Intent(this, MainActivity2::class.java)
                    i.putExtra("txt1", txt3.toString())
                    i.putExtra("txt2", m.toInt().toString())
                    i.putExtra("txt3", n.toInt().toString())
                    startActivity(i)


                }

            }


            clear.setOnClickListener {
                RDG.clearCheck()
                radioGroup.clearCheck()
                weight.text.clear()
                height.text.clear()
                age.text.clear()
            }


        }
    }
