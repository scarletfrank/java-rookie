package pro.scarlet;

import java.util.function.*;

@FunctionalInterface
interface IMessage {
    public void send(String str);
}

@FunctionalInterface
interface IMath {
    public int add(int x, int y);
}

@FunctionalInterface
interface IFunction1<P, R> {
    public R change(P p);
}

@FunctionalInterface
interface IFunction2<R> {
    public R upper();
}

@FunctionalInterface
interface IFunction3<P> {
    public int compare(P p1, P p2);
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "姓名/年龄 " + this.name + "/" + this.age;
    }
}

@FunctionalInterface
interface IFunction4<R> {
    public R create(String s, int a);
}

public class LambdaDemo {
    public static void main(String[] args) {
        // lambda e.g.1
        IMessage msg = (str) -> {
            System.out.println("发送消息" + str);
        };
        msg.send("scarletfrank@outlook.com");
        // lambda e.g.2
        IMath math = (t1, t2) -> t1 + t2;
        System.out.println(math.add(10, 20));
        // 方法引用1
        IFunction1<Integer, String> fun1 = String::valueOf;
        String str = fun1.change(100);
        System.out.println(str.length());
        // 方法引用2
        IFunction2<String> fun2 = "frankscarlet.pro"::toUpperCase;
        System.out.println(fun2.upper());
        // 方法引用3
        IFunction3<String> fun3 = String::compareTo;
        System.out.println(fun3.compare("A", "a"));
        // 方法引用4
        IFunction4<Person> fun4 = Person::new;
        System.out.println(fun4.create("张三", 20));
        // 内建式函数性接口
        Function<String, Boolean> fun5 = "**hello"::startsWith;
        System.out.println(fun5.apply("**"));
        // 消费型函数式接口
        Consumer<String> fun6 = System.out::println;
        fun6.accept("消费了");
        // 供给型函数式接口
        Supplier<String> sup = "FRANKSCARLET"::toLowerCase;
        System.out.println(sup.get());
        // 断言型函数式接口
        Predicate<String> pred = "mldn" ::equalsIgnoreCase;
        System.out.println(pred.test("MLDN"));
    }
}
