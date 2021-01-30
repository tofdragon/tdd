任务分解
1.Boolean类型的
1.1. 类型,默认值，名称

2.字符串类型
3.整型类型
4.四个混合



1.单参数

1.1 -l 布尔值

# 布尔值解析

输入: 
  -l boolean false : String
  -l 布尔值|无 : String
输出:
  布尔值|默认值  
  
   输入: -l true 
   输出: true           ok

   输入: -l false       ok
   输出: false

   输入：-l             ok
   输出: 默认值false

# 整型

输入: 
  -p Integer "" : String
  -p 整型值   : String
输出:
  整型值|默认值  

   输入: -p 8080     ok
   输出: 8080

   输入: -p 7777      ok
   输出: 7777

   输入: -p         ok
   输出: 0


# 字符串

输入：-d /usr/logs
输出: /usr/logs

输入: -d /user/logs21
输出: /user/logs21

输入: -d
输出: ""

2.多参数
2.1.  -l -p                ok
2.2.  -l 默认值  -p        ok
2.3.  -l -p 默认值         ok
2.4.  -l -p -d             ok 
2.5.  -l 默认值 -p 默认值 -d
2.6.  -l -p -d默认值
2.7   -l -p 默认值 -d
2.8.  -l 默认值 -p 默认值 -d
2.9.  -l 默认值 -p -d 默认值
2.9.  -l 默认值 -p 默认值 -d 默认值   ok
