package com.BidQA.test.Data;

import com.BidQA.test.Data.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by shail on 5/12/2017.
 */
public class DataProviderClass {
    @DataProvider(name ="LoginData")
        public static Object[][] getData() {

            // The number of times data is repeated, test will be executed the same no. of times

            // Here it will execute 1 times
            Object[][] data = new Object[1][1];
            // 1st row
            data[0][0]="minnie";
            data[0][1]="1234";
            /*//2nd row
            data[1][0]="cool";
            data[1][1]="12345";*/

            return data;

    }
}
