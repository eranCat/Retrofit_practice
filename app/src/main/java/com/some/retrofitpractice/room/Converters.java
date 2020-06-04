package com.some.retrofitpractice.room;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.some.retrofitpractice.models.Address;
import com.some.retrofitpractice.models.Company;

public class Converters {
    @TypeConverter
    public static String addressToString(Address address) {
        return new Gson().toJson(address);
    }

    @TypeConverter
    public static Address stringToAddress(String address) {
        return new Gson().fromJson(address, Address.class);
    }


     @TypeConverter
    public static String companyToString(Company company) {
        return new Gson().toJson(company);
    }

    @TypeConverter
    public static Company stringToCompany(String company) {
        return new Gson().fromJson(company, Company.class);
    }



}
