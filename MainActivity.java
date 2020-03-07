package ptnt.cusc.ctu.testpycharm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = findViewById(R.id.txt);
        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject pyf = py.getModule("myscript");

        PyObject obj = null;
        try {
            obj = pyf.callAttrThrows("cong",2,3);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        txt.setText(obj.toString());



    }

}
