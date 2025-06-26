package scripts;

import org.testng.annotations.*;

public class demotestng {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("beforesuite");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void verifybooking(){
        System.out.println("test case verifybooking");
    }
    @DataProvider(name = "logindata")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"username", "123"}, {"pw", "abc"}};
    }

    @Test(dataProvider = "logindata")
    public void verifyloginFAIL(){
        System.out.println("test case verify login");
    }
    @Test
    public void verifyloginpass(){
        System.out.println("test case verify login PASS");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }

}
