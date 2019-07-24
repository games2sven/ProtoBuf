package com.example.sven.protobuf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tutorial.AddressBookProtos;
import com.google.protobuf.InvalidProtocolBufferException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        protoTest();
    }

    private void protoTest(){
        AddressBookProtos.Person.PhoneNumber.Builder builder
                = AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("110");
        AddressBookProtos.Person.Builder zs = AddressBookProtos.Person.newBuilder()
                .setName("张三")
                .setId(1)
                .addPhones(builder);
        AddressBookProtos.Person.PhoneNumber.Builder builder1
                = AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("120");
        AddressBookProtos.Person.Builder ls = AddressBookProtos.Person.newBuilder()
                .setName("李四")
                .setId(2)
                .addPhones(builder1);
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
                .addPeople(zs)
                .addPeople(ls).build();

        long l = System.currentTimeMillis();
        byte[] bytes = addressBook.toByteArray();
        Log.e(TAG, "protobuf 序列化耗时：" + (System.currentTimeMillis() - l));
        Log.e(TAG, "protobuf 序列化数据大小：" + bytes.length);
        try {
            l = System.currentTimeMillis();
            AddressBookProtos.AddressBook.parseFrom(bytes);
            Log.e(TAG, "protobuf 反序列化耗时：" + (System.currentTimeMillis() - l));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        JsonTest.fastJson();
        JsonTest.gson();
    }



}
