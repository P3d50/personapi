package com.p3d50.personapi.utils;

import com.p3d50.personapi.entity.Phone;
import com.p3d50.personapi.enums.PhoneType;

import java.util.ArrayList;
import java.util.List;

public class PhoneUtils {


    public static List<Phone> getDefaultPhonesList() {
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setType(PhoneType.MOBILE_PHONE);
        phone.setNumber("(11)977774545");
        phones.add(phone);
         return phones;
    }
}
