#单元测试类
#运行下面的命令即可执行单元测试
#python -m unittest def_demo_test.py
#从def_demo文件中导入my_def,power两个函数
from def_demo import my_def,power
#导入python自带的单元测试模块
import unittest
#创建的测试类必须继承unittest.TestCase，测试方法必须以test开头
class TestDef(unittest.TestCase):
 def test_my_def(self):
  result = my_def(1,2)
  self.assertEqual(result,1)
 def test_power(self):
  result1 = power(2,3)
  self.assertEqual(result1,8)


