package com.example.clase14_5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.content.ContentValues
import android.view.View
import android.widget.EditText
import android.widget.Toast


//import android.database.sqlite.SQLiteOpenHelper


class MainActivity : AppCompatActivity() {
    var txtCi: EditText? = null
    var txtNombre: EditText? = null
    var txtNota: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtCi = findViewById(R.id.txtCi)
        txtNombre = findViewById(R.id.txtNombre)
        txtNota = findViewById(R.id.txtNota)

    }

    fun adicion(view: View) {
        var conexion = Bdsqlite(this, "congreso", null, 1)
        //se realiza la conexion a bd
        var baseDato = conexion.writableDatabase
        var ci = txtCi?.text.toString()
        var nombre = txtNombre?.text.toString()
        var nota = txtNota?.text.toString()
        //baseDato.execSQL("insert into alumno values (54123,juan,66)")
        if (ci.isEmpty() == false && nombre.isEmpty() == false && nota.isEmpty() == false)
        //if( nombre.isEmpty()==false  )
        {
            //se genera un array de contenido Contentvalues
            var registroDato = ContentValues()
            registroDato.put("ci", ci)
            registroDato.put("nombre", nombre)
            registroDato.put("observacion", nota)
            baseDato.insert("participante", null, registroDato)
            //baseDato.insert("alumno",null,registroDato)
            Toast.makeText(this, "!!!!!registro adicionado!!!! ", Toast.LENGTH_LONG).show()
            val cursor = baseDato.rawQuery("SELECT * FROM participante", null)
            if (cursor.count == 0) {
                val show = Toast.makeText(this, "No se insertaron datos", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_LONG).show()
            }
            cursor.close()
            //limpiamos los dialogos de texto
            txtCi?.setText("")
            txtNombre?.setText("")
            txtNota?.setText("")
        } else {
            Toast.makeText(this, "los campos deben tener Datos", Toast.LENGTH_LONG).show()
        }
        //   baseDato.close()
    }


    fun consulta(view: View) {
        var conexion = Bdsqlite(this, "congreso", null, 1)
        //se realiza la conexion a bd
        var baseDato = conexion.writableDatabase
        var ci = txtCi?.text.toString()
        if (ci.isEmpty() == false) {
            var reg = baseDato.rawQuery(
                "select nombre,observacion from participante where ci='$ci'",
                null
            )
            if (reg.moveToFirst() == true) {
                txtNombre?.setText(reg.getString(0))
                txtNota?.setText(reg.getString(1))
                baseDato.close()
            } else {
                txtNombre?.setText("")
                txtNota?.setText("")
                Toast.makeText(this, "no existe datos de ese carnet..!!!!!", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

    fun eliminar(view: View) {
        var conexion = Bdsqlite(this, "congreso", null, 1)
        //se realiza la conexion a bd
        var baseDato = conexion.writableDatabase
        var ci = txtCi?.text.toString()
        if (ci.isEmpty() == false) {
            val cantidad = baseDato.delete("participante", "ci= '$ci'", null)
            if (cantidad > 0) {
                Toast.makeText(this, "participante fue eliminado..!!!!!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "no existe el participante !!!!", Toast.LENGTH_LONG).show()
            }
            txtCi?.setText("")
            txtNombre?.setText("")
            txtNota?.setText("")

        }
    }




    fun modificar(view: View) {
        var conexion = Bdsqlite(this, "congreso", null, 1)
        //se realiza la conexion a bd
        var baseDato = conexion.writableDatabase
        var ci = txtCi?.text.toString()
        var nombre = txtNombre?.text.toString()
        var nota = txtNota?.text.toString()
        //baseDato.execSQL("insert into alumno values (54123,juan,66)")
        if (!ci.isEmpty() && !nombre.isEmpty() && !nota.isEmpty()) {
            var registroDato = ContentValues()
            registroDato.put("ci", ci)
            registroDato.put("nombre", nombre)
            registroDato.put("observacion", nota)
            val cantidad = baseDato.update("participante", registroDato, "ci='$ci'", null)
            if (cantidad > 0) {
                Toast.makeText(this, "participante fue modificado..!!!!!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "participante no modificado !!!!", Toast.LENGTH_LONG).show()
            }
        }
        else
        {
            Toast.makeText(this, "LOS CAMPOS NO DEBEN ESTAR VACIOS!!", Toast.LENGTH_LONG).show()
        }

    }


    fun salir(view: View)
    {
        var conexion = Bdsqlite(this, "congreso", null, 1)
        //se realiza la conexion a bd
        var baseDato = conexion.writableDatabase
        Toast.makeText(this, "se CERRARA LA BASE DE DATOS", Toast.LENGTH_LONG).show()
        baseDato.close()
        System.exit(0)
    }

}

