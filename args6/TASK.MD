1.理解需求

1.1.传入一个程序的参数包含了“标记”（flag）和“值”（value）。

标记都是一个字母，前面加上“-”号（例如“-p”这样）。每个标记可以有一个值与之对应，也可以没有对应的值。

1.2.开发一个解析器（parser）来处理这些参数。

1.2.1.这个解析器需要一个参数结构（schema）来描述“这个程序应该接受哪些参数”的信息

应该有几个标记；
每个标记应该是什么类型；
每个标记的缺省值是什么。

解析器会首先验证参数列表是否与参数结构相匹配。

1.2.2.程序就可以向参数解析器查询每个参数的值（根据参数的标记名）。返回值的类型应该与参数结构中规定的类型相一致。

如果参数结构中规定了的标记在实际的参数列表中没有出现，那么就应该返回合理的缺省值，

例如布尔型的缺省值可以是False，数值型的缺省值可以是0，字符串型的缺省值可以是空字符串。

如果实际给出的参数与参数结构不匹配，需要给出良好的错误信息，解释清楚出错的原因。

1.3.扩展需求
    扩展代码，支持列表类型的参数。例如下列参数中：
    
2.外界如何使用

ArgumentParser argumentParser = new ArgumentParser([
new Schema('l', 'Boolean', 'false'),
new Schema('p', 'Integer', '0'),
new Schema('d', 'String', '')])

ArgsValue argsValue = ArgsParser.parse('-l -p 8080 -d /usr/logs')    

Boolean booleanValue = argsValue.getBoolean('l');
Integer integerValue = argsValue.getInteger('p');
String  stringValue  = argsValue.getString('d');

3.任务分解

3.1.单参数默认值

3.1.1.Boolean值 
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1: ok
     输入：[new Schema('l', 'Boolean', 'false')]  '-l'
     输出: false
     
   场景2: ok
     输入：[new Schema('l', 'Boolean', 'true')]  '-l'
     输出: true
     
3.1.2.Integer值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1：ok
      输入: [new Schema('p', 'Integer', '0')]  '-p'
      输出: 0
      
   场景2：ok
      输入: [new Schema('p', 'Integer', '8080')]  '-p'
      输出: 8080

3.1.3.String值
输入: schema:[Schema] args:String
输出: value:ArgsValue

   场景1：ok
      输入: [new Schema('d', 'String', '0')]  '-d'
      输出: '' 
      
   场景2：ok
      输入: [new Schema('d', 'String', '/usr/logs')]  '-d'
      输出: '/usr/logs'
   
3.2.单参数有值

3.2.1.Boolean值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1: ok
     输入：[new Schema('l', 'Boolean', 'false')]  '-l true'
     输出: true
     
   场景2: ok
     输入：[new Schema('l', 'Boolean', 'true')]  '-l  false'
     输出: false
     
3.2.2.Integer值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1：ok
      输入: [new Schema('p', 'Integer', '0')]  '-p 8080'
      输出: 8080
      
3.2.3.String值 ok
输入: schema:[Schema] args:String
输出: value:ArgsValue


3.3.多参数无值

3.3.1.Boolean值 + String值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1: ok
     输入：[new Schema('l', 'Boolean', 'false'), new Schema('d', 'String', '0')]  '-l -d'
     输出: l:false d:'0'
        
3.3.2.String值 + Integer值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1：ok
      输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', '0')]  '-p -d'
      输出: p:0  d:''
      
3.3.3.String值 + Integer值 + Boolean值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1：ok
      输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', '0'),new Schema('l', 'Boolean', 'false')]  '-p -d -l'
      输出: p:0  d:'' l:false
            
3.4.多参数有值 + 部分无值

3.4.1.Boolean值 + String值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1: ok
     输入：[new Schema('l', 'Boolean', 'false'), new Schema('d', 'String', '')]  '-l true -d /usr/logs21'
     输出: l:true d:'/usr/logs21'
     
   场景2: ok
       输入：[new Schema('l', 'Boolean', 'false'), new Schema('d', 'String', '')]  '-l true -d'
       输出: l:true d:''
       
   场景3: ok
        输入：[new Schema('l', 'Boolean', 'false'), new Schema('d', 'String', '')]  '-l -d /usr/logs21'
        输出: l:false d:'/usr/logs21'    
        
3.4.2.String值 + Integer值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1：ok
      输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', '')]  '-p 9999 -d /usr/logs22'
      输出: p:9999  d:'/usr/logs22'
      
3.4.3.String值 + Integer值 + Boolean值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1：ok
      输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', ''),new Schema('l', 'Boolean', 'false')] 
            '-p 7777 -d /usr/logs23 -l true'
      输出: p:7777  d:'/usr/logs23' l:true    
      
   场景2：ok
      输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', ''),new Schema('l', 'Boolean', 'false')] 
               '-p -d /usr/logs23 -l true'
      输出: p:0  d:'/usr/logs23' l:true    
   
   场景3：ok
      输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', ''),new Schema('l', 'Boolean', 'false')] 
                  '-p -d /usr/logs23 -l'
      输出: p:0  d:'/usr/logs23' l:false   
   
   场景4：ok
      输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', ''),new Schema('l', 'Boolean', 'false')] 
                  '-p 7777 -d -l'
      输出: p:7777  d:'' l:false                           
      
3.5.扩展字符串类型的列表 + 整数类型的列表

3.5.1.ListString值 + ListInteger值
输入: schema:[Schema]  args:String
输出: value:ArgsValue
   
   场景1: ok
     输入：[new Schema('g', 'ListString', ''), new Schema('d', 'ListInteger', '')]  '-g this,is,a,list -d 1,2,-3,5'
     输出: g:[“this”, “is”, “a”, “list”] d:[1, 2, -3, 5]
     
3.6.异常

3.6.1.获取不存在Schema中的参数值,提示不存在异常
输入: schema:[Schema]  args:String
输出: 提示不存在
   
   场景1：ok
         输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', ''),new Schema('l', 'Boolean', 'false')] 
               '-p 7777 -d /usr/logs23 -l true'
         输出: t:异常
   
3.6.2.当args中传入Schema中不存在的,提示异常
输入: schema:[Schema]  args:String
输出: 异常
   
   场景1：ok
         输入: [new Schema('p', 'Integer', '0'), new Schema('d', 'String', ''),new Schema('l', 'Boolean', 'false')] 
               '-p 7777 -d /usr/logs23 -l true -t 2222'
         输出: 异常 
         
      
      

    
    