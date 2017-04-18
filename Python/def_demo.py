#简单的函数
def my_def(x,y):
 if x<y:
  return y-x
 if x>y:
  return x-y
 if x==y:
  return 0
#计算x的n次幂,参数n可以不传、默认为2
def power(x,n=2):
 result=1
 while n>0:
  n=n-1
  result=result*x
 return result

#在函数中调用函数（abs函数的用途是取绝对值）
def add(a,b):
 return abs(a)+abs(b)

#计算x的平方
def f(x):
 return x*x

