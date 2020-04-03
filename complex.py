# Jiangxiao Xie xiexx647
# I understand that this is a graded, individual examination that may not be
# discussed with anyone. I also understand that obtaining solutions or
# partial solutions from outside sources, or discussing any aspect of the exam
# with anyone is academiac misconduct and will result in failing the course.
# I further certify that this program represents my own work and that none of
# it was obtained from any source other than material presented as part of the
# course.

class Complex:
    def __init__(self,real=0,imag=0):
        self.__real = real
        self.__imag = imag
    def __repr__(self):
        if self.__imag == 0:
            return str(self.__real)
        if self.__imag<0:
            return "{0} - {1}i".format(self.__real,-self.__imag)
        return "{0} + {1}i".format(self.__real,self.__imag)
    def setReal(self,real):
        self.__real = real
    def getReal(self):
        return self.__real
    def setImag(self,imag):
        self.__imag = imag
    def getImag(self):
        return self.__imag
    def __add__(self,other):
        return Complex(self.__real+other.__real,self.__imag+other.__imag)
    def __mul__(self,other):
        real = self.__real * other.__real - self.__imag * other.__imag
        imag = self.__real * other.__imag + self.__imag * other.__real
        return Complex(real,imag)
    def __abs__(self):
        return (self.__real**2 + self.__imag**2) ** (1/2)
