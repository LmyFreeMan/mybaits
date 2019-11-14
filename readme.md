**mybaits学习记录几个要点**

**一:参数传递**

1.单值:#{id}sql语句获取指定的值<br/>
2.多个参数 #{param1} #{param2}(若参数为对象则需要param1.key)||javabean||map

**二:返回值**

list:配置对应sql映射的时候，指定resultType并不是list,而是list集合中的泛型。<br/>
map:目标接口的上边:@MapKey("属性")

**三：缓存分类**

一级缓存:Sqlsession都会启动一个属于自己的内存空间，自动开启<br/>
二级缓存：对整个命名空间有效


