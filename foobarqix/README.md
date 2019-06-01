FooBarQix

需求分析:

a function String compute(String) which implements the following rules.

Rules
If the number is divisible by 3, write “Foo” instead of the number
If the number is divisible by 5, add “Bar”
If the number is divisible by 7, add “Qix”
For each digit 3, 5, 7, add “Foo”, “Bar”, “Qix” in the digits order.

Examples
1  => 1
2  => 2
3  => FooFoo (divisible by 3, contains 3)
4  => 4
5  => BarBar (divisible by 5, contains 5)
6  => Foo (divisible by 3)
7  => QixQix (divisible by 7, contains 7)
8  => 8
9  => Foo
10 => Bar
13 => Foo
15 => FooBarBar (divisible by 3, divisible by 5, contains 5)
21 => FooQix
33 => FooFooFoo (divisible by 3, contains two 3)
51 => FooBar
53 => BarFoo

任务：

~~1.输入1, 输出1~~

~~2.输入6，输出Foo~~

~~3.输入10, 输出Bar~~

~~4.输入49，输出Qix~~

~~5.输入3，输出FooFoo~~

~~6.输入5，输出BarBar~~

~~7.输入7, 输出QixQix~~

~~8.输入15, 输出FooBarBar~~

~~9.输入33,输出FooFooFoo~~

~~10.输入51,输出FooBar~~