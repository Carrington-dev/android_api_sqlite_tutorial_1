package com.stemgon.stemly.contacts.services;

import com.stemgon.stemly.contacts.models.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsAPIService {
//    @GET("posts")
    @GET("api/v1/contacts/")
    Call<List<Contact>> getTodos();
}
