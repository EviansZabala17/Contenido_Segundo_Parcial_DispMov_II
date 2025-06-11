

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- Campo para CI -->
    <EditText
        android:id="@+id/txtCi"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="CI"
        android:inputType="number" />

    <!-- Campo para Nombre -->
    <EditText
        android:id="@+id/txtNombre"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nombre"
        android:inputType="textPersonName" />

    <!-- Campo para Nota / Observación -->
    <EditText
        android:id="@+id/txtNota"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nota"
        android:inputType="numberDecimal" />

    <!-- Fila con todos los botones -->
    <HorizontalScrollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:fillViewport="true">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:weightSum="5">

            <Button
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:onClick="adicion"
                android:text="Adicionar" />

            <Button
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:onClick="consulta"
                android:text="Consultar" />

            <Button
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:onClick="modificar"
                android:text="Modificar" />

            <Button
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:onClick="eliminar"
                android:text="Eliminar" />

            <Button
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:onClick="salir"
                android:text="Salir" />
        </LinearLayout>
    </HorizontalScrollView>

</LinearLayout>
