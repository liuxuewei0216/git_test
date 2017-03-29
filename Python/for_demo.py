#names=['liu','li','zhao','sun']
#names=[1,1,2,4]
#list(range(101)),就是列出从0到100的整数
#list(range(5))其实就是[0,1,2,3,4]
nums = list(range(101))
result=0
#for x in ...循环就是把每个元素代入变量x，这样就能达到从1加到100的效果了
for num in nums:
 result=result+num
print(result)