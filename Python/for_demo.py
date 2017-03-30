#for x in ...循环就是把list里面的每个元素代入变量x，这样就能达到从0加到count的效果了
#list(range(101)),就是列出从0开始的101个整数，list(range(5))其实就是[0,1,2,3,4]
count=int(input("please input a number:"))
result=0
#nums = list(range(count+1))
#for num in nums:
#下面这一句等同于上面两句
for num in range(count+1):
 result=result+num
print("从0到",count,"的和是：",result)