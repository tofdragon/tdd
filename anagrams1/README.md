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


任务分解:

1.给定一个单词，返回字谜数量为1,且字谜单词是传入

a 1 a

2.给定2个单词

<1>同为字谜的两个单词,返回字谜数量为1,且字谜单词是传入的两个

ab ba  1

<2>为不同的两个字谜,返回字谜数量为2,分别是两个

ab bc  2

<3>

abc abc bca efg fj cba

3.多个单词
kinship pinkish
enlist inlets listen silent
boaster boaters borates
fresher refresh
sinks skins
knits stink
rots sort


4.包含单词最多的字谜

kinship pinkish
enlist inlets listen silent
boaster boaters borates
fresher refresh
sinks skins
knits stink
rots sort

5.单词最长的字谜 

6.性能测试