package com.fileadndroid

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       //Another Way Read Data

       
        val file=File(Environment.getExternalStorageDirectory().absolutePath,"fluper/Imagey.txt")
        val reader:BufferedReader= file.bufferedReader()
        val data=reader.use { it.readText() }
        Log.d("TAGS","DATA:"+data)

        

//-----------------


         val data=this.assets.open("data.json").bufferedReader().use { it.readText() }

         Log.d("TAGS",data)

        val folderName="fluper"
        val sdcard=Environment.getExternalStorageDirectory()
        val dir=File(sdcard.absoluteFile,folderName)
        val file=File(dir,"Imagey.txt")
        val out:FileOutputStream
        if(dir.exists()){
            out=FileOutputStream(file)
            out.write(data.toByteArray())
            out.flush()
            out.close()
        }else{
            dir.mkdir()
            out=FileOutputStream(file)
            out.write(data.toByteArray())
            out.flush()
            out.close()
        }




        btn.setOnClickListener {

            if(file.exists()) {
                val datax = StringBuffer("")
                val reader=BufferedReader(FileReader(file))
               var dat= reader.readLine()
               while (dat !=null){
                   datax.append(dat)
                   dat=reader.readLine()
               }
                reader.close()

                Log.d("TAGS","GET:"+datax)

            }
        }
    }
}
