package np.com.satishray.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import net.objecthunter.exp4j.ExpressionBuilder

//import com.faendir.rhino_android.RhinoAndroidHelper
//import org.mozilla.javascript.Context
//import org.mozilla.javascript.Scriptable





class MainActivity : ComponentActivity() {

    private lateinit var tvInput: TextView
    private lateinit var tvOutput: TextView
    private lateinit var process: String
    private var checkBracket: Boolean = false

//    private val rhino: RhinoAndroidHelper? = null
//    private var context: Context? = null
//    private val scope: Scriptable? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvInput = findViewById(R.id.tvInput)
        tvOutput = findViewById(R.id.tvOutput)


        val btnClear = findViewById<Button>(R.id.btnClear)
        // set on-click listener
        btnClear.setOnClickListener {
            tvInput.text = ""
            tvOutput.text = ""
        }

        val btn0 = findViewById<Button>(R.id.btn0)
        btn0.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "0"
        }
        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = (process + "1")
        }
        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "2"
        }
        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "3"
        }
        val btn4 = findViewById<Button>(R.id.btn4)
        btn4.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "4"
        }
        val btn5 = findViewById<Button>(R.id.btn5)
        btn5.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "5"
        }
        val btn6 = findViewById<Button>(R.id.btn6)
        btn6.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "6"
        }
        val btn7 = findViewById<Button>(R.id.btn7)
        btn7.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "7"
        }
        val btn8 = findViewById<Button>(R.id.btn8)
        btn8.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "8"
        }
        val btnNine = findViewById<Button>(R.id.btn9)
        btnNine.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = process + "9"
        }


        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = "$process+"
        }
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMinus.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = "$process-"
        }
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        btnDivide.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = "$process/"
        }
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnMultiply.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = "$process*"
        }
        val btnPoint = findViewById<Button>(R.id.btnPoint)
        btnPoint.setOnClickListener {
            process = tvInput.text.toString()
            tvInput.text = "$process."
        }

        val btnBracket = findViewById<Button>(R.id.btnBracket)
        btnBracket.setOnClickListener {
            if (checkBracket) {
                process = tvInput.text.toString()
                tvInput.text = "$process)"
                checkBracket = false
            } else {
                process = tvInput.text.toString()
                tvInput.text = "$process("
                checkBracket = true
            }
        }
        val btnEqual = findViewById<Button>(R.id.btnEqual)
        btnEqual.setOnClickListener {

            process = process.replace("%", "/100")
         try {
             val input = ExpressionBuilder(tvInput.text.toString()).build()
             val output = input.evaluate()
             val longOutput = output.toLong()

             if (output == longOutput.toDouble()){
                 tvOutput.text = longOutput.toString()
             }
             else {
                 tvOutput.text = output.toString()
             }
         }
         catch (e:Exception) {
             Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
         }




//
//            process = tvInput.text.toString()
//
//            process = process.replace("%", "/100")
//
//////            Context rhino = Context.enter()
////            context = rhino?.enterContext();
////
////            context?.optimizationLevel = -1;
////            var finalResult:String = " "
//
//            tvOutput.text = context.evaluateString()
        }
    }
}

