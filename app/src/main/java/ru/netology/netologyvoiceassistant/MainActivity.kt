package ru.netology.netologyvoiceassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    lateinit var requestInput: TextInputEditText
    lateinit var podsAdapter: SimpleAdapter
    val pods = mutableListOf<HashMap<String, String>>(
        HashMap<String, String>().apply {
            put("Title", "Title 1")
            put("Content", "Content 1")
        },
        HashMap<String, String>().apply {
            put("Title", "Title 2")
            put("Content", "Content 2")
        },
        HashMap<String, String>().apply {
            put("Title", "Title 3")
            put("Content", "Content 3")
        }
    )
  lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "start of onCreate function")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* val name: String ="Yaroslav"
        *пробелы важны, не запускалось, пока были ошибки.

        val name: String ="Ivanov"
        val surname: String ="Ivan"
        var age: Int =37
        var heigth: Double =172.2
        var textSummary: String
        age = age+1 // or Age+=1 or   age++
        // age = age + heigth error
        // heigth = age + heigth // ok
        textSummary = "name: $name surname: $surname age: $age heigth: $heigth "
        val output: TextView = findViewById(R.id.output)
        output.text = textSummary
        Log.d(TAG, textSummary )
        Log.d(TAG, "end of onCreate function")
         */
        initViews()
    }

    fun initViews() {
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        requestInput=findViewById(R.id.text_input_edit)
        val podsList:ListView = findViewById( R.id.pods_list)
        podsAdapter= SimpleAdapter(
            applicationContext,
            pods,
            R.layout.item_pod,
            arrayOf("Title","Content"),
            intArrayOf(R.id.title,R.id.content)
        )
        podsList.adapter=podsAdapter
        val voiceInputButton: FloatingActionButton=findViewById(R.id.voice_input_button)
        voiceInputButton.setOnClickListener{Log.d(TAG, "FAB")}
        progressBar= findViewById(R.id.progress_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_stop -> {
                Log.d(TAG, "action_stop")
                return true
            }
            R.id.action_clear -> {
                Log.d(TAG, "action_clear")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

/*
        * вкладка терминала logcat,
        * ru.netology.netologyvoiceassintant, Verbose, MainActivity
        * restart Shift+F10
        *
        * Log.e(TAG, textSummary ) log error
        *
        * фильтр вывода вместо Verbose Debag, Error
        * */

/* add icon
* вкладка Project, <Android>/res<RM> New/Image Asset
* вкладка Project, <Project>/app/src/main/res/mipmap-ххх/наша иконка
* <Project>/app/src/main/AndroidManifest.xml - прописать
* <application
* android:allowBackup="true"
* android:icon="@mipmap/ic_launcher_logo"
* android:roundIcon="@mipmap/ic_launcher_logo_round"
* ....
* */

/*
*https://material.io
* ../main/res/values/color.xml
*../main/res/values/themes.xml
* FAB - плавающая кнопка
* список
* */