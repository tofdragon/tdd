需求描述1：

写一个程序，打印出从1到100的数字，将其中3的倍数替换成“Fizz”，5的倍数替换成“Buzz”。既能被3整除、又能被5整除的数则替换成“FizzBuzz”。

要求：每行代码都必须有单元测试覆盖。

需求描述2：

如果一个整数能被3整除，或者包含数字3，那么这个数字就是Fizz

如果一个整数能被5整除，或者包含数字5，那么这个数字就是Buzz


任务拆解:

1.创建一个对象，这个对象可以对输入的数字做必要的转换，输出一个字符串（可能是“Fizz”、“Buzz”、“FizzBuzz”，或者是原数字的字符串形式）。

2.创建一个列表，其中包含从1到100的整数，依次使用前面说的这个对象进行转换，转换后的结果是另一个长度为100的列表。

3.打印输出任务2得到的结果列表。