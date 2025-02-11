import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.widget.Toast
import android.media.MediaPlayer
import android.media.AudioManager
import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log
import android.view.View
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.opengl.GLSurfaceView
import android.opengl.GLU
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer

// Klasa pomocnicza SQLiteOpenHelper do zarządzania bazą danych
class DBHelper(context: Context) : SQLiteOpenHelper(context, "bazaDanych.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        // Tworzenie tabeli
        db.execSQL("CREATE TABLE tabela (id INTEGER PRIMARY KEY, tekst TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS tabela;")
        onCreate(db)
    }
}

// Przykład użycia SQLiteDatabase
fun exampleDatabaseUsage(context: Context) {
    val dbHelper = DBHelper(context)
    val db = dbHelper.writableDatabase
    
    val conVal = ContentValues().apply {
        put("tekst", "Przykladowa wartosc")
    }
    
    db.insert("tabela", null, conVal)
    
    val kolumny = arrayOf("tekst")
    val cursor: Cursor = db.query("tabela", kolumny, null, null, null, null, null)
    
    if (cursor.moveToFirst()) {
        Toast.makeText(context, cursor.getString(0), Toast.LENGTH_SHORT).show()
    }
    
    cursor.close()
}

// Przykład rozpoznawania mowy
fun recognizeSpeech(context: Context) {
    val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_PROMPT, "Powiedz cos do mnie...")
    }
    
    try {
        (context as Activity).startActivityForResult(intent, 0)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "Nie slucham Ciebie!", Toast.LENGTH_SHORT).show()
    }
}

// Przykład obsługi wyniku rozpoznawania mowy
override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    
    if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
        val lista = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
        val dopasowanie = data?.getFloatArrayExtra(RecognizerIntent.EXTRA_CONFIDENCE_SCORES)
        
        if (!lista.isNullOrEmpty() && !dopasowanie.isNullOrEmpty()) {
            Toast.makeText(this, "Rozpoznalem \"${lista[0]}\" z prawd. ${dopasowanie[0]}", Toast.LENGTH_SHORT).show()
        }
    }
}

// Przykład przechwytywania zdjęcia
fun captureImage(context: Context, fileUri: Uri) {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
        putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
    }
    (context as Activity).startActivityForResult(intent, 1)
}

// Przykład przechwytywania wideo
fun captureVideo(context: Context, fileUri: Uri) {
    val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE).apply {
        putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1)
        putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10)
        putExtra(MediaStore.EXTRA_SIZE_LIMIT, 1000000)
    }
    (context as Activity).startActivityForResult(intent, 1)
}

// Pobieranie współrzędnych geograficznych
fun aktualizuj(pomiar: Location, szerokoscTextView: TextView, dlugoscTextView: TextView) {
    val lambda = wspolrzedna(pomiar.longitude)
    val fi = wspolrzedna(pomiar.latitude)
    
    dlugoscTextView.text = "Dlugosc: ${lambda[0]}° ${lambda[1]}' ${lambda[2]}\""
    szerokoscTextView.text = "Szerokosc: ${fi[0]}° ${fi[1]}' ${fi[2]}\""
}

fun wspolrzedna(pomiar: Double): IntArray {
    val w = IntArray(3)
    w[0] = pomiar.toInt()
    w[1] = ((pomiar - w[0]) * 100).toInt()
    w[2] = ((pomiar - w[0] - w[1] * 0.01) * 10000).toInt()
    w[1] = (w[1] * 0.6).toInt()
    w[2] = (w[2] * 0.6).toInt()
    return w
}

// Pobieranie ostatniej znanej lokalizacji
fun getLastKnownLocation(client: FusedLocationProviderClient, context: Context) {
    client.lastLocation.addOnSuccessListener { location: Location? ->
        location?.let {
            // obsługa lokalizacji
            Toast.makeText(context, "Lokalizacja: ${it.latitude}, ${it.longitude}", Toast.LENGTH_SHORT).show()
        }
    }
}

// Interfejs do komunikacji JavaScript z aplikacją
class WebAppInterface(private val context: Context) {
    @JavascriptInterface
    fun funkcja() {
        // ciało funkcji
    }
}

// Dodanie interfejsu do WebView
fun addJavaScriptInterface(webView: WebView, context: Context) {
    webView.addJavascriptInterface(WebAppInterface(context), "nazwa")
}

// Odtwarzanie dźwięku z zasobów aplikacji
fun playAudio(context: Context) {
    val player = MediaPlayer.create(context, R.raw.av)
    player.start()
}

// Odtwarzanie internetowego strumienia audio
fun playAudioStream(url: String) {
    val mediaPlayer = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(url)
        prepare()
        start()
    }
}

// Lista dostępnych sensorów
fun listAvailableSensors(context: Context) {
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val sensorList: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
    
    for (sensor in sensorList) {
        Log.v("sensor", "Znalazłem sensor ${sensor.name}")
    }
}

// Pomiar temperatury z czujnika
class TemperatureSensor(context: Context) : SensorEventListener {
    private val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private var temperatureSensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)

    fun registerListener() {
        temperatureSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        val temperature = event.values[0]
        Log.v("sensor", "Temperatura: $temperature")
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}

// Dodawanie zasobów do projektu
fun addImageView(context: Context) {
    val imgView = ImageView(context).apply {
        setImageResource(R.drawable.my_img)
        contentDescription = context.getString(R.string.my_image_desc)
    }
}

// Tworzenie niestandardowego kształtu
class MyShape(context: Context) : View(context) {
    private val drawable: ShapeDrawable = ShapeDrawable(OvalShape()).apply {
        paint.color = 0xff74AC23.toInt()
        setBounds(10, 10, 310, 60)
    }

    override fun onDraw(canvas: Canvas) {
        drawable.draw(canvas)
    }
}

// OpenGL Surface View
class MyGLSurfaceView(context: Context) : GLSurfaceView(context) {
    init {
        setRenderer(MyRenderer())
    }
}

class MyRenderer : GLSurfaceView.Renderer {
    override fun onDrawFrame(gl: GL10) {
        // Generacja grafiki
    }

    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        gl.glViewport(0, 0, width, height)
        gl.glMatrixMode(GL10.GL_PROJECTION)
        gl.glLoadIdentity()
        GLU.gluPerspective(gl, 45.0f, width.toFloat() / height.toFloat(), 1.0f, 10.0f)
    }

    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {}
}
