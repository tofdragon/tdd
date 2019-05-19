Anagrams

需求分析:

1.given a file containing one word per line [给定一个文件,每行包含一个单词]

<1>print out all the combinations of words that are anagrams [打印同为字谜的所有单词组合] 

<2>each line in the output contains all the words from the input that are anagrams of each other [输出的每行包含所有的单词]

For example, your program might include in its output:

kinship pinkish
enlist inlets listen silent
boaster boaters borates
fresher refresh
sinks skins
knits stink
rots sort

<3>find the longest words that are anagrams [单词最长的字谜]

<4>find the set of anagrams containing the most words [包含最多单词的字谜]

<5>can you write unit tests to verify that your code is working correctly before setting it to work on the full dictionary

14:32

任务分解:

1. 判断两个单词是字谜 [最后删除这个单元测试]

ab   ba

ef   fe

2. 判断两个单词不是字谜 [最后删除这个单元测试]

ab  ac

ab  bc

ab  ef

3. 判断三个单词是字谜 [最后删除这个单元测试]

abc acb bac bca cab abc

4. 判断三个单词不是字谜 [最后删除这个单元测试]

abc abe acf bca

5.包含单词最多的字谜

kinship pinkish
enlist inlets listen silent
boaster boaters borates
fresher refresh
sinks skins
knits stink
rots sort

<5-0> 给定很多单词,找出同字谜的 [在处理此任务时,新增需要完成]
<a>只有一个同字谜的返回
<b.>有多个同字谜的返回


6.单词最长的字谜 

7.包含单词最多的字谜
 
[完成6,7后,发现1,2,3,4单元测试可以删除,但是1,2,3,4单元测试调用的判断方法
对之后的任务有很大的帮助作用]

8.性能测试