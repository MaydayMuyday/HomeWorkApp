package lesson7;


public class MyTest {

    @BeforeSuite
    public static void test2() {
        System.out.println("test2 BeforeSuite");
    }

    @Test(priority = 2)
    public static void test7() {
        System.out.println("test8 priority = 2");
    }

    @Test()
    public static void test8() {
        System.out.println("test8 priority = default");
    }

    @Test(priority = 8)
    public static void test1() {
        System.out.println("test1 priority = 8");
    }

    @Test(priority = 6)
    public static void test3() {
        System.out.println("test3 priority = 6 ");
    }

    @Test(priority = 5)
    public static void test4() {
        System.out.println("test4 priority = 5 ");
    }

    @AfterSuite
    public static void test9() {
        System.out.println("test5 AfterSuite");
    }
}
