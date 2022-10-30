package com.example.hw1anzornaghawi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.view.View
import android.widget.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answer1 : Button = findViewById(R.id.ans1)
        val answer2 : Button = findViewById(R.id.ans2)
        val answer3 : Button = findViewById(R.id.ans3)
        val questionfield : TextView = findViewById(R.id.questionfield)
        val subjectoptions = resources.getStringArray(R.array.subjectoptions)
        val mathanswers1 = resources.getStringArray(R.array.mathanswer1_1)
        val mathanswers2 = resources.getStringArray(R.array.mathanswer1_2)
        val mathanswers3 = resources.getStringArray(R.array.mathanswer1_3)
        val physicsanswer1 = resources.getStringArray(R.array.physicsanswer1_1)
        val physicsanswer2 = resources.getStringArray(R.array.physicsanswer1_2)
        val physicsanswer3 = resources.getStringArray(R.array.physicsanswer1_3)
        val geoanswers1 = resources.getStringArray(R.array.geoanswers1_1)
        val geoanswers2 = resources.getStringArray(R.array.geoanswers1_2)
        val geoanswers3 = resources.getStringArray(R.array.geoanswers1_3)
        val subjectspinner : Spinner = findViewById(R.id.subject_select)
        var selectedsubject = ""
        var selectedquestion = 0
        subjectspinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectoptions)
        subjectspinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                selectedsubject = subjectoptions[position]
                questionfield.text = ""
                answer1.text = ""
                answer2.text = ""
                answer3.text = ""
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val questionoptions = resources.getStringArray(R.array.questionoptions)
        val questionspinner : Spinner = findViewById(R.id.question_select)
        questionspinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, questionoptions)
        questionspinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                questionfield.text = ""
                selectedquestion = position
                if (selectedsubject == "Math") {
                    questionfield.text = resources.getStringArray(R.array.mathquestions)[position]

                    if (position == 0) {
                        answer1.text = mathanswers1[0]
                        answer2.text = mathanswers1[1]
                        answer3.text = mathanswers1[2]
                    }
                    if (position == 1) {
                        answer1.text = mathanswers2[0]
                        answer2.text = mathanswers2[1]
                        answer3.text = mathanswers2[2]
                    }
                    if (position == 2) {
                        answer1.text = mathanswers3[0]
                        answer2.text = mathanswers3[1]
                        answer3.text = mathanswers3[2]
                    }
                }
                if (selectedsubject == "Geo") {
                    questionfield.text = resources.getStringArray(R.array.geoquestions)[position]
                    if (position == 0) {
                        answer1.text = geoanswers1[0]
                        answer2.text = geoanswers1[1]
                        answer3.text = geoanswers1[2]
                    }
                    if (position == 1) {
                        answer1.text = geoanswers2[0]
                        answer2.text = geoanswers2[1]
                        answer3.text = geoanswers2[2]
                    }
                    if (position == 2) {
                        answer1.text = geoanswers3[0]
                        answer2.text = geoanswers3[1]
                        answer3.text = geoanswers3[2]
                    }
                }
                if (selectedsubject == "Physics") {
                    questionfield.text =
                        resources.getStringArray(R.array.physicsquestions)[position]
                    if (position == 0) {
                        answer1.text = physicsanswer1[0]
                        answer2.text = physicsanswer1[1]
                        answer3.text = physicsanswer1[2]
                    }
                    if (position == 1) {
                        answer1.text = physicsanswer2[0]
                        answer2.text = physicsanswer2[1]
                        answer3.text = physicsanswer2[2]
                    }
                    if (position == 2) {
                        answer1.text = physicsanswer3[0]
                        answer2.text = physicsanswer3[1]
                        answer3.text = physicsanswer3[2]
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        answer1.setOnClickListener{
            if((selectedquestion == 0 && selectedsubject == "Math") || (selectedquestion == 1 && selectedsubject == "Geo") || (selectedquestion == 1 && selectedsubject == "Physics"))
            {
                Toast.makeText(this@MainActivity, "Correct!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this@MainActivity, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
        answer2.setOnClickListener{
            if((selectedquestion ==1 && selectedsubject == "Math") || (selectedquestion == 0 && selectedsubject == "Geo") || (selectedquestion == 0 && selectedsubject == "Physics") || (selectedquestion == 2 && selectedsubject == "Physics"))

            {
                Toast.makeText(this@MainActivity, "Correct!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this@MainActivity, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
        answer3.setOnClickListener{
            if((selectedquestion == 2 && selectedsubject == "Geo") || selectedquestion == 2 && selectedsubject == "Math")
            {
                Toast.makeText(this@MainActivity, "Correct!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this@MainActivity, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }


            }
    }
