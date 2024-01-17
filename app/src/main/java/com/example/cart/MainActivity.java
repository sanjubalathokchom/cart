package com.example.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  {
    private List<ListItem> productList;
    private CustomListAdapter productAdapter;
    private ListView listView;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle back button click (e.g., go back to the previous screen)
                finish();
            }
        });

        listView = findViewById(R.id.listview1);
        add = findViewById(R.id.add);
        // TextView rateview = (TextView) findViewById(R.id.rateview);
        int total = 0;

        productList = new ArrayList<>();
        productList.add(new ListItem(R.drawable.download,"50", "Pepsi"));
        productList.add(new ListItem(R.drawable.cheesepopcorn, "100", "CheesePopcorn"));
        productList.add(new ListItem(R.drawable.frenchfry, "100", "French Fries"));

        productAdapter = new CustomListAdapter(this, (ArrayList<ListItem>) productList);
        listView.setAdapter(productAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productAdapter.calculateTotal(); // Calculate total price and quantity
                double totalPrice = productAdapter.getTotalPrice();
                int totalQuantity = productAdapter.getTotalQuantity();

                Intent intent = new Intent(MainActivity.this, MakePayment.class);
                intent.putExtra("totalPrice", totalPrice);
                intent.putExtra("totalQuantity", totalQuantity);
                startActivity(intent);

            }
        });
    }
}

