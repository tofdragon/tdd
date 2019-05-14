Args:

需求分析

1.The arguments consist of flags and values. 

<1>Flags should be one character, preceded by a minus sign.

<2>Each flag should have zero, or one value associated with it.

2.The program can then ask the args parser for each of the values, using the names of the flags

<1>The values are returned with the correct types

3.If a flag mentioned in the schema is missing in the arguments, a suitable default value should be returned

4.If the arguments given do not match the schema, it is important that a good error message is given

5.Make sure your code is extensible, in that it is straightforward and obvious how to add new types of values

<1>-g this,is,a,list -d 1,2,-3,5

任务列表

1.单个布尔值参数，有值和默认值

-l      获取的值为默认值false

-l true 获取的值为true

2.单个字符串参数,有值和默认值

-s      获取的值为默认值""

-s 21   获取的值为21     

3.单个整型参数,有值和默认值

-i      获取的值为默认值0

-i 22   获取的值为22

-i -1   获取的值为-1

4.混合多个类型

-l true -i 21 -s name

-l -i -s

-l -i -1 -s 23 

-i -l false -s

5.不合法的标记

-h  提示不合法

-l -i 21 -h 提示不合法

6.自定义类型

-port 8080 默认值为8000

-g 1,2,3,4 默认值为[]
