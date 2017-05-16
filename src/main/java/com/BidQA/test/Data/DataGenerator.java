package com.BidQA.test.Data;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by shail on 5/10/2017.
 */
public class DataGenerator {
    public String randomFirstNameChars = RandomStringUtils.randomAlphabetic(7).toLowerCase();
    public String randomLastnameChars= RandomStringUtils.randomAlphabetic(7).toLowerCase();
    public String randomUsernameChars = RandomStringUtils.randomAlphanumeric(10).toLowerCase();

    public String randomEmailChars = randomUsernameChars + "@mailinator.com";
    public String randomTitleChars = RandomStringUtils.randomAlphabetic(12).toLowerCase();
    public String randomDescription = RandomStringUtils.randomAlphabetic(18).toLowerCase();
    public String randomTagsChars = RandomStringUtils.randomAlphabetic(5).toLowerCase();

    public String usernameChars="mickey";
    public String popwd ="abcd";
    public String addressChars = "123 abc wxyz";
    public String pwdChars = "123456";
    public String repwdChars = "123456";
    public String titleChars = "Happy Sunny Day";
    public String descriptionChars = "Have a happy summer";

}
