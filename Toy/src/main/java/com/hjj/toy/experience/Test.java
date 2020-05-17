package com.hjj.toy.experience;

public class Test {

    /**
     * Junit4 基本注解
     *
     * @Before
     * 使用@Before注解一个public void 方法会使该方法在每个@Test注解方法被执行前执行（那么就可以在该方法中创建相同的对象）。
     * 父类的@Before注解方法会在子类的@Before注解方法执行前执行。
     *
     * @After
     * 使用@After注解一个public void方法会使该方法在每个@Test注解方法执行后被执行。即使在@Before注解方法、@Test注解方法中抛出了异常
     * ，所有的@After注解方法依然会被执行。
     * 父类中的@After注解方法会在子类@After注解方法执行后被执行。
     *
     * @Test
     * @Test注解的public void方法将会被当做测试用例，JUnit每次都会创建一个新的测试实例，然后调用@Test注解方法，任何异常的抛出都会认为
     * 测试失败。当以一个类为测试单元时，所有测试用例（测试方法）共属同一个测试实例（具有同一个环境）；当以一个方法为测试单元时，
     * JUnit每次都会创建一个新的测试实例。@Test注解提供2个参数：
     * 1，“expected”，定义测试方法应该抛出的异常，如果测试方法没有抛出异常或者抛出了一个不同的异常，测试失败；
     * 2，“timeout”，如果测试运行时间长于该定义时间，测试失败（单位为毫秒）。
     *
     * @BeforeClass
     * 使用@BeforeClass注解一个public static void 方法，并且该方法不带任何参数，会使该方法在所有测试方法被执行前执行一次，并且只执行
     * 一次。
     * 父类的@BeforeClass注解方法会在子类的@BeforeClass注解方法执行前执行。
     *
     * @AfterClass
     * 使用@AfterClass注解一个public static void方法会使该方法在测试类中的所有测试方法执行完后被执行。
     * 即使在@BeforeClass注解方法中抛出了异常，所有的@AfterClass注解方法依然会被执行。
     * 父类中的@AfterClass注解方法会在子类@AfterClass注解方法执行后被执行。
     *
     * @Ignore
     * 使用@Ignore注解将使被注解的类或方法不会被当做测试执行；JUnit执行结果中会报告被忽略的测试数。
     *
     * @FixMethodOrder
     * 测试类的测试方法执行顺序可通过对测试类添加注解 @FixMethodOrder(value)来指定,其中value 为执行顺序
     * MethodSorters.NAME_ASCENDING （推荐） **
     * 按方法名称的进行排序，由于是按字符的字典顺序，所以以这种方式指定执行顺序会始终保持一致；
     * 不过这种方式需要对测试方法有一定的命名规则，如 测试方法均以testNNN开头（NNN表示测试方法序列号 001-999） 。
     *
     * 测试套件suit
     *
     * SpringBoot 结合junit测试 & MockMVC
     *
     *
     * Mockito
     *
     *
     *

     */


}
