# Jiangxiao Xie xiexx647
# I understand that this is a graded, individual examination that may not be
# discussed with anyone. I also understand that obtaining solutions or
# partial solutions from outside sources, or discussing any aspect of the exam
# with anyone is academiac misconduct and will result in failing the course.
# I further certify that this program represents my own work and that none of
# it was obtained from any source other than material presented as part of the
# course.

import turtle
from complex import Complex
from mandelbrot import Mandelbrot
class Display:
    def __init__(self):
        turtle.tracer(2000,0)
        turtle.delay(0)
        self.t = turtle.Turtle()
        self.t.hideturtle()
        self.t.speed(0)
        self.t.pensize(1)
        self.execute = False
        self.scr = self.t.getscreen()
        self.scr.onclick(self.click)
        self.scr.listen()
        self.maxcp = 4
        self.maxtp = 300
        self.cx = 0
        self.cy = 0
        self.draw()


    def click(self,x,y):
        if x >= -150 and x <= 150 and y >= -150 and y <= 150 and self.execute == True:
            self.zoom(x,y)

    def zoom(self,x,y):
        self.t.clear()
        self.cx += x/self.maxtp*self.maxcp
        self.cy += y/self.maxtp*self.maxcp
        self.maxcp /= 2
        self.draw()

    def draw(self):
        self.execute = False
        for i in range(-150,150):
            for j in range(-150,150):
                complexnum = Complex(self.cx+self.maxcp/self.maxtp*i,self.cy+self.maxcp/self.maxtp*j)
                mandelbrot = Mandelbrot(complexnum)
                self.t.penup()
                self.t.goto(i,j)
                self.t.pendown()
                self.t.pencolor(mandelbrot.get_color())
                self.t.forward(1)
        self.execute = True

def main():
    mandelbrot_fractal = Display()

if __name__ == '__main__':
    main()
