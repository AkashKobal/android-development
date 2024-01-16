public class intent {
    
}
////////////////////////////// Intent

// FirstActivity

public void button(View view) {
    Intent intent;
    intent = new Intent(MainActivity.this, SecondActivity.class);
    intent.putExtra("Name", "Akash");
    intent.putExtra("RollNo:", 10);
    startActivity(intent);
}

// secondActivity

Intent fromMainActivity = getIntent();
String name = fromMainActivity.getStringExtra("Name");
int rollNo = fromMainActivity.getIntExtra("RollNo:",0);textView=

findViewById(R.id.textView);
 textView.setText("Name:"+name+"\n"+"Roll No:"+rollNo);
}}