/**private List<ListItem> productList;
    private CustomListAdapter productAdapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle back button click (e.g., go back to the previous screen)
                finish();
            }
        });

        listView = findViewById(R.id.listview1);
        button = findViewById(R.id.add);
        // TextView rateview = (TextView) findViewById(R.id.rateview);
        int total = 0;

        productList = new ArrayList<>();
        productList.add(new ListItem(R.drawable.download, 50, "Pepsi"));
        productList.add(new ListItem(R.drawable.cheesepopcorn, 100, "Cheese Popcorn"));
        productList.add(new ListItem(R.drawable.frenchfry, 100, "French Fries"));

        productAdapter = new CustomListAdapter(this, (ArrayList<ListItem>) productList);
        listView.setAdapter(productAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productAdapter.calculateTotal(); // Calculate total price and quantity
                double totalPrice = productAdapter.;
                int totalQuantity = productAdapter.getTotalQuantity();

                Intent intent = new Intent(MainActivity.this, MakePayment.class);
                intent.putExtra("totalPrice", totalPrice);
                intent.putExtra("totalQuantity", totalQuantity);
                startActivity(intent);

            }
        });
    }
}
  /**  ListView listview;
    HashMap<String,Integer> cart= new HashMap<>();
    CustomListAdapter customlistadapter;
    public int[] imageid={R.drawable.download,R.drawable.cheesepopcorn,R.drawable.frenchfry};
    Button add;
    public String[] names={"Pepsi","Cheesepopcorn","FrenchFries"};
    public int[] price={120,140,150};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview1);
        customlistadapter= new CustomListAdapter(this,imageid,names,price);
        listview.setAdapter(customlistadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String itemname=customlistadapter.getItem(position);
                final int cost=customlistadapter.getPrice(position);

                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(itemname+"has been selected")
                        .setPositiveButton("ok",(dialog, i) ->{
                            Toast.makeText(getApplicationContext(),itemname+"is added to the cart",Toast.LENGTH_SHORT).show();
                            cart.put(itemname,cost);
                        })
                        .setNegativeButton("cancel",null);
                AlertDialog alert= builder.create();
                alert.show();;

            });
        });




        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakePayment.class);
                intent.putExtra("Bill", cart);
                //intent.putExtra("totalQuantity", totalQuantity);
                startActivity(intent);
            }
        });
    }
    public void calculateBill(View view){

    }
}
   /** private List<ListItem> productList;
    private CustomListAdapter productAdapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle back button click (e.g., go back to the previous screen)
                finish();
            }
        });

        listView = findViewById(R.id.listview1);
        button = findViewById(R.id.add);
       // TextView rateview = (TextView) findViewById(R.id.rateview);
        int total = 0;

        productList = new ArrayList<>();
        productList.add(new ListItem(R.drawable.download, "50", "Pepsi"));
        productList.add(new ListItem(R.drawable.cheesepopcorn, "100", "Cheese Popcorn"));
        productList.add(new ListItem(R.drawable.frenchfry, "100", "French Fries"));

        productAdapter = new CustomListAdapter(this, (ArrayList<ListItem>) productList);
        listView.setAdapter(productAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productAdapter.calculateTotal(); // Calculate total price and quantity
                double totalPrice = productAdapter.getTotalPrice();
                int totalQuantity = productAdapter.getTotalQuantity();

                Intent intent = new Intent(MainActivity.this, MakePayment.class);
                intent.putExtra("totalPrice", totalPrice);
                intent.putExtra("totalQuantity", totalQuantity);
                startActivity(intent);

            }
        });
    }
}
   /** private List<ListItem> productList;
    private CustomListAdapter productAdapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview1);
        button = findViewById(R.id.add);
        TextView rateview = (TextView) findViewById(R.id.rateview);


        productList = new ArrayList<>();
        productList.add(new ListItem(R.drawable.gg,"89", "cookies"));
        productList.add(new ListItem(R.drawable.hh,"90", "biscuit"));
        productList.add(new ListItem(R.drawable.download,"89", "pepsi"));


        productAdapter = new CustomListAdapter(this, (ArrayList<ListItem>) productList);
        listView.setAdapter(productAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productList.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, MakePayment.class);

                    // Create arrays to store the data
                    ArrayList<String> productPrices = new ArrayList<>();
                    ArrayList<String> productNames = new ArrayList<>();

                    for (ListItem product : productList) {
                        // Get data for each product
                        String price = product.getPrice();
                        String name = product.getName();

                        // Add data to the arrays
                        productPrices.add(price);
                        productNames.add(name);
                    }

                    // Put the arrays as extras in the intent
                    intent.putStringArrayListExtra("selectedProductPrices", productPrices);
                    intent.putStringArrayListExtra("selectedProductNames", productNames);

                    startActivity(intent);
                }
                // Get the data from the first item in the list (you can modify this as needed)
               /** if (productList.size() > 0) {
                    ListItem selectedProduct = productList.get(0);
                    String data = selectedProduct.getPrice() ;
                    String name=  selectedProduct.getName() ;

                    // You can use an Intent to pass this data to another activity
                    Intent intent = new Intent(MainActivity.this, MakePayment.class);
                    intent.putExtra("selectedProductData", data);
                    startActivity(intent);
                }
            }
        });
    }
    private void updatePriceText(TextView textViewPrice, ListItem item) {
        int quantity = Integer.parseInt(item.getName().replaceAll("[\\D]", ""));
        double price = Double.parseDouble(item.getPrice());
        double total = price * quantity;
        textViewPrice.setText(String.format("Price: $%.2f", total));
    }
}*/

   /** private ArrayList<ListItem> itemList;
    TextView rateview;
    private String selectedItemName;  // Declare instance variable for the selected item name
    private String selectedItemPrice; // Declare instance variable for the selected item price

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button backButton = findViewById(R.id.back);
        rateview = findViewById(R.id.rateview);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        Button add = findViewById(R.id.add);

        setSupportActionBar(toolbar);

        ArrayList<ListItem> userList = getListData();
        final ListView lv = findViewById(R.id.listview1);
        lv.setAdapter(new CustomListAdapter(this, userList));

        lv.setOnItemClickListener((parent, view, position, id) -> {
            ListItem selectedItem = userList.get(position);
            selectedItemName = selectedItem.getName();   // Assign the selected item name
            selectedItemPrice = selectedItem.getPrice(); // Assign the selected item price
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedItemPosition = lv.getCheckedItemPosition();
                if (selectedItemPosition != AdapterView.INVALID_POSITION) {
                    String selectedItem = [selectedItemPosition];

                    // Create an Intent to navigate to another page (e.g., SecondActivity)
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                String no = rateview.getText().toString();

                // Use the instance variables selectedItemName and selectedItemPrice as needed
               // if (selectedItemName != null && selectedItemPrice != null) {
                    Intent intent = new Intent(MainActivity.this, MakePayment.class);
                    intent.putExtra("num", no);
                    intent.putExtra("selectedItemName", selectedItemName);
                    intent.putExtra("selectedItemPrice", selectedItemPrice);
                    startActivity(intent);
               // }
            }
        });
    }

    private ArrayList getListData() {
        ArrayList<ListItem>results= new ArrayList<>();
        ListItem user1=new ListItem();
        user1.setName(("Pepsi"));
        user1.setPrice("60");
        user1.setImage(R.drawable.download);
        results.add(user1);
        ListItem user2=new ListItem();
        user2.setName(("Biscuit"));
        user2.setPrice("60");
        user2.setImage(R.drawable.gg);
        results.add(user2);
        ListItem user3=new ListItem();
        user3.setName(("Marie"));
        user3.setPrice("60");
        user3.setImage(R.drawable.hh);
        results.add(user3);
        ListItem user4=new ListItem();
        user4.setName(("Popcorn"));
        user4.setPrice("60");
        user4.setImage(R.drawable.tt);
        results.add(user4);
        return results;
    }
}

   /** private ArrayList<ListItem> itemList;
    TextView rateview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button backButton = findViewById(R.id.back);
        rateview = findViewById(R.id.rateview);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        Button add = findViewById(R.id.add);

        setSupportActionBar(toolbar);

       // itemList = getListData();
      //  final ListView lv = findViewById(R.id.listview1);
       // lv.setAdapter(new CustomListAdapter(this, itemList));
        ArrayList<ListItem> userList = getListData();
        final ListView lv = findViewById(R.id.listview1);
        lv.setAdapter(new CustomListAdapter(this, userList));

        lv.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = userList.get(position).getName();
            String itemPrice = userList.get(position).getPrice();
            //rateview.setText("hii");

            Intent intent = new Intent(MainActivity.this, MakePayment.class);
            intent.putExtra("selectedItemText", selectedItem);
            intent.putExtra("selectedItemPrice", itemPrice);

            startActivity(intent);
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Pass the data to the next activity using an Intent
                    Intent intent = new Intent(MainActivity.this, MakePayment.class);
                String no = rateview.getText().toString();
                intent.putExtra("num", no);
                    startActivity(intent);
                }
        });
    }

    private ArrayList getListData() {
        ArrayList<ListItem>results= new ArrayList<>();
        ListItem user1=new ListItem();
        user1.setName(("Pepsi"));
        user1.setPrice("60");
        user1.setImage(R.drawable.download);
        results.add(user1);
        ListItem user2=new ListItem();
        user2.setName(("Biscuit"));
        user2.setPrice("60");
        user2.setImage(R.drawable.gg);
        results.add(user2);
        ListItem user3=new ListItem();
        user3.setName(("Marie"));
        user3.setPrice("60");
        user3.setImage(R.drawable.hh);
        results.add(user3);
        ListItem user4=new ListItem();
        user4.setName(("Popcorn"));
        user4.setPrice("60");
        user4.setImage(R.drawable.tt);
        results.add(user4);
        return results;
    }
    }

   /** private ArrayList<String> classSectionList;
    TextView rateview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button backButton  = findViewById(R.id.back);
        rateview=findViewById(R.id.rateview);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();

            }
        });

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        Button add=(Button)findViewById(R.id.add);



        setSupportActionBar(toolbar);

        ArrayList userList=getListData();
        final ListView lv=(ListView) findViewById(R.id.listview1);
        lv.setAdapter(new CustomListAdapter(this,userList));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setOnItemClickListener((parent, view, position, id) -> {
                    String selectedItem = classSectionList.get(position);
                    String[] parts = selectedItem.split(" - ");
                    String className = parts[0];
                    String section = parts[1];
                    String no = rateview.getText().toString();
                    Intent intent = new Intent(MainActivity.this, MakePayment.class);
                    intent.putExtra("selectedItemText", className);
                    intent.putExtra("selectedItemText2", section);
                    intent.putExtra("num", no);
                    startActivity(intent);
                });
            }
            });
        }
    private ArrayList getListData() {
        ArrayList<ListItem>results= new ArrayList<>();
        ListItem user1=new ListItem();
        user1.setName(("Pepsi"));
        user1.setPrice("60");
        user1.setImage(R.drawable.download);
        results.add(user1);
        ListItem user2=new ListItem();
        user2.setName(("Biscuit"));
        user2.setPrice("60");
        user2.setImage(R.drawable.gg);
        results.add(user2);
        ListItem user3=new ListItem();
        user3.setName(("Marie"));
        user3.setPrice("60");
        user3.setImage(R.drawable.hh);
        results.add(user3);
        ListItem user4=new ListItem();
        user4.setName(("Popcorn"));
        user4.setPrice("60");
        user4.setImage(R.drawable.tt);
        results.add(user4);
        return results;
    }
}

       /** lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem selectedItem=(ListItem) lv.getItemAtPosition(position);
                String selectedItemText = selectedItem.getName();
                String selectedItemText2 = String.valueOf(selectedItem.getPrice());
                Toast.makeText(MainActivity.this, "Selected :"+" "+selectedItem.getName(), Toast.LENGTH_SHORT).show();
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String no= rateview.getText().toString();
                        Intent intent = new Intent(MainActivity.this, MakePayment.class);
                        //  intent.putExtra("selectedItemText", selectedItemText);
                        // intent.putExtra("selectedItemText2", selectedItemText2);
                        intent.putExtra("num", no);
                        startActivity(intent);
                    }
                });
            }
        });*/


        //getroomdata();
    //}




    /**public void getroomdata()
    {

        ArrayList userList=getListData();
        ListView listview1=findViewById(R.id.listview1);
        listview1.setAdapter(new CustomListAdapter(this,userList));

        List<ListItem> products=getListData();

        Adapter adapter=new Adapter(products, rateview);
        listview1.setAdapter(adapter);

        int sum=0,i;
        for(i=0;i< products.size();i++)
            sum=sum+(products.get(i).getPrice()*products.get(i).getQnt());

        rateview.setText("Total Amount : INR "+sum);
    }*/

