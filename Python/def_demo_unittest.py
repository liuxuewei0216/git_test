#单元测试类
##########################################
##执行单元测试方法
#方法1：直接运行python -m unittest **.py
#
#方法2：在本文件末尾加上下面两行，则直接执行python **.py即可
##if __name__ == '__main__':
##   unittest.main()
##########################################
#从def_demo文件中导入my_def,power两个函数
from def_demo import my_def,power
#导入python自带的单元测试模块
import unittest
#创建的测试类必须继承unittest.TestCase，测试方法必须以test开头，才会被认为是单元测试方法
class TestDef(unittest.TestCase):
 def test_my_def(self):
  result = my_def(1,2)
  self.assertEqual(result,1)
 def test_power(self):
  result1 = power(2,3)
  self.assertEqual(result1,8)



