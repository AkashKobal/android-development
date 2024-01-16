public class ToDOlist {
    
}
 /////////////////////////// Todo List

 editText=findViewById(R.id.teditText);listView=findViewById(R.id.listview);button=(Button)findViewById(R.id.button);
 ArrayList<String> listOfItem = new ArrayList<>();
 ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
         listOfItem);listView.setAdapter(adapter);

 button.setOnClickListener(new View.OnClickListener(){

 public void onClick(View v) {
         String item = editText.getText().toString();
         listOfItem.add(item);
         adapter.notifyDataSetChanged();
     }
 }

         //Remove item from list

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 String item = parent.getItemAtPosition(position).toString();

                 listOfItem.remove(item);

                 adapter.notifyDataSetChanged();
             }
         });
