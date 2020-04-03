# Jiangxiao Xie xiexx647 
# I understand that this is a graded, individual examination that may not be
# discussed with anyone. I also understand that obtaining solutions or
# partial solutions from outside sources, or discussing any aspect of the exam
# with anyone is academiac misconduct and will result in failing the course.
# I further certify that this program represents my own work and that none of
# it was obtained from any source other than material presented as part of the
# course.

class Mandelbrot:
    def __init__(self,c0,limit=50):
        self.__limit = limit
        if abs(c0) > 2:
            self.__cardinality = 0
        else:
            i = 1
            value = c0
            while i <= self.__limit:
                value = value*value + c0
                if abs(value) > 2:
                    self.__cardinality = i
                    break
                i += 1
            if i == 51:
                self.__cardinality = 50
        self.__colormap = ["red","orange","yellow","purple","black"]
    def get_color(self):
        if self.__cardinality < 10 :
            return self.__colormap[0]
        elif self.__cardinality < 20:
            return self.__colormap[1]
        elif self.__cardinality < 30:
            return self.__colormap[2]
        elif self.__cardinality < 40:
            return self.__colormap[3]
        elif self.__cardinality <=50:
            return self.__colormap[4]
