public class Viva {

    }

   



    ////////////////////////////// Registration form

    name=findViewById(R.id.NameBox);fname=findViewById(R.id.FNameBox);
    places=findViewById(R.id.PlaceBox);btn=findViewById(R.id.SubmitBtn);

    // AutoCompleteTextView
    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item,
            Locations);places.setThreshold(1);places.setAdapter(adapter);

    // RadioButton
    rg=

    findViewById(R.id.GenderGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = findViewById(checkedId);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res1 = "Name: " + name.getText().toString() + "\n" + "Father Name: " +
                        fname.getText().toString() + "\n" + "Gender: " + rb.getText() + "\n" + "Place of Birth: "
                        + places.getText().toString();
                Toast.makeText(MainActivity.this, res1, Toast.LENGTH_SHORT).show();
            }
        });
    }}

    Calendar calendar = Calendar.getInstance();
    int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int minute = Calendar.getInstance().get(Calendar.MINUTE);
    int hour = Calendar.getInstance().get(Calendar.HOUR);

    // datePicker
    public void date(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dates = dayOfMonth + "/" + year + "/" + (month+1) ;
                date.setText(dates);
            }
        },10,07,2023);datePickerDialog.show();
    }

    // timePicker
    public void time(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String times = hourOfDay+":"+minute;
                time.setText(times);
            }
        },00,00,false);timePickerDialog.show();
    }}

    // checkBox
    CheckBox checkBox1, checkBox2, checkBox3;checkBox1=

    findViewById(R.id.checkBox1);
    checkBox2 = findViewById(R.id.checkBox2);
    checkBox3 = findViewById(R.id.checkBox3);

    public void next(View view) {
        CheckBox checkbox1 = findViewById(R.id.checkBox1);
        CheckBox checkbox2 = findViewById(R.id.checkBox2);
        CheckBox checkbox3 = findViewById(R.id.checkBox3);

        String checkedCheckboxData = "";
        if (checkBox1.isChecked()) {
            checkedCheckboxData += checkbox1.getText().toString() + ", ";
        }
        if (checkBox2.isChecked()) {
            checkedCheckboxData += checkBox2.getText().toString() + ", ";
        }
        if (checkBox3.isChecked()) {
            checkedCheckboxData += checkBox3.getText().toString() + ", ";
        }
        Toast.makeText(this, checkedCheckboxData, Toast.LENGTH_SHORT).show();

       
    
   

    

