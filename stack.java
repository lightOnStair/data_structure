class RunnyStack<Base>
{
  private class Run
  {
    private Base object;
    private int length;
    private Run next;

    private Run(Base object,int length,Run next)
    {
      this.object = object;
      this.length = length;
      this.next = next;
    }
  }
  private Run top;

  public RunnyStack()
  {
    top = null;
  }
  public int depth()
  {
    int count = 0;
    Run temp = top;
    if(isEmpty())
    {
      return count;
    }

    while(true)
    {
      if(temp == null)
      {
        return count;
      }
      else
      {
        count += temp.length;
        temp = temp.next;
      }
    }
  }
  public boolean isEmpty()
  {
    return top == null;
  }
  public Base peek()
  {
    if(isEmpty())
    {
      throw new IllegalStateException("the stack is empty");
    }
    else
    {
      return top.object;
    }
  }
  public void pop()
  {
    if(isEmpty())
    {
     throw new IllegalStateException("the stack is empty");
    }
    else if(top.length > 1)
    {
     top.length -= 1;
    }
    else
    {
      top = top.next;
    }
  }
  public boolean isEqual(Base object1, Base object2)
  {
    if(object1 == null || object2 == null)
    {
      if(object1 == object2)
      return true;
    }
    else
    {
      if(object1.equals(object2))
      {
        return true;
      }
    }
      return false;
  }
  public void push(Base object)
  {
    if(isEmpty())
    {
      top = new Run(object,1,top);
    }
    else if(isEqual(object,top.object))
    {
        top.length += 1;
    }
    else
    {
      top = new Run(object,1,top);
    }
  }
  public int runs()
  {
    int count = 0;
    Run temp = top;
    if(isEmpty())
    {
      return count;
    }
    while(true)
    {
      if(temp == null)
      {
        return count;
      }
      else
      {
        count += 1;
        temp = temp.next;
      }
    }
  }
}

class stack
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     1 point
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }

    s.push("A");
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    System.out.println(s.isEmpty());         //  false      1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  2          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  6          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    s.pop();
    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
  }
}
