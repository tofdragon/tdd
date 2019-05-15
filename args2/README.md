Args

需求分析：

1.The arguments passed to the program consist of flags and values

<1>Flags should be one character, preceded by a minus sign

<2>Each flag should have zero, or one value associated with it

2.This parser takes a schema detailing what arguments the program expects

<1>The schema specifies the number and types of flags and values the program expects

3.The program can then ask the args parser for each of the values, using the names of the flags

<1>The values are returned with the correct types, as specified in the schema.

4.If a flag mentioned in the schema is missing in the arguments, a suitable default value should be returned

5.If the arguments given do not match the schema, it is important that a good error message is given, 

explaining exactly what is wrong.
 
5.-l -p 8080 -d /usr/logs

this indicates a schema with 3 flags: l, p, d. The “l” (logging) flag has no values associated with it, 

it is a boolean flag, True if present, False if not. the “p” (port) flag has an integer value, 

and the “d” (directory) flag has a string value.

6.If you are feeling ambitious, extend your code to support lists eg
  
  -g this,is,a,list -d 1,2,-3,5
  
So the “g” flag indicates a list of strings, [“this”, “is”, “a”, “list”] 
 
and the “d” flag indicates a list of integers, [1, 2, -3, 5].
  
  7:50
任务列表：

1.布尔值

-l        获取值false  ok

-l true   获取值true   ok

2.字符串

-s        获取值""     ok

-s my     获取值my     ok

3.整型

-i        获取值0      ok

-i 22     获取值22     ok

-i -2     获取值-2     ok

4.组合

-l -s -i             分别获取值 false "" 0 ok

-l true -s my -i     分别获取值 true my 0  ok

-s -l -i 23          分别获取 "" false 23  ok

-s my -l false -i 23 分别获取 my false 23  ok

-s my -i -1 -l       分别获取 my -1 false

5.不合法

-h      提示不合法   ok

-s my -l false -h 23 提示不合法

6.自定义

-port 默认值8000

-g 1,2,3,4 默认值空List