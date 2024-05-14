package com.stemgon.stemly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stemgon.stemly.contacts.adapters.ContactRecyclerAdapter;
import com.stemgon.stemly.contacts.models.Contact;
import com.stemgon.stemly.contacts.services.ContactsAPIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
                .baseUrl("http://192.168.8.129:8000/")
//                .baseUrl("http://10.0.2.2:8000/")
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ContactsAPIService contactsAPIService = retrofit.create(ContactsAPIService.class);

//        ArrayList<Contact> contactList = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            contactList.add(new Contact(i, "Carington Muleya", "Snr Software Engineer Role"));
//        }
//
//        ContactRecyclerAdapter contactRecyclerViewAdapter = new ContactRecyclerAdapter(contactList, ContactsActivity.this);
        RecyclerView recyclerView = findViewById(R.id.contactsRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(ContactsActivity.this));
//        recyclerView.setAdapter(contactRecyclerViewAdapter);
        Call<List<Contact>> todosApiList = contactsAPIService.getTodos();
        todosApiList.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ContactsActivity.this, "Failed to fetch the tods", Toast.LENGTH_SHORT).show();
                }

                List<Contact> contactList = response.body();
                if( contactList != null ){
                    List<Contact> myContactList = new ArrayList<>(contactList);
                    ContactRecyclerAdapter contactRecyclerAdapter = new ContactRecyclerAdapter((ArrayList<Contact>) contactList, ContactsActivity.this);

                    LinearLayoutManager layoutManager = new LinearLayoutManager(ContactsActivity.this, LinearLayoutManager.VERTICAL, false);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(ContactsActivity.this));
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.addItemDecoration(
                            new DividerItemDecoration(ContactsActivity.this,
                                    DividerItemDecoration.HORIZONTAL));
                    // make the adapter the data set
                    // changed for the recycler view
                    recyclerView.setAdapter(contactRecyclerAdapter);




                }

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Toast.makeText(ContactsActivity.this, "Failed to fetch the tods", Toast.LENGTH_SHORT).show();
                Toast.makeText(ContactsActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }

        });

    }
}