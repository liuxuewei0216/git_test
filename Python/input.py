#python默认的是str类型，无法进行计算，因此使用int(Number1)将str类型转为int类型
#同理也可以使用str(Number1)将int类型转为str类型
#就本人目前的水平来说还不知道有没有直接定义一个变量为整型的方法
Number1=input("enter number1:")
Number2=input("enter number2:")
Number3=int(Number1)+int(Number2)
print('Number1 + Number2 =',Number3